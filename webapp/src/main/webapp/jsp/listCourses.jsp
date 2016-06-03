<%-- 
    Document   : listCourses
    Created on : 3 juin 2016, 14:36:35
    Author     : Vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/webapp/css/bootstrap.min.css"/>         
        <script src="/webapp/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose how you want to see your courses</h1>
        <ul>
            <li><a href=../listCourses>List of all courses</a><br></li>
            <li>Filter by name</a></li>
            <ul>
                <li><form method="POST" action="../filterCourseName">Name: <input type="text" name="name">
                    <input type="submit" value="Filter" />
                    </form></li>
            </ul>
            <li>Filter by date</a><br></li>
            <ul>
                <form method="POST" action="../filterCourseDate">
                        <li>Year: <input type="text" name="year">
                        <li>Month: <input type="text" name="month">
                        <li>Day: <input type="text" name="day">
                        <input type="submit" value="Filter" />
                    </form></li>
            </ul>
            <li>Filter by location</a><br></li>
        </ul>
    </body>
</html>
