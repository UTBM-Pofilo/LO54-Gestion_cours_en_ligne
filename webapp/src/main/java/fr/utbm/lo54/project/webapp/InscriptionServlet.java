/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.Client;
import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.service.ClientService;
import fr.utbm.lo54.project.core.service.CourseSessionService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/InscriptionServlet"})
public class InscriptionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int idCourseSession = Integer.parseInt(request.getParameter("idCourseSession"));
        CourseSessionService courseSessionService = new CourseSessionService();
        CourseSession courseSession = (CourseSession) courseSessionService.getEntity(idCourseSession);
        
        String name = request.getParameter("name");
        String firstName = request.getParameter("firstName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String mail = request.getParameter("mail");
        
        ClientService clientService = new ClientService();
        Client client = new Client(name, firstName, address, name, mail, courseSession);
        
        
        clientService.storeEntity(client);
        
        
                
                
                
                
                
                
                
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InscriptionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>If you see that, it seems to be good.</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
