<%-- 
    Document   : AddressEdit
    Created on : Apr 28, 2015, 2:18:18 AM
    Author     : Basil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Address Edit</title>
    </head>
    <body>
        <%@ page import = "People.*" %>
        <%
            HttpSession s = request.getSession();
            Student stu = new Student();
            stu =(Student) s.getAttribute("Students");
        %>
        <p>Please type in the information you wish to edit. When you are done, click the Update button.</p>
                <form method="post" action="http://localhost:8084/StudentReg/UpdateServlet" name="Info">
                <input type="text" name="Street" value="<%=stu.getStreet()%>">
                <input type="text" name="City" value="<%=stu.getCity()%>">
                <input type="text" name="State" value="<%=stu.getState()%>">
                <input type="text" name="Zip" value="<%=stu.getZip()%>">
                <input type="text" name="Email" value="<%=stu.getEmail()%>">
                <input type="submit" value="Update">
                </form>
        <%
            HttpSession sess = request.getSession(true);
            sess.setAttribute("StudentInfo", stu);
        %>
    </body>
</html>
