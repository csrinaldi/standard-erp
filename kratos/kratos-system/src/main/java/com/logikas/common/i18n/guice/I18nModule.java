package com.logikas.common.i18n.guice;

import com.google.common.base.Preconditions;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public abstract class I18nModule extends AbstractModule {

  private static boolean eagerValidation = true;

  public static synchronized void disableEagerValidation() {
    Preconditions.checkArgument(eagerValidation, "Eager validation already disabled");
    eagerValidation = false;
  }

  private static class MessageInterpolator {

    private final String key;

    private final Provider<ResourceBundle> bundle;

    public MessageInterpolator(String key, Provider<ResourceBundle> bundle) {
      this.bundle = bundle;
      this.key = key;
    }

    public String interpolate(Object[] arguments) {
      return new MessageFormat(bundle.get().getString(key), bundle.get().getLocale())
          .format(arguments);
    }
  }

  protected class NamedBundleBuilder {

    private final String bundleName;

    private final Provider<ResourceBundle> bundleProvider;

    NamedBundleBuilder(String name, Provider<ResourceBundle> bundleProvider) {
      this.bundleName = name;
      this.bundleProvider = bundleProvider;
    }

    public void to(Key<?> bundleKey) {
      bindBundleImplementation(bundleName, bundleKey, bundleProvider);
    }

    public void to(TypeLiteral<?> bundleLiteral) {
      to(Key.get(bundleLiteral));
    }

    public void to(Class<?> bundleLiteral) {
      to(Key.get(bundleLiteral));
    }
  }

  private static <T> T createImplementation(Class<T> iface,
      Provider<ResourceBundle> bundleProvider, ResourceBundle check) {

    final HashMap<String, MessageInterpolator> formats = new HashMap<String, MessageInterpolator>();

    for (final Method method : iface.getMethods()) {

      if (!method.getDeclaringClass().equals(Object.class)) {

        final String resourceName;

        final javax.inject.Named javaxNamed = method.getAnnotation(javax.inject.Named.class);
        if (javaxNamed != null) {
          resourceName = javaxNamed.value();
        } else {
          final Named guiceNamed = method.getAnnotation(Named.class);
          resourceName = guiceNamed != null ? guiceNamed.value() : method.getName();
        }

        Preconditions.checkArgument(String.class.isAssignableFrom(method.getReturnType()),
            "Method '%s' must return type %s", method, String.class.getName());

        Preconditions.checkArgument(!formats.containsKey(resourceName),
            "Too many resources with key '%s' in interface %s", resourceName, iface.getName());

        Preconditions.checkArgument(check.containsKey(resourceName),
            "There is not resource with key '%s' for method '%s'", resourceName, method);

        formats.put(resourceName, new MessageInterpolator(resourceName, bundleProvider));
      }
    }

    final InvocationHandler handler = new InvocationHandler() {

      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return formats.get(method.getName()).interpolate(args);
      }
    };

    @SuppressWarnings("unchecked")
    final T proxy =
        (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
            new Class<?>[] {iface}, handler);

    return proxy;
  }

  @Override
  protected final void configure() {
    requireBinding(Locale.class);
    configureResources();
  }

  protected abstract void configureResources();

  private Provider<ResourceBundle> bindBundleProvider(final String bundleName) {

    if (eagerValidation) {
      try {
        ResourceBundle.getBundle(bundleName);
      } catch (Exception e) {
        addError(e);
        return null;
      }
    }

    final Provider<ResourceBundle> provider = new Provider<ResourceBundle>() {

      @Inject
      Provider<Locale> locale;

      @Override
      public ResourceBundle get() {
        return ResourceBundle.getBundle(bundleName, locale.get());
      }
    }; 
    bind(ResourceBundle.class).annotatedWith(Names.named(bundleName)).toProvider(provider);

    return provider;
  }

  private <T> void bindBundleImplementation(String bundleName, Key<T> bundleKey,
      final Provider<ResourceBundle> bundleProvider) {

    if (bundleProvider == null) {
      return;
    }

    @SuppressWarnings("unchecked")
    final Class<T> iface = (Class<T>) bundleKey.getTypeLiteral().getRawType();

    if (!(bundleKey.getTypeLiteral().getType() instanceof Class) || !iface.isInterface()) {
      addError("Bundle implementation requires interface types");
      return;
    }

    if (eagerValidation) {
      try {
        bind(bundleKey).toInstance(
            createImplementation(iface, bundleProvider, ResourceBundle.getBundle(bundleName)));
      } catch (Exception e) {
        addError(e);
      }
    } else {
      bind(bundleKey).toProvider(new Provider<T>() {
        @Override
        public T get() {
          return createImplementation(iface, bundleProvider, bundleProvider.get());
        }
      }).in(Singleton.class);
    }
  }

  protected NamedBundleBuilder bindBundle(String bundleName) {
    return new NamedBundleBuilder(bundleName, bindBundleProvider(bundleName));
  }

  protected void bindBundle(Key<?> bundleKey) {
    bindBundle(bundleKey.getTypeLiteral().getRawType().getName()).to(bundleKey);
  }

  protected void bindBundle(TypeLiteral<?> bundleLiteral) {
    bindBundle(bundleLiteral.getRawType().getName()).to(bundleLiteral);
  }

  protected void bindBundle(Class<?> bundleInterface) {
    bindBundle(bundleInterface.getName()).to(bundleInterface);
  }
}
