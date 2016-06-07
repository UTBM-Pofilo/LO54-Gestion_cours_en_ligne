<%@page import="fr.utbm.lo54.project.core.entity.CourseSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CourseSession courseSession = (CourseSession) request.getAttribute("courseSession");
%>  
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/webapp/css/bootstrap.min.css"/>
        <script src="/webapp/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Course Online | Inscription</title>
    </head>
    <body>
        <h1>Inscription at</h1>
        <%
            out.print(courseSession.getCourse().getCode() + " | " + courseSession.getCourse().getTitle());
            out.print(" | Location: " + courseSession.getLocation().getCity());
            out.print(" | Start: " + courseSession.getStartDate());  
        %>
        <form method="POST" action="inscription?idCourseSession=<%out.print(courseSession.getId());%>">
            <ul>
                <li>Name: <input type="text" name="name"><br></li>
                <li>First Name: <input type="text" name="firstName"><br></li>
                <li>Address: <input type="text" name="address"><br></li>
                <li>Phone number: <input type="text" name="phoneNumber"><br></li>
                <li>Mail: <input type="text" name="mail"><br></li>
                <li><input type="submit" value="Add Course" /></li>
            </ul>
        </form>
    </body>
</html>
