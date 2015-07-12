<%-- 
    Document   : ErrorPage
    Created on : Apr 27, 2015, 11:09:12 PM
    Author     : Basil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
         <%@ page import = "People.*" %>
        <%
            HttpSession s = request.getSession();
            Student s1;
            s1 =(Student) s.getAttribute("Students");
            if(s1 != null){
        %>
        Error Logging in for User with ID <%=s1.getID()%>        
        <%
            }
            else{
                System.out.println(s1.getID());
                out.println("Connection Error");
                response.setHeader("Refresh", "3; URL=login.html");
            }
        %>
    </body>
</html>
