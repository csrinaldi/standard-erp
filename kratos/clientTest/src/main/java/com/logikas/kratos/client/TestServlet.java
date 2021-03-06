/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client;

import com.google.common.eventbus.EventBus;
import com.google.inject.Provider;
import com.logikas.kratos.core.module.event.EventDispatcher;
import com.logikas.kratos.core.module.event.ModuleInitializedEvent;
import com.logikas.kratos.core.module.impl.CoreModule;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian Rinaldi
 */
@Singleton
public class TestServlet extends HttpServlet {

    private EventDispatcher bus;
    private CoreModule coreModule;
    
    @Inject
    public TestServlet(EventDispatcher dispath, CoreModule coreModule) {
        this.bus = dispath;
        this.coreModule = coreModule;
    }

    //@Inject
    //Iterable<Module> modules;
    
    

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        
        
        
        
        
        
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>EventBus " + this.coreModule.getName() + "</h1>");
            out.println("<h1>Modulos : modules.iterator().hasNext()</h1>");
            
            
            
            //this.bus.post(new ModuleInitializedEvent(null));
            
            
            /*Iterator<Module> it = modules.iterator();
            while (it.hasNext()) {
                Module module = it.next();
                out.println("<h2>El modulo " + module.getName() + " is Loaded </h2>");
            }*/
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
