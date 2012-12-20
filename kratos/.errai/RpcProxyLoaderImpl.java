package org.jboss.errai.bus.client.framework;

import com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService;
import java.lang.annotation.Annotation;
import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.bus.client.api.base.MessageBuilder;

public class RpcProxyLoaderImpl implements RpcProxyLoader {
  public void loadProxies(final MessageBus bus) {
    class MyRemoteServiceImpl implements MyRemoteService, RpcStub {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      private Annotation[] qualifiers;
      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public void setQualifiers(Annotation[] quals) {
        qualifiers = quals;
      }

      public String hello() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("hello:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("hello:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public boolean equals(final Object a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return false;
      }

      public String toString() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public int hashCode() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.MyRemoteService").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return 0;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(MyRemoteService.class, new ProxyProvider() {
      public Object getProxy() {
        return new MyRemoteServiceImpl();
      }
    });
  }
}