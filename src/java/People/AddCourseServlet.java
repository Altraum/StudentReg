/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Basil
 */
@WebServlet(urlPatterns = {"/AddCourseServlet"})
public class AddCourseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course stu = new Course();
        String CourseID;
        CourseID = request.getParameter("CourseID");
        String CourseName;
        CourseName = request.getParameter("CourseName");
        String Description;
        Description = request.getParameter("Description");
        int CreditHours;
        CreditHours = Integer.parseInt(request.getParameter("CreditHours"));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException ex){
            out.println("<p>Class Not Found</p>");
        }
        try{
            stu.insertDB(CourseID, CourseName, Description, CreditHours);
            out.println("Section added!");
            response.setHeader("Refresh", "2; URL=Admin.jsp");
        }
        catch(SQLException|ClassNotFoundException ex){
            out.println("Course not added. Another Course with the same ID might already be in database. Returning to Admin Page.");
            response.setHeader("Refresh", "4; URL=Admin.jsp");
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Test Servlet";
    }
}