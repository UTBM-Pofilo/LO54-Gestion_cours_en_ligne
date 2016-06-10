<%@page import="fr.utbm.lo54.project.webapp.util.Properties"%>
<%@page import="fr.utbm.lo54.project.core.entity.Location"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.lo54.project.core.entity.IEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/webapp/css/bootstrap.min.css"/>
        <script src="/webapp/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Course Online | Filter Courses</title>
    </head>
    <body>
        <h1><a href="/webapp">HOME</a></h1>
        <h1>Choose how you want to see your courses</h1>
        <ul>
            <li><a href=listCourses>List of all courses</a><br></li>
            <li>Filter by name</a></li>
            <ul>
                <li><form method="POST" action="filterCourseName">
                        Name: <input type="text" name="name">
                        <input type="submit" value="Filter" />
                    </form>
                </li>
            </ul>
            <li>Filter by date</a><br></li>
            <ul>
                <form method="POST" action="filterCourseDate">
                        <li>Year: <select name="year" size="1">
                            <%
                                for(int i = 1999; i < 2018; i++) {
                                    out.println("<option>" + i);
                                }  
                            %>
                        </select>
                        <li>Month: <select name="month" size="1">
                            <%
                                for(int i = 1; i < 13; i++) {
                                    out.println("<option>" + i);
                                }  
                            %>
                        </select>
                        <li>Day: <select name="day" size="1">
                            <%
                                for(int i = 1; i < 32; i++) {
                                    out.println("<option>" + i);
                                }  
                            %>
                        </select>
                       
                        <input type="submit" value="Filter"/>
                </form></li>
            </ul>
            <li>Filter by location</a><br></li>
                <ul><li>
                    <form method="POST" action=filterLocation>
                        <select name="location" size="1">
                            <%
                                List<IEntity> listLocations = (List<IEntity>) request.getAttribute(Properties.ATTRIBUTE_LIST_LOCATION);
                                for(IEntity entity : listLocations) {
                                    Location location = (Location) entity;
                                    out.println("<option>" + location.getCity());
                                }  
                            %>
                        </select>
                        <input type="submit" value="Filter" />
                    </form>
                </li></ul>
            </ul>
    </body>
</html>

