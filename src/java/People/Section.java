/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

import java.sql.*;

/**
 *
 * @author Basil
 */
public class Section {
    int CRN;
    String CourseID;
    String TimeDays;
    String RoomNo;
    String Instructor;
    /*************Constructors**************/
    public Section(int CRN, String CourseID, String TimeDays, String RoomNo, String Instructor){
        setCRN(CRN);
        setCourseID(CourseID);
        setTimeDays(TimeDays);
        setRoomNo(RoomNo);
        setInstructor(Instructor);
    }
    public Section(Section c){
        this.CRN = c.getCRN();
        this.CourseID = c.getCourseID();
        this.TimeDays = c.getTimeDays();
        this.RoomNo = c.getRoomNo();
    }
    public Section(){
        setCRN(0);
        setCourseID("");
        setTimeDays("");
        setRoomNo("");
        setInstructor("");
    }
    /****************Methods****************/
    /**
     * Finds the Section in the database that matches the given CRN and gives the Section object it's properties.
     * @param CRN
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void selectDB(int CRN)throws SQLException, ClassNotFoundException{
        System.out.println(CRN);
        System.out.println("<p>Starting...</p>");/*Test Message*/
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
        System.out.println("<p>Connection established</p>");/*Test Message*/
        Statement s = conn.createStatement();
        System.out.println("<p>Statement created</p>");/*Test Message*/
        ResultSet rs = s.executeQuery("SELECT CourseID, TimeDays, RoomNo, Instructor FROM Sections WHERE CRN = " + CRN);
        System.out.println("<p>Result set ready</p>");/*Test Message*/
        rs.next();
        System.out.println("Next...");/*Test Message*/
        this.setCRN(CRN);
        this.setCourseID(rs.getString(1));
        this.setTimeDays(rs.getString(2));
        this.setRoomNo(rs.getString(3));
        this.setInstructor(rs.getString(4));
        System.out.println("Section Set");/*Test Message*/
        conn.close();
    }
    
    /**
     * Inserts a new Section into the database.
     * @param CRN CRN of new Section
     * @param CourseID Course ID of new Section
     * @param TimeDays Day and Time of new Section
     * @param RoomNo Room # of new Section
     * @param Instructor Instructor that teaches the new Section
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void insertDB(int CRN, String CourseID, String TimeDays, String RoomNo, String Instructor) throws SQLException, ClassNotFoundException{
		
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
        System.out.println("1");
        Statement s = conn.createStatement();
        System.out.println("2");
        s.executeUpdate ("INSERT INTO Sections(CRN, CourseID, TimeDays, RoomNo, Instructor) VALUES ('" + CRN + "', '" + CourseID + "', '" + TimeDays + "', '" + RoomNo + "', '" + Instructor + "')");
        System.out.println("3");
        ResultSet rs = s.executeQuery ("SELECT * FROM Sections WHERE CourseID = " + CourseID);
        rs.next();
        this.setCRN(Integer.parseInt(rs.getString(1)));
        this.setCourseID(rs.getString(2));
        this.setTimeDays(rs.getString(3));
        this.setRoomNo(rs.getString(4));
        this.setInstructor(rs.getString(5));

        conn.close();
    }
    /**
     * Updates the Section in the database that shares a CRN with the Section object to match the Section object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void updateDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("UPDATE Sections SET CourseID = '" + this.CourseID + "', TimeDays = '" + this.TimeDays + "', RoomNo = '" + this.RoomNo + "', Instructor = '" + this.Instructor + "' WHERE CRN = '" + CRN + "'");

        conn.close();
    }
    
    /**
     * Deletes the Section in the database that matches the CRN of the Section object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void deleteDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("DELETE FROM Sections WHERE CRN = '" + CRN + "'");

        conn.close();
    }
    /****************Getters****************/
    public int getCRN(){
        return CRN;
    }
    public String getCourseID(){
        return CourseID;
    }
    public String getTimeDays(){
        return TimeDays;
    }
    public String getRoomNo(){
        return RoomNo;
    }
    public String getInstructor(){
        return Instructor;
    }
    /****************Setters****************/
    public void setCRN(int CRN){
        this.CRN=CRN;
    }
    public void setCourseID(String CourseID){
        this.CourseID=CourseID;
    }
    public void setTimeDays(String TimeDays){
        this.TimeDays=TimeDays;
    }
    public void setRoomNo(String RoomNo){
        this.RoomNo=RoomNo;
    }
    public void setInstructor(String Instructor){
        this.Instructor=Instructor;
    }
}
