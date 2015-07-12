/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Basil
 */
public class StudentSchedule {
    int StudentID;
    int CRN;
    /*************Constructors**************/
    public StudentSchedule(int StudentID, int CRN){
        setStudentID(StudentID);
        setCRN(CRN);
    }
    public StudentSchedule(StudentSchedule c){
        this.StudentID=c.getStudentID();
        this.CRN=c.getCRN();
    }
    public StudentSchedule(){
        setStudentID(0);
        setCRN(0);
    }
    /****************Methods****************/
    /**
     * Finds the CRN of the classes in the database that match the given Student ID and gives the StudentSchedule object it's properties.
     * @param StudentID ID of the desired Student's schedule
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void selectDB(int StudentID)throws SQLException, ClassNotFoundException{
		
        System.out.println("<p>Starting...</p>");/*Test Message*/
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
        System.out.println("<p>Connection established</p>");/*Test Message*/
        Statement s = conn.createStatement();
        System.out.println("<p>Statement created</p>");/*Test Message*/
        ResultSet rs = s.executeQuery("SELECT * FROM StudentSchedule WHERE StudentID = " + StudentID);
        System.out.println("<p>Result set ready</p>");/*Test Message*/
        rs.next();
        System.out.println("Next...");/*Test Message*/
        this.setStudentID(Integer.parseInt(rs.getString(1)));
        this.setCRN(Integer.parseInt(rs.getString(2)));
        System.out.println("Customer Set");/*Test Message*/
        conn.close();
        
        
    }
    
    /**
     * Inserts a new StudentSchedule into the database.
     * @param StudentID ID of Student
     * @param CRN CRN of new class
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void insertDB(int StudentID, int CRN) throws SQLException, ClassNotFoundException{
		
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("INSERT INTO StudentSchedule(StudentID, CRN) VALUES ('" + StudentID + "', '" + CRN + "')");

        ResultSet rs = s.executeQuery ("SELECT * FROM StudentSchedule WHERE StudentID = " + StudentID);
        rs.next();
        this.setStudentID(Integer.parseInt(rs.getString(1)));
        this.setCRN(Integer.parseInt(rs.getString(2)));

        conn.close();
    }
    
    /**
     * Deletes the class that matches the given CRN from the Student that matches the given StudentID's schedule
     * @param StudentID ID of Student to remove class from
     * @param CRN CRN of class to remove
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void deleteDB(int StudentID, int CRN) throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("DELETE FROM StudentSchedule WHERE StudentID = '" + StudentID + "' AND CRN = '" + CRN + "'");

        conn.close();
    }
    /****************Getters****************/
    public int getStudentID(){
        return StudentID;
    }
    public int getCRN(){
        return CRN;
    }
    /****************Setters****************/
    public void setStudentID(int StudentID){
        this.StudentID=StudentID;
    }
    public void setCRN(int CRN){
        this.CRN=CRN;
    }
}
