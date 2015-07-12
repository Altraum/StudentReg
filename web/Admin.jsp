<%-- 
    Document   : Admin
    Created on : Apr 28, 2015, 3:19:04 PM
    Author     : Basil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1>Admin</h1>
        <h3>Add Student:</h3>
        <form method="post" action="http://localhost:8084/StudentReg/AddStudentServlet" id="AddStudent">       
            <table border = "1">
                <tr>
                    <th>Student ID: </th>
                    <th>Password: </th>
                    <th>First Name: </th>
                    <th>Last Name: </th>
                    <th>Street: </th>
                    <th>City: </th>
                    <th>State: </th>
                    <th>Zip Code: </th>
                    <th>Email: </th>
                    <th>GPA: </th>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="ID">
                    </td>
                    <td>
                        <input type="text" name="Password">
                    </td>
                    <td>
                        <input type="text" name="FirstName">
                    </td>
                    <td>
                        <input type="text" name="LastName">
                    </td>
                    <td>
                        <input type="text" name="Street">
                    </td>
                    <td>
                        <input type="text" name="City">
                    </td>
                    <td>
                        <input type="text" name="State">
                    </td>
                    <td>
                        <input type="text" name="Zip">
                    </td>
                    <td>
                        <input type="text" name="Email">
                    </td>
                    <td>
                        <input type="text" name="GPA">
                    </td>
                    <td>
                        <input type="submit" value="Add">
                    </td>
                </tr>
            </table>
        </form>
        <h3>Add Section:</h3>
        <form method="post" action="http://localhost:8084/StudentReg/AddSectionServlet" id="AddSection">       
            <table border = "1">
                <tr>
                    <th>CRN: </th>
                    <th>Course ID: </th>
                    <th>Day and Time: </th>
                    <th>Room #: </th>
                    <th>Instructor: </th>
                    <th></th>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="CRN">
                    </td>
                    <td>
                        <input type="text" name="CourseID">
                    </td>
                    <td>
                        <input type="text" name="TimeDays">
                    </td>
                    <td>
                        <input type="text" name="RoomNo">
                    </td>
                    <td>
                        <input type="text" name="Instructor">
                    </td>
                    <td>
                        <input type="submit" value="Add">
                    </td>
                </tr>
            </table>
        </form>
        <h3>Add Course:</h3>
        <form method="post" action="http://localhost:8084/StudentReg/AddCourseServlet" id="AddCourse">       
            <table border = "1">
                <tr>
                    <th>Course ID: </th>
                    <th>Course Name: </th>
                    <th>Description: </th>
                    <th>Credit Hours: </th>
                    <th></th>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="CourseID">
                    </td>
                    <td>
                        <input type="text" name="CourseName">
                    </td>
                    <td>
                        <input type="text" name="Description">
                    </td>
                    <td>
                        <input type="text" name="CreditHours">
                    </td>
                    <td>
                        <input type="submit" value="Add">
                    </td>
                </tr>
            </table>
        </form>
        <h3>Add Instructor:</h3>
        <form method="post" action="http://localhost:8084/StudentReg/AddInstructorServlet" id="AddInstructor">       
            <table border = "1">
                <tr>
                    <th>Teacher ID: </th>
                    <th>First Name: </th>
                    <th>Last Name: </th>
                    <th>Street: </th>
                    <th>City: </th>
                    <th>State: </th>
                    <th>Zip Code: </th>
                    <th>Office</th>
                    <th>Email: </th>
                    <th></th>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="ID">
                    </td>
                    <td>
                        <input type="text" name="FirstName">
                    </td>
                    <td>
                        <input type="text" name="LastName">
                    </td>
                    <td>
                        <input type="text" name="Street">
                    </td>
                    <td>
                        <input type="text" name="City">
                    </td>
                    <td>
                        <input type="text" name="State">
                    </td>
                    <td>
                        <input type="text" name="Zip">
                    </td>
                    <td>
                        <input type="text" name="Office">
                    </td>
                    <td>
                        <input type="text" name="Email">
                    </td>
                    <td>
                        <input type="submit" value="Add">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
