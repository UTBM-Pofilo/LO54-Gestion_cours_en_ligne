package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.service.CourseSessionService;
import fr.utbm.lo54.project.webapp.util.Properties;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterCourseDateServlet extends HttpServlet {

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
        
        int year = Integer.parseInt(request.getParameter(Properties.YEAR));
        int month = Integer.parseInt(request.getParameter(Properties.MONTH));
        int day = Integer.parseInt(request.getParameter(Properties.DAY));
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Timestamp startDate = new Timestamp(calendar.getTimeInMillis());
        calendar.set(Calendar.DAY_OF_MONTH, day + 1);
        Timestamp endDate = new Timestamp(calendar.getTimeInMillis());
        
        CourseSessionService courseSessionService = new CourseSessionService();
        List<IEntity> listCoursesSession = courseSessionService.getEntitiesByTimeStamp(startDate, endDate);
        
        request.setAttribute(Properties.ATTRIBUTE_LIST_COURSES_SESSION, listCoursesSession);
        request.setAttribute(Properties.ATTRIBUTE_SENTENCE, "There is " + listCoursesSession.size() + " courses with this filter");
        
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
