<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/webapp/css/bootstrap.min.css"/>
        <script src="/webapp/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Course Online | Inscription</title>
    </head>
    <body>
        <h1>Result of the inscription</h1>
        <%
            String result = (String) request.getAttribute("result");
            if(result.equals("OK")) {
                out.println("Inscription Successfully done");
            } else {
                out.println("Somtething goes wrong during your inscription");
            }
        %>
    </body>
</html>