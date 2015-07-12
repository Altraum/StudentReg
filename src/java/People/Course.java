/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

import java.sql.*;

public class Course {
    String CourseID;
    String CourseName;
    String Description;
    int CreditHours;
    
    /*************Constructors**************/
    public Course(String CourseID, String CourseName, String Description, int CreditHours){
        setCourseID(CourseID);
        setCourseName(CourseName);
        setDescription(Description);
        setCreditHours(CreditHours);
    }
    public Course(Course c){
        this.CourseID = c.getCourseID();
        this.CourseName = c.getCourseName();
        this.Description = c.getDescription();
        this.CreditHours = c.getCreditHours();
    }
    public Course(){
        setCourseID("");
        setCourseName("");
        setDescription("");
        setCreditHours(0);
    }
    /****************Methods****************/
    /**
     * Finds the Course in the database that matches the given Course ID and gives the Course object it's properties.
     * @param CourseID ID of the desired Course
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void selectDB(int CourseID)throws SQLException, ClassNotFoundException{
		
        System.out.println("<p>Starting...</p>");/*Test Message*/
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
        System.out.println("<p>Connection established</p>");/*Test Message*/
        Statement s = conn.createStatement();
        System.out.println("<p>Statement created</p>");/*Test Message*/
        ResultSet rs = s.executeQuery("SELECT * FROM Courses WHERE CourseID = " + CourseID);
        System.out.println("<p>Result set ready</p>");/*Test Message*/
        rs.next();
        System.out.println("Next...");/*Test Message*/
        this.setCourseID(rs.getString(1));
        this.setCourseName(rs.getString(2));
        this.setDescription(rs.getString(3));
        this.setCreditHours(Integer.parseInt(rs.getString(4)));
        System.out.println("Customer Set");/*Test Message*/
        conn.close();
    }
    /**
     * Inserts a new Course into the Database
     * @param CourseID ID of the new Course
     * @param CourseName The name of the new Course
     * @param Description A description of the new Course
     * @param CreditHours The amount of credit hours given by new Course
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void insertDB(String CourseID, String CourseName, String Description, int CreditHours) throws SQLException, ClassNotFoundException{
		
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("INSERT INTO Courses(CourseID, CourseName, Description, CreditHours) VALUES ('" + CourseID + "', '" + CourseName + "', '" + Description + "', '" + CreditHours + "')");

        conn.close();
    }
    /**
     * Updates a Course in the database that shares the Course ID of the Course object to match the Course object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void updateDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("UPDATE Courses SET CourseName = '" + this.CourseName + "', Description = '" + this.Description + "', CreditHours = '" + this.CreditHours + "' WHERE CourseID = '" + CourseID + "'");

        conn.close();
    }
    /**
     * Deletes the Course in the database that matches the Course ID of the Course object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void deleteDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("DELETE FROM Courses WHERE CourseID = '" + CourseID + "'");

        conn.close();
    }
    /****************Getters****************/
    public String getCourseID(){
        return CourseID;
    }
    public String getCourseName(){
        return CourseName;
    }
    public String getDescription(){
        return Description;
    }
    public int getCreditHours(){
        return CreditHours;
    }
    /****************Setters****************/
    public void setCourseID(String CourseID){
        this.CourseID=CourseID;
    }
    public void setCourseName(String CourseName){
        this.CourseName=CourseName;
    }
    public void setDescription(String Description){
        this.Description=Description;
    }
    public void setCreditHours(int CreditHours){
        this.CreditHours=CreditHours;
    }
}