package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.service.CourseSessionService;
import fr.utbm.lo54.project.webapp.util.Properties;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterCourseNameServlet extends HttpServlet {

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
        
        CourseSessionService courseSessionService = new CourseSessionService();
        List<IEntity> listCoursesSession = courseSessionService.getEntitiesByTitle(request.getParameter(Properties.FILTER_NAME));
        
        request.setAttribute(Properties.ATTRIBUTE_LIST_COURSES_SESSION, listCoursesSession);
        request.setAttribute(Properties.ATTRIBUTE_SENTENCE, "There is " + listCoursesSession.size() + " courses with the filter \"" + request.getParameter(Properties.FILTER_NAME) + "\"");
        
        request.getRequestDispatcher(Properties.PATH_FILTER_DEFAULT).forward(request, response);
        
      
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
