package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.service.CourseSessionService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscriptionFormServlet extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"/webapp/css/bootstrap.min.css\"/>");
            out.println("<script src=\"/webapp/js/bootstrap.min.js\"></script>");      
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");     
            out.println("<title>Servlet AddMovieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Inscription at</h1>");
            out.println(courseSession.getCourse().getCode() + " | " + courseSession.getCourse().getTitle());
            out.println(" | Location: " + courseSession.getLocation().getCity());
            out.println(" | Start: " + courseSession.getStartDate());

            out.println("<form method=\"POST\" action=\"inscription?idCourseSession=" + courseSession.getId() + "\">\n" +
"            Name: <input type=\"text\" name=\"name\"><br>\n" +
"            First Name: <input type=\"text\" name=\"firstName\"><br>\n" +
"            Address: <input type=\"text\" name=\"address\"><br>\n" +
"            Phone number: <input type=\"text\" name=\"phoneNumber\"><br>\n" +
"            Mail: <input type=\"text\" name=\"mail\"><br>\n" +
"            <input type=\"submit\" value=\"Add Course\" />\n" +
"        </form>");

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
