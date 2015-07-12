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
@WebServlet(urlPatterns = {"/AddStudentServlet"})
public class AddStudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu = new Student();
        int ID;
        ID = Integer.parseInt(request.getParameter("ID"));
        String Password;
        Password = request.getParameter("Password");
        String FirstName;
        FirstName = request.getParameter("FirstName");
        String LastName;
        LastName = request.getParameter("LastName");
        String Street; 
        Street = request.getParameter("Street");
        String City; 
        City = request.getParameter("City");
        String State; 
        State = request.getParameter("State");
        int Zip;
        Zip = Integer.parseInt(request.getParameter("Zip"));
        String Email; 
        Email = request.getParameter("Email");
        Double GPA;
        GPA = Double.parseDouble(request.getParameter("GPA"));
        System.out.println("Before response and PrintWriter");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        try{
            System.out.println("Before Class.forName");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException ex){
            out.println("<p>Class Not Found</p>");
        }
        try{
            stu.insertDB(ID, Password, FirstName, LastName, Street, City, State, Zip, Email, GPA);
            out.println("Student added!");
            response.setHeader("Refresh", "2; URL=Admin.jsp");
        }
        catch(SQLException|ClassNotFoundException ex){
            out.println("Student not added. Another Student with the same ID might already be in database. Returning to Admin Page.");
            response.setHeader("Refresh", "4; URL=Admin.jsp");
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Test Servlet";
    }
}