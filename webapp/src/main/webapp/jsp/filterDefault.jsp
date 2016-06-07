<%@page import="fr.utbm.lo54.project.webapp.util.Properties"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.lo54.project.core.entity.CourseSession"%>
<%@page import="fr.utbm.lo54.project.core.entity.IEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<IEntity> listCoursesSession = (List<IEntity>) request.getAttribute(Properties.ATTRIBUTE_LIST_COURSES_SESSION);
%>  
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/webapp/css/bootstrap.min.css"/>
        <script src="/webapp/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Course Online | Filter Courses</title>
    </head>
    <body>
        <%
          out.println("<h1>" + (String) request.getAttribute(Properties.ATTRIBUTE_SENTENCE) + "</h1>");
        %>
        <ul>
            <%
                for(IEntity entity : listCoursesSession) {
                CourseSession courseSession = (CourseSession) entity;
                out.println("<li>" + courseSession.getCourse().getCode() + " | " + courseSession.getCourse().getTitle());
                out.println(" | Location: " + courseSession.getLocation().getCity());
                out.println(" | Start: " + courseSession.getStartDate());
                out.println(" | <a href=\"inscriptionForm?" + Properties.FILTER_ID_COURSE_SESSION + "=" + courseSession.getId() + "\">INSCRIPTION</a>");
                out.println("</li>");
            }
            %>
        </ul>
    </body>
</html>
