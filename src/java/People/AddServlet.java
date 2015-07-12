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
@WebServlet(urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        ScheduleList sl = new ScheduleList();
        Section section = new Section();
        Student stu = new Student();
        stu =(Student) s.getAttribute("Students");
        StudentSchedule schedule = new StudentSchedule();
        int CRN; 
        CRN = Integer.parseInt(request.getParameter("CRN"));
        int ID;
        ID = stu.getID();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException ex){
            out.println("<p>Class Not Found</p>");
        }
        try{
            schedule.insertDB(ID, CRN);
            sl = stu.getsList();
            section.selectDB(CRN);
            sl.add(section);
            stu.setsList(sl);
        }
        catch(SQLException|ClassNotFoundException ex){
            out.println("Error");
        }
        HttpSession sess = request.getSession(true);
        sess.setAttribute("Students", stu);
        RequestDispatcher rd = request.getRequestDispatcher("ScheduleEdit.jsp");
        rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Test Servlet";
    }
}