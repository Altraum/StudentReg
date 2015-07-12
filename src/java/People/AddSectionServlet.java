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
@WebServlet(urlPatterns = {"/AddSectionServlet"})
public class AddSectionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Section stu = new Section();
        int CRN;
        CRN = Integer.parseInt(request.getParameter("CRN"));
        String CourseID;
        CourseID = request.getParameter("CourseID");
        String TimeDays;
        TimeDays = request.getParameter("TimeDays");
        String RoomNo;
        RoomNo = request.getParameter("RoomNo");
        String Instructor; 
        Instructor = request.getParameter("Instructor");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException ex){
            out.println("<p>Class Not Found</p>");
        }
        try{
            stu.insertDB(CRN, CourseID, TimeDays, RoomNo, Instructor);
            out.println("Section added!");
            response.setHeader("Refresh", "2; URL=Admin.jsp");
        }
        catch(SQLException|ClassNotFoundException ex){
            out.println("Section not added. Another Section with the same CRN might already be in database. Returning to Admin Page.");
            response.setHeader("Refresh", "4; URL=Admin.jsp");
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Test Servlet";
    }
}