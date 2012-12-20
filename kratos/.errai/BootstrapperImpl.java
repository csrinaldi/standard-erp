package org.jboss.errai.ioc.client;

import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.InsertPanel.ForIsWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.HelloWorldClient;
import java.lang.annotation.Annotation;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Provider;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.ioc.client.api.builtin.RequestDispatcherProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.api.builtin.SenderProvider;
import org.jboss.errai.ioc.client.container.CreationalCallback;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.PageTransitionProvider;

public class BootstrapperImpl implements Bootstrapper {
  {
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
  }
  private final Any _1998831462Any_24824501 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Default _1998831462Default_1952014 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_25490828 = new Annotation[] { _1998831462Any_24824501, _1998831462Default_1952014 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<DataBinderProvider> inj1852_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj1839_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_25490828), inj1839_DataBinderProvider);
      return inj1839_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj1839_DataBinderProvider = inj1852_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj1853_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj1833_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_25490828), inj1833_RequestDispatcherProvider);
      return inj1833_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj1833_RequestDispatcherProvider = inj1853_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj1854_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj1841_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_25490828), inj1841_InstanceProvider);
      return inj1841_InstanceProvider;
    }
  };
  private final InstanceProvider inj1841_InstanceProvider = inj1854_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj1855_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj1845_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_25490828), inj1845_EventProvider);
      return inj1845_EventProvider;
    }
  };
  private final EventProvider inj1845_EventProvider = inj1855_EventProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj1856_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj1837_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_25490828), inj1837_IOCBeanManagerProvider);
      return inj1837_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj1837_IOCBeanManagerProvider = inj1856_IOCBeanManagerProvider_creational.getInstance(context);
  private InitializationCallback<Navigation> init_inj1857_Navigation = new InitializationCallback<Navigation>() {
    public void init(final Navigation obj) {
      _136504311_init(obj);
    }
  };
  private final CreationalCallback<Navigation> inj1858_Navigation_creational = new CreationalCallback<Navigation>() {
    public Navigation getInstance(final CreationalContext context) {
      final Navigation inj1857_Navigation = new Navigation();
      context.addBean(context.getBeanReference(Navigation.class, arrayOf_19635043Annotation_25490828), inj1857_Navigation);
      _136504311_bm(inj1857_Navigation, inj1837_IOCBeanManagerProvider.get());
      context.addInitializationCallback(inj1857_Navigation, init_inj1857_Navigation);
      return inj1857_Navigation;
    }
  };
  private final Navigation inj1857_Navigation = inj1858_Navigation_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj1859_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj1831_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_25490828), inj1831_MessageBusProvider);
      return inj1831_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj1831_MessageBusProvider = inj1859_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj1860_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj1851_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_25490828), inj1851_SenderProvider);
      return inj1851_SenderProvider;
    }
  };
  private final SenderProvider inj1851_SenderProvider = inj1860_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj1861_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj1843_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_25490828), inj1843_InitBallotProvider);
      return inj1843_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj1843_InitBallotProvider = inj1861_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<CallerProvider> inj1862_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj1847_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_25490828), inj1847_CallerProvider);
      return inj1847_CallerProvider;
    }
  };
  private final CallerProvider inj1847_CallerProvider = inj1862_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<PageTransitionProvider> inj1863_PageTransitionProvider_creational = new CreationalCallback<PageTransitionProvider>() {
    public PageTransitionProvider getInstance(final CreationalContext context) {
      final PageTransitionProvider inj1829_PageTransitionProvider = new PageTransitionProvider();
      context.addBean(context.getBeanReference(PageTransitionProvider.class, arrayOf_19635043Annotation_25490828), inj1829_PageTransitionProvider);
      _395577528_navigation(inj1829_PageTransitionProvider, inj1857_Navigation);
      return inj1829_PageTransitionProvider;
    }
  };
  private final PageTransitionProvider inj1829_PageTransitionProvider = inj1863_PageTransitionProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj1864_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj1835_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_25490828), inj1835_RootPanelProvider);
      return inj1835_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj1835_RootPanelProvider = inj1864_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj1865_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj1849_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_25490828), inj1849_DisposerProvider);
      _$1300398733_beanManager(inj1849_DisposerProvider, inj1837_IOCBeanManagerProvider.get());
      return inj1849_DisposerProvider;
    }
  };
  private final DisposerProvider inj1849_DisposerProvider = inj1865_DisposerProvider_creational.getInstance(context);
  private InitializationCallback<HelloWorldClient> init_inj1866_HelloWorldClient = new InitializationCallback<HelloWorldClient>() {
    public void init(final HelloWorldClient obj) {
      obj.buildUI();
    }
  };
  private final CreationalCallback<HelloWorldClient> inj1867_HelloWorldClient_creational = new CreationalCallback<HelloWorldClient>() {
    public HelloWorldClient getInstance(final CreationalContext context) {
      final HelloWorldClient inj1866_HelloWorldClient = new HelloWorldClient();
      context.addBean(context.getBeanReference(HelloWorldClient.class, arrayOf_19635043Annotation_25490828), inj1866_HelloWorldClient);
      _594201815_navigation(inj1866_HelloWorldClient, inj1857_Navigation);
      context.addInitializationCallback(inj1866_HelloWorldClient, init_inj1866_HelloWorldClient);
      return inj1866_HelloWorldClient;
    }
  };
  private final HelloWorldClient inj1866_HelloWorldClient = inj1867_HelloWorldClient_creational.getInstance(context);
  private void declareBeans_0() {
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj1852_DataBinderProvider_creational, inj1839_DataBinderProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj1852_DataBinderProvider_creational, inj1839_DataBinderProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj1853_RequestDispatcherProvider_creational, inj1833_RequestDispatcherProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj1853_RequestDispatcherProvider_creational, inj1833_RequestDispatcherProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj1854_InstanceProvider_creational, inj1841_InstanceProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj1854_InstanceProvider_creational, inj1841_InstanceProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(EventProvider.class, EventProvider.class, inj1855_EventProvider_creational, inj1845_EventProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj1855_EventProvider_creational, inj1845_EventProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj1856_IOCBeanManagerProvider_creational, inj1837_IOCBeanManagerProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj1856_IOCBeanManagerProvider_creational, inj1837_IOCBeanManagerProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(Navigation.class, Navigation.class, inj1858_Navigation_creational, inj1857_Navigation, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj1859_MessageBusProvider_creational, inj1831_MessageBusProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj1859_MessageBusProvider_creational, inj1831_MessageBusProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj1860_SenderProvider_creational, inj1851_SenderProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj1860_SenderProvider_creational, inj1851_SenderProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj1861_InitBallotProvider_creational, inj1843_InitBallotProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj1861_InitBallotProvider_creational, inj1843_InitBallotProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj1862_CallerProvider_creational, inj1847_CallerProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj1862_CallerProvider_creational, inj1847_CallerProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(PageTransitionProvider.class, PageTransitionProvider.class, inj1863_PageTransitionProvider_creational, inj1829_PageTransitionProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, PageTransitionProvider.class, inj1863_PageTransitionProvider_creational, inj1829_PageTransitionProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj1864_RootPanelProvider_creational, inj1835_RootPanelProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj1864_RootPanelProvider_creational, inj1835_RootPanelProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj1865_DisposerProvider_creational, inj1849_DisposerProvider, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj1865_DisposerProvider_creational, inj1849_DisposerProvider, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HelloWorldClient.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, true);
    injContext.addBean(VerticalPanel.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HasAlignment.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HasHorizontalAlignment.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HasVerticalAlignment.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(ForIsWidget.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(InsertPanel.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(IndexedPanel.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(CellPanel.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(ComplexPanel.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(Panel.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HasWidgets.ForIsWidget.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HasWidgets.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(Iterable.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(Widget.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(EventListener.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HasAttachHandlers.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HasHandlers.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(IsWidget.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(UIObject.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
    injContext.addBean(HasVisibility.class, HelloWorldClient.class, inj1867_HelloWorldClient_creational, inj1866_HelloWorldClient, arrayOf_19635043Annotation_25490828, null, false);
  }

  private native static void _594201815_navigation(HelloWorldClient instance, Navigation value) /*-{
    instance.@com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.HelloWorldClient::navigation = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _395577528_navigation(PageTransitionProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.PageTransitionProvider::navigation = value;
  }-*/;

  private native static void _136504311_bm(Navigation instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::bm = value;
  }-*/;

  public native static void _136504311_init(Navigation instance) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::init()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    declareBeans_0();
    return injContext;
  }
}