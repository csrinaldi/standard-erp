package com.logikas.common.cache.guice;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.inject.Provider;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
class CacheInterceptor implements MethodInterceptor, Provider<Map<Method, Cache<Object, Object>>> {

  private final Map<Method, Cache<Object, Object>> cacheMap;

  private final Set<Method> wrappedArguments = new HashSet<Method>();

  public CacheInterceptor() {
    cacheMap = new HashMap<Method, Cache<Object, Object>>();
  }

  public void addCache(Method method, Cache<Object, Object> cache, boolean wrapSingleArguments) {
    cacheMap.put(method, cache);
    if (wrapSingleArguments) {
      wrappedArguments.add(method);
    }
  }

  @Override
  public Map<Method, Cache<Object, Object>> get() {
    return Collections.unmodifiableMap(cacheMap);
  }

  @Override
  public Object invoke(final MethodInvocation invocation) throws Throwable {

    final Cache<Object, Object> cache = cacheMap.get(invocation.getMethod());

    try {
      return cache.get(createKey(invocation), new Callable<Object>() {

        @Override
        public Object call() throws Exception {

          try {

            return invocation.proceed();
          } catch (Exception e) {

            throw e;
          } catch (Error e) {

            throw e;
          } catch (Throwable e) {

            throw new ByPassException(e);
          }
        }
      });

    } catch (ExecutionException e) {

      final Throwable cause = e.getCause();

      if (cause instanceof ByPassException) {
        throw cause.getCause();
      }

      throw cause;
    } catch (Throwable t) {

      if (t instanceof UncheckedExecutionException || t instanceof ExecutionError) {
        throw t.getCause();
      }

      throw t;
    }
  }

  private Object createKey(MethodInvocation invocation) {

    final Object[] arguments = invocation.getArguments();

    Preconditions.checkArgument(arguments.length > 0);

    if (arguments.length > 1 || wrappedArguments.contains(invocation.getMethod())) {
      return Arrays.asList(arguments);
    }

    return arguments[0];
  }
}
