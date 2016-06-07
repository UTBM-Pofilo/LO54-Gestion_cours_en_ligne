package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.Client;
import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.service.ClientService;
import fr.utbm.lo54.project.core.service.CourseSessionService;
import fr.utbm.lo54.project.webapp.util.Properties;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Properties.CONTENT_TYPE);
        
        int idCourseSession = Integer.parseInt(request.getParameter(Properties.FILTER_ID_COURSE_SESSION));
        CourseSessionService courseSessionService = new CourseSessionService();
        CourseSession courseSession = (CourseSession) courseSessionService.getEntity(idCourseSession);
        
        String name = request.getParameter(Properties.CLIENT_NAME);
        String firstName = request.getParameter(Properties.CLIENT_FIRST_NAME);
        String address = request.getParameter(Properties.CLIENT_ADDRESS);
        String phoneNumber = request.getParameter(Properties.CLIENT_PHONE_NUMBER);
        String mail = request.getParameter(Properties.CLIENT_MAIL);
        
        ClientService clientService = new ClientService();
        Client client = new Client(name, firstName, address, phoneNumber, mail, courseSession);
        
        clientService.storeEntity(client);
        
        Client clientTest = (Client) clientService.getEntity(client.getId());
        
        String result = "";
        if (clientTest != null) {
            result += Properties.TRUE;
        } else {
            result += Properties.FALSE;
        }     
                
        request.setAttribute(Properties.ATTRIBUTE_RESULT, result);
        request.getRequestDispatcher(Properties.PATH_INSCRIPTION).forward(request, response);
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
