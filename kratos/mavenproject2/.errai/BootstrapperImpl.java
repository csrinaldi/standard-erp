package org.jboss.errai.ioc.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.InsertPanel.ForIsWidget;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.HelloWorldClient;
import com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.ui.HomePage;
import com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.ui.LoginPage;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
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
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;

public class BootstrapperImpl implements Bootstrapper {
  {
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
  }
  private final Default _1998831462Default_8185175 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Any _1998831462Any_28621621 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_11234476 = new Annotation[] { _1998831462Default_8185175, _1998831462Any_28621621 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<DataBinderProvider> inj5579_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj5566_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_11234476), inj5566_DataBinderProvider);
      return inj5566_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj5566_DataBinderProvider = inj5579_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj5580_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj5560_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_11234476), inj5560_RequestDispatcherProvider);
      return inj5560_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj5560_RequestDispatcherProvider = inj5580_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj5581_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj5568_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_11234476), inj5568_InstanceProvider);
      return inj5568_InstanceProvider;
    }
  };
  private final InstanceProvider inj5568_InstanceProvider = inj5581_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj5582_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj5572_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_11234476), inj5572_EventProvider);
      return inj5572_EventProvider;
    }
  };
  private final EventProvider inj5572_EventProvider = inj5582_EventProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj5583_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj5564_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_11234476), inj5564_IOCBeanManagerProvider);
      return inj5564_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj5564_IOCBeanManagerProvider = inj5583_IOCBeanManagerProvider_creational.getInstance(context);
  private InitializationCallback<Navigation> init_inj5584_Navigation = new InitializationCallback<Navigation>() {
    public void init(final Navigation obj) {
      _136504311_init(obj);
    }
  };
  private final CreationalCallback<Navigation> inj5585_Navigation_creational = new CreationalCallback<Navigation>() {
    public Navigation getInstance(final CreationalContext context) {
      final Navigation inj5584_Navigation = new Navigation();
      context.addBean(context.getBeanReference(Navigation.class, arrayOf_19635043Annotation_11234476), inj5584_Navigation);
      _136504311_bm(inj5584_Navigation, inj5564_IOCBeanManagerProvider.get());
      context.addInitializationCallback(inj5584_Navigation, init_inj5584_Navigation);
      return inj5584_Navigation;
    }
  };
  private final Navigation inj5584_Navigation = inj5585_Navigation_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj5586_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj5558_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_11234476), inj5558_MessageBusProvider);
      return inj5558_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj5558_MessageBusProvider = inj5586_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj5587_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj5578_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_11234476), inj5578_SenderProvider);
      return inj5578_SenderProvider;
    }
  };
  private final SenderProvider inj5578_SenderProvider = inj5587_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj5588_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj5570_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_11234476), inj5570_InitBallotProvider);
      return inj5570_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj5570_InitBallotProvider = inj5588_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<CallerProvider> inj5589_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj5574_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_11234476), inj5574_CallerProvider);
      return inj5574_CallerProvider;
    }
  };
  private final CallerProvider inj5574_CallerProvider = inj5589_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<PageTransitionProvider> inj5590_PageTransitionProvider_creational = new CreationalCallback<PageTransitionProvider>() {
    public PageTransitionProvider getInstance(final CreationalContext context) {
      final PageTransitionProvider inj5556_PageTransitionProvider = new PageTransitionProvider();
      context.addBean(context.getBeanReference(PageTransitionProvider.class, arrayOf_19635043Annotation_11234476), inj5556_PageTransitionProvider);
      _395577528_navigation(inj5556_PageTransitionProvider, inj5584_Navigation);
      return inj5556_PageTransitionProvider;
    }
  };
  private final PageTransitionProvider inj5556_PageTransitionProvider = inj5590_PageTransitionProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj5591_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj5562_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_11234476), inj5562_RootPanelProvider);
      return inj5562_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj5562_RootPanelProvider = inj5591_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<LoginPage> inj5593_LoginPage_creational = new CreationalCallback<LoginPage>() {
    public LoginPage getInstance(final CreationalContext context) {
      final LoginPage inj5592_LoginPage = new LoginPage();
      context.addBean(context.getBeanReference(LoginPage.class, arrayOf_19635043Annotation_11234476), inj5592_LoginPage);
      context.addInitializationCallback(inj5592_LoginPage, new InitializationCallback<LoginPage>() {
        public void init(LoginPage obj) {
          com_logikas_kratos_helth_humanresources_business_mavenproject2_client_local_ui_LoginPageTemplateResource var17 = GWT.create(com_logikas_kratos_helth_humanresources_business_mavenproject2_client_local_ui_LoginPageTemplateResource.class);
          Element var18 = TemplateUtil.getRootTemplateElement(var17.getContents().getText(), "login-page");
          Map<String, Element> var19 = TemplateUtil.getDataFieldElements(var18);
          Map<String, Widget> var20 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj5592_LoginPage, var18, var20.values());
        }
      });
      return inj5592_LoginPage;
    }
  };
  private final CreationalCallback<HomePage> inj5595_HomePage_creational = new CreationalCallback<HomePage>() {
    public HomePage getInstance(final CreationalContext context) {
      final HomePage inj5594_HomePage = new HomePage();
      context.addBean(context.getBeanReference(HomePage.class, arrayOf_19635043Annotation_11234476), inj5594_HomePage);
      context.addInitializationCallback(inj5594_HomePage, new InitializationCallback<HomePage>() {
        public void init(HomePage obj) {
          com_logikas_kratos_helth_humanresources_business_mavenproject2_client_local_ui_HomePageTemplateResource var21 = GWT.create(com_logikas_kratos_helth_humanresources_business_mavenproject2_client_local_ui_HomePageTemplateResource.class);
          Element var22 = TemplateUtil.getRootTemplateElement(var21.getContents().getText(), "root");
          Map<String, Element> var23 = TemplateUtil.getDataFieldElements(var22);
          Map<String, Widget> var24 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj5594_HomePage, var22, var24.values());
        }
      });
      return inj5594_HomePage;
    }
  };
  private final CreationalCallback<DisposerProvider> inj5596_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj5576_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_11234476), inj5576_DisposerProvider);
      _$1300398733_beanManager(inj5576_DisposerProvider, inj5564_IOCBeanManagerProvider.get());
      return inj5576_DisposerProvider;
    }
  };
  private final DisposerProvider inj5576_DisposerProvider = inj5596_DisposerProvider_creational.getInstance(context);
  private InitializationCallback<HelloWorldClient> init_inj5597_HelloWorldClient = new InitializationCallback<HelloWorldClient>() {
    public void init(final HelloWorldClient obj) {
      obj.init();
    }
  };
  private final CreationalCallback<HelloWorldClient> inj5598_HelloWorldClient_creational = new CreationalCallback<HelloWorldClient>() {
    public HelloWorldClient getInstance(final CreationalContext context) {
      final HelloWorldClient inj5597_HelloWorldClient = new HelloWorldClient();
      context.addBean(context.getBeanReference(HelloWorldClient.class, arrayOf_19635043Annotation_11234476), inj5597_HelloWorldClient);
      _594201815_navigation(inj5597_HelloWorldClient, inj5584_Navigation);
      context.addInitializationCallback(inj5597_HelloWorldClient, init_inj5597_HelloWorldClient);
      return inj5597_HelloWorldClient;
    }
  };
  private final HelloWorldClient inj5597_HelloWorldClient = inj5598_HelloWorldClient_creational.getInstance(context);
  public interface com_logikas_kratos_helth_humanresources_business_mavenproject2_client_local_ui_LoginPageTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/kratos/helth/humanresources/business/mavenproject2/client/local/ui/LoginPage.html") public TextResource getContents(); }
  public interface com_logikas_kratos_helth_humanresources_business_mavenproject2_client_local_ui_HomePageTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/kratos/helth/humanresources/business/mavenproject2/client/local/ui/HomePage.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj5579_DataBinderProvider_creational, inj5566_DataBinderProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj5579_DataBinderProvider_creational, inj5566_DataBinderProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj5580_RequestDispatcherProvider_creational, inj5560_RequestDispatcherProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj5580_RequestDispatcherProvider_creational, inj5560_RequestDispatcherProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj5581_InstanceProvider_creational, inj5568_InstanceProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj5581_InstanceProvider_creational, inj5568_InstanceProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(EventProvider.class, EventProvider.class, inj5582_EventProvider_creational, inj5572_EventProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj5582_EventProvider_creational, inj5572_EventProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj5583_IOCBeanManagerProvider_creational, inj5564_IOCBeanManagerProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj5583_IOCBeanManagerProvider_creational, inj5564_IOCBeanManagerProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(Navigation.class, Navigation.class, inj5585_Navigation_creational, inj5584_Navigation, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj5586_MessageBusProvider_creational, inj5558_MessageBusProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj5586_MessageBusProvider_creational, inj5558_MessageBusProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj5587_SenderProvider_creational, inj5578_SenderProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj5587_SenderProvider_creational, inj5578_SenderProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj5588_InitBallotProvider_creational, inj5570_InitBallotProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj5588_InitBallotProvider_creational, inj5570_InitBallotProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj5589_CallerProvider_creational, inj5574_CallerProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj5589_CallerProvider_creational, inj5574_CallerProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(PageTransitionProvider.class, PageTransitionProvider.class, inj5590_PageTransitionProvider_creational, inj5556_PageTransitionProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, PageTransitionProvider.class, inj5590_PageTransitionProvider_creational, inj5556_PageTransitionProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj5591_RootPanelProvider_creational, inj5562_RootPanelProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj5591_RootPanelProvider_creational, inj5562_RootPanelProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(LoginPage.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(Composite.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(IsRenderable.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(Widget.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(EventListener.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasAttachHandlers.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasHandlers.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(IsWidget.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(UIObject.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasVisibility.class, LoginPage.class, inj5593_LoginPage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HomePage.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(Composite.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(IsRenderable.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(Widget.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(EventListener.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasAttachHandlers.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasHandlers.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(IsWidget.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(UIObject.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasVisibility.class, HomePage.class, inj5595_HomePage_creational, null, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj5596_DisposerProvider_creational, inj5576_DisposerProvider, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj5596_DisposerProvider_creational, inj5576_DisposerProvider, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HelloWorldClient.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, true);
    injContext.addBean(VerticalPanel.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasAlignment.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasHorizontalAlignment.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasVerticalAlignment.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(ForIsWidget.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(InsertPanel.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(IndexedPanel.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(CellPanel.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(ComplexPanel.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(Panel.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HasWidgets.ForIsWidget.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasWidgets.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(Iterable.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(Widget.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(EventListener.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasAttachHandlers.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasHandlers.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(IsWidget.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(UIObject.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
    injContext.addBean(HasVisibility.class, HelloWorldClient.class, inj5598_HelloWorldClient_creational, inj5597_HelloWorldClient, arrayOf_19635043Annotation_11234476, null, false);
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