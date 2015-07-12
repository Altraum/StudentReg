<%-- 
    Document   : ScheduleEdit
    Created on : Apr 28, 2015, 11:15:13 AM
    Author     : Basil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add/Drop</title>
    </head>
    <body>
        <%@ page import = "People.*" %>
        <%@ page import = "java.sql.*"%> 
        <%
            HttpSession s = request.getSession();
            Student stu = new Student();
            stu =(Student) s.getAttribute("Students");
        %>
        <h1>Click the Remove button to drop a class.</h1><br>
                
        
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
        <form method="post" action="http://localhost:8084/StudentReg/DropServlet" id="DropClasses">       
        <table border = "1" style ="width:100%">
            <tr>
                <td><strong>CRN: </strong></td>
                <td><strong>Course ID: </strong></td>
                <td><strong>Day and Time: </strong></td>
                <td><strong>Room #: </strong></td>
                <td><strong>Instructor: </strong></td>
                <td></td>
            </tr>
            <tr>
            
                <td>
                    <input type="text" name="CRN" value="<%=section.getCRN()%>" readonly>
                </td>
                <td>
                    <input type="text" name="CourseID" value="<%=section.getCourseID()%>" readonly>
                </td>
                <td>
                    <input type="text" name="TimeDays" value="<%=section.getTimeDays()%>" readonly>
                </td>
                <td>
                    <input type="text" name="RoomNo" value="<%=section.getRoomNo()%>" readonly>
                </td>
                <td>
                    <input type="text" name="Instructor" value="<%=section.getInstructor()%>" readonly>
                </td>
                <td>
                    <input type="submit" value="Remove">
                </td>
            </tr>
            </table>
            </form>
        <%
                }
            }
            else{
                out.println("Schedule Not Found");
            }
        %>
        <h1> To add a class, type in the CRN of the class you would like to join below. The CRNs of all available classes can also be found below.</h1><br>
        <form method="post" action="http://localhost:8084/StudentReg/AddServlet" id="AddClasses">       
        <table border = "1">
            <tr>
                <td><strong>CRN: </strong></td>
                <td></td>
            </tr>
            <tr>
            
                <td>
                    <input type="text" name="CRN">
                </td>
                <td>
                    <input type="submit" value="Add">
                </td>
            </tr>
            </table>
            </form>
        <br><br><br>
        
        <%
            
            System.out.println("Student.java Starting...");/*Test Message*/
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
            System.out.println("Connection established");/*Test Message*/
            Statement state = conn.createStatement();
            System.out.println("Statement created");/*Test Message*/
            ResultSet rs = state.executeQuery("SELECT CRN, CourseID, TimeDays, RoomNo, Instructor FROM Sections");
            System.out.println("Result set ready");/*Test Message*/
        %>
        <table border = "1" style ="width:100%">
            <tr>
                <th>CRN:</th>
                <th>Course ID:</th>
                <th>Day and Time:</th>
                <th>Room #:</th>
                <th>Instructor:</th>
            </tr>
        <%
            while(rs.next()){
        %>
            <tr>
                <td>
                    <%= rs.getString(1)%>
                </td>
                <td>
                    <%= rs.getString(2)%>
                </td>
                <td>
                    <%= rs.getString(3)%>
                </td>
                <td>
                    <%= rs.getString(4)%>
                </td>
                <td>
                    <%= rs.getString(5)%>
                </td>
            </tr>
        <%
            }
        %>
        </table>
        <%
            HttpSession sess = request.getSession(true);
            sess.setAttribute("Students", stu);
        %>
    </body>
</html>
