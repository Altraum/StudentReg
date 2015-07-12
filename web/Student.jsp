<%-- 
    Document   : Student
    Created on : Apr 27, 2015, 11:55:46 PM
    Author     : Basil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Info</title>
    </head>
    <body>
        <%@ page import = "People.*" %>
        <%
            HttpSession s = request.getSession();
            Student stu = new Student();
            StudentSchedule ss = new StudentSchedule();
            stu =(Student) s.getAttribute("Students");
        %>
        <h1><%=stu.getFirstName()%> <%=stu.getLastName()%></h1>
        <p>Address: <%=stu.getStreet()%>, <%=stu.getCity()%>, <%=stu.getState()%> <%=stu.getZip()%></p>
        <p>Email: <%=stu.getEmail()%></p>
        <p>GPA: <%=stu.getGPA()%></p>
        <a href="AddressEdit.jsp">Edit Student Information</a><br><br><br>
        Student Schedule:
        <table border = "1" style ="width:100%">
            <tr>
                <td><strong>CRN: </strong></td>
                <td><strong>Course ID: </strong></td>
                <td><strong>Day and Time: </strong></td>
                <td><strong>Room #: </strong></td>
                <td><strong>Instructor: </strong></td>
            </tr>
        <%
            ScheduleList schedule = new ScheduleList();
            
            Section section;
            section = new Section();
            if (stu != null) {
                System.out.println("Hello?");
                System.out.println(stu.getID());
                schedule = stu.getsList();
                for (int index = 0; index<schedule.getCount(); index++){
                    section = schedule.getSection(index);
        %>
            <tr>
                <td>
                    <%= section.getCRN()%>
                </td>
                <td>
                    <%= section.getCourseID()%>
                </td>
                <td>
                    <%= section.getTimeDays()%>
                </td>
                <td>
                    <%= section.getRoomNo()%>
                </td>
                <td>
                    <%= section.getInstructor()%>
                </td>
            </tr>
        <%
                }
            }
            else{
                out.println("Schedule Not Found");
            }
        %>
        </table><br>
        <a href="ScheduleEdit.jsp">Add/Drop Classes</a>
    </body>
</html>
