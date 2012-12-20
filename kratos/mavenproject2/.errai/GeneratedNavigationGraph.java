package org.jboss.errai.ui.nav.client.local.spi;

import com.google.gwt.user.client.ui.Widget;
import com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.ui.HomePage;
import com.logikas.kratos.helth.humanresources.business.mavenproject2.client.local.ui.LoginPage;

public class GeneratedNavigationGraph extends NavigationGraph {
  public GeneratedNavigationGraph() {
    pagesByName.put("LoginPage", new PageNode() {
      public String name() {
        return "LoginPage";
      }

      public Class contentType() {
        return LoginPage.class;
      }

      public Widget content() {
        return bm.lookupBean(LoginPage.class).getInstance();
      }
    });
    final PageNode defaultPage = new PageNode() {
      public String name() {
        return "HomePage";
      }

      public Class contentType() {
        return HomePage.class;
      }

      public Widget content() {
        return bm.lookupBean(HomePage.class).getInstance();
      }
    };
    pagesByName.put("", defaultPage);
    pagesByName.put("HomePage", defaultPage);
  }

}