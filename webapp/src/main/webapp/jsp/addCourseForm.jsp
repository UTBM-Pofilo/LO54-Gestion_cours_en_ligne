<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>         
        <script src="../js/bootstrap.min.js"></script>     
        <title>TODO supply a title</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form method="POST" action="addCourse">
            Code: <input type="text" name="code"><br>
            Title: <input type="text" name="title"><br>
            <input type="submit" value="Add Course" />
        </form>
    </body>
</html>
