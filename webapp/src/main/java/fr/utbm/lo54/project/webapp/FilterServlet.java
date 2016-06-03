package fr.utbm.lo54.project.webapp;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.Location;
import fr.utbm.lo54.project.core.service.LocationService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterServlet extends HttpServlet {

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
        
        LocationService locationService = new LocationService();
        List<IEntity> listLocations = locationService.getEntities();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" href=\"/webapp/css/bootstrap.min.css\"/>         \n" +
"        <script src=\"/webapp/js/bootstrap.min.js\"></script>\n" +
"        <title>JSP Page</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>Choose how you want to see your courses</h1>\n" +
"        <ul>\n" +
"            <li><a href=listCourses>List of all courses</a><br></li>\n" +
"            <li>Filter by name</a></li>\n" +
"            <ul>\n" +
"                <li><form method=\"POST\" action=\"filterCourseName\">Name: <input type=\"text\" name=\"name\">\n" +
"                    <input type=\"submit\" value=\"Filter\" />\n" +
"                    </form></li>\n" +
"            </ul>\n" +
"            <li>Filter by date</a><br></li>\n" +
"            <ul>\n" +
"                <form method=\"POST\" action=\"filterCourseDate\">\n" +
"                        <li>Year: <input type=\"text\" name=\"year\">\n" +
"                        <li>Month: <input type=\"text\" name=\"month\">\n" +
"                        <li>Day: <input type=\"text\" name=\"day\">\n" +
"                        <input type=\"submit\" value=\"Filter\" />\n" +
"                    </form></li>\n" +
"            </ul>\n" +
"            <li>Filter by location</a><br></li>\n");

            out.println("<form method=\"POST\" action=filterLocation><select name=\"location\" size=\"1\">");
            for(IEntity entity : listLocations) {
                Location location = (Location) entity;
                out.println("<option>" + location.getCity());
            }
            out.println("</select><input type=\"submit\" value=\"Filter\" /></form>");

            out.println("</ul>\n" +
"    </body>\n" +
"</html>\n" +
"");

           
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
