/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.service.CourseSessionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "FilterCourseDate", urlPatterns = {"/FilterCourseDate"})
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));
        
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
        List<IEntity> listCourses = courseSessionService.getEntitiesByTimeStamp(startDate, endDate);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"/webapp/css/bootstrap.min.css\"/>");
            out.println("<script src=\"/webapp/js/bootstrap.min.js\"></script>");      
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Servlet ListCoursesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>There is " + listCourses.size() + " courses with this filter</h1><ul>");
            
            for(IEntity entity : listCourses) {
                CourseSession courseSession = (CourseSession) entity;
                out.println("<li>" + courseSession.getCourse().getCode() + " | " + courseSession.getCourse().getTitle());
                out.println(" | Location: " + courseSession.getLocation().getCity());
                out.println(" | Start: " + courseSession.getStartDate());
                out.println(" | <a href=\"inscriptionForm?idCourseSession=" + courseSession.getId() + "\">INSCRIPTION</a>");
                out.println("</li>");
            }
            out.println("</ul></body>");
            out.println("</html>");
            
            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/index.jsp");
            //dispatcher.forward(request,response);
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
