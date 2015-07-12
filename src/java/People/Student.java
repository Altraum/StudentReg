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
public class Student {
    int ID;
    String Password;
    String FirstName;
    String LastName;
    String Street;
    String City;
    String State;
    int Zip;
    String Email;
    Double GPA;
    ScheduleList sl = new ScheduleList();
    /*************Constructors**************/
    public Student(int ID, String Password, String FirstName, String LastName, String Street, String City, String State, int Zip, String Email, Double GPA){
        setID(ID);
        setPassword(Password);
        setFirstName(FirstName);
        setLastName(LastName);
        setStreet(Street);
        setCity(City);
        setState(State);
        setZip(Zip);
        setEmail(Email);
        setGPA(GPA);
    }
    public Student(Student c){
        this.ID = c.getID();
        this.Password = c.getPassword();
        this.FirstName = c.getFirstName();
        this.LastName = c.getLastName();
        this.Street = c.getStreet();
        this.City = c.getCity();
        this.State = c.getState();
        this.Zip = c.getZip();
        this.Email = c.getEmail();
        this.GPA = c.getGPA();
    }
    public Student(){
        setID(0);
        setPassword("");
        setFirstName("");
        setLastName("");
        setStreet("");
        setCity("");
        setState("");
        setZip(0);
        setEmail("");
        setGPA(0d);
    }
    /****************Methods****************/
    /**
     * Finds the Student in the database that matches the given Student ID and gives the Student objects it's properties.
     * @param ID ID of the desired Student
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void selectDB(int ID)throws SQLException, ClassNotFoundException{
		
        System.out.println("Student.java Starting...");/*Test Message*/
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
        System.out.println("Connection established");/*Test Message*/
        Statement s = conn.createStatement();
        System.out.println("Statement created. ID: " + ID);/*Test Message*/
        ResultSet rs = s.executeQuery("SELECT * FROM Students WHERE ID = " + ID);
        System.out.println("Result set ready");/*Test Message*/
        rs.next();
        System.out.println("Next Result Set");/*Test Message*/
        this.setID(Integer.parseInt(rs.getString(1)));
        this.setFirstName(rs.getString(2));
        this.setLastName(rs.getString(3));
        this.setStreet(rs.getString(4));
        this.setCity(rs.getString(5));
        this.setState(rs.getString(6));
        this.setZip(Integer.parseInt(rs.getString(7)));
        this.setEmail(rs.getString(8));
        this.setGPA(Double.parseDouble(rs.getString(9)));
        this.setPassword(rs.getString(10));        
        System.out.println("Student Set");/*Test Message*/
        conn.close();
        Connection conn2 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
        System.out.println("Second Connection for Schedule");/*Test Message*/
        Statement s2 = conn2.createStatement();
        System.out.println("Second Statement Created");/*Test Message*/
        ResultSet rs2 = s2.executeQuery("SELECT CRN FROM StudentSchedule WHERE StudentID = " + ID);
        System.out.println("Starting Schedule Loop");/*Test Message*/
        while (rs2.next()){
            Section n = new Section();
            n.selectDB(rs2.getInt(1));
            sl.add(n);
            System.out.println("CRN pulled from StudentSchedule: " + rs2.getInt(1));
        }
        System.out.println("<p>Still going...</p>");/*Test Message*/
        conn2.close();
    }
	
    /**
     * Inserts a new Student into the database.
     * @param sid ID of new Student
     * @param pwd Password of new Student
     * @param fName First name of new Student
     * @param lName Last name of new Student
     * @param st Street new Student lives on
     * @param city City new Student lives in
     * @param state State new Student lives in
     * @param zip Zip Code of new Student
     * @param email Email address of new Student
     * @param gpa GPA of new Student
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void insertDB(int sid, String pwd, String fName, String lName, String st, String city, String state, int zip, String email, Double gpa) throws SQLException, ClassNotFoundException{
        
        Connection c1=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");
        
        PreparedStatement pstmt = c1.prepareStatement("INSERT INTO Students (ID, Password, FirstName, LastName, Street, City, State, Zip, EMail, GPA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, sid);
        pstmt.setString(2, pwd);
        pstmt.setString(3, fName);
        pstmt.setString(4, lName);
        pstmt.setString(5, st);
        pstmt.setString(6, city);
        pstmt.setString(7, state);
        pstmt.setInt(8, zip);
        pstmt.setString(9, email);
        pstmt.setDouble(10, gpa);
        pstmt.executeUpdate();
        pstmt.close();
        c1.close();
    }
	
    /**
     * Updates the Student in the database that shares an ID with the Student object to match the Student object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void updateDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("UPDATE Students SET Password = '" + this.Password + "', FirstName = '" + this.FirstName + "', LastName = '" + this.LastName + "', Street = '" + this.Street + "', City = '" + this.City + "', State = '" + this.State + "', Zip = '" + this.Zip + "', EMail = '" + this.Email + "', GPA = '" + this.GPA + "' WHERE ID = '" + ID + "'");

        conn.close();
    }
	
    /**
     * Deletes the Student in the database that matches the ID of the Student object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void deleteDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("DELETE FROM Students WHERE ID = '" + ID + "'");

        conn.close();
    }
    /****************Getters****************/
    public int getID(){
        return ID;
    }
    public String getPassword(){
        return Password;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getStreet(){
        return Street;
    }
    public String getCity(){
        return City;
    }
    public String getState(){
        return State;
    }
    public int getZip(){
        return Zip;
    }
    public String getEmail(){
        return Email;
    }
    public Double getGPA(){
        return GPA;
    }
    public ScheduleList getsList(){
        return sl;
    }
    /****************Setters****************/
    public void setID(int ID){
        this.ID=ID;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public void setFirstName(String FirstName){
        this.FirstName=FirstName;
    }
    public void setLastName(String LastName){
        this.LastName=LastName;
    }
    public void setStreet(String Street){
        this.Street=Street;
    }
    public void setCity(String City){
        this.City=City;
    }
    public void setState(String State){
        this.State=State;
    }
    public void setZip(int Zip){
        this.Zip=Zip;
    }
    public void setEmail(String Email){
        this.Email=Email;
    }
    public void setGPA(Double GPA){
        this.GPA=GPA;
    }
    public void setsList(ScheduleList sl){
        this.sl=sl;
    }
}
