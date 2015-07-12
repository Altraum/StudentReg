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
@WebServlet(urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        Student stu = new Student();
        stu =(Student) s.getAttribute("StudentInfo");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException ex){
            out.println("<p>Class Not Found</p>");
        }
        try{
            stu.setStreet(Street);
            stu.setCity(City);
            stu.setState(State);
            stu.setZip(Zip);
            stu.setEmail(Email);
            stu.updateDB();
        }
        catch(SQLException|ClassNotFoundException ex){
            out.println("Error");
        }
        RequestDispatcher rd = request.getRequestDispatcher("Student.jsp");
        rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Test Servlet";
    }
}