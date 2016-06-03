package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.service.CourseSessionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterLocationServlet extends HttpServlet {

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
        
        String location = request.getParameter("location");
        CourseSessionService courseSessionService = new CourseSessionService();
        List<IEntity> listCourses = courseSessionService.getEntitiesByLocation(location);
        
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
            out.println("<h1>There is " + listCourses.size() + " courses with the filter \"" + location + "\"</h1><ul>");
            
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
