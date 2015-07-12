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
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id; 
        id = request.getParameter("id");
        String pw; 
        pw = request.getParameter("pw");
        Student s = new Student();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException ex){
            out.println("<p>Class Not Found</p>");
        }
        try{
            if(pw.equalsIgnoreCase("admin")){
                RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
                rd.forward(request, response);
            }
            out.println("Started: ID " + id);
            s.selectDB(Integer.parseInt(id));
            out.println("DB made");
            HttpSession session = request.getSession(true);
            session.setAttribute("Students", s);
            if(pw.equalsIgnoreCase(s.getPassword())){
                RequestDispatcher rd = request.getRequestDispatcher("Student.jsp");
                rd.forward(request, response);
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
                rd.forward(request, response);
            }
        }
        catch(SQLException | ClassNotFoundException ex){
            s.setID(Integer.valueOf(id));
            HttpSession session = request.getSession(true);
            session.setAttribute("Students", s);
            RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
            rd.forward(request, response);
        } 
        
    }
    
    @Override
    public String getServletInfo() {
        return "Test Servlet";
    }
}