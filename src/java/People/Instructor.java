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
public class Instructor {
    int ID;
    String FirstName;
    String LastName;
    String Street;
    String City;
    String State;
    int Zip;
    String Office;
    String Email;
    /*************Constructors**************/
    public Instructor(int ID, String FirstName, String LastName, String Street, String City, String State, int Zip, String Office, String Email){
        setID(ID);
        setFirstName(FirstName);
        setLastName(LastName);
        setStreet(Street);
        setCity(City);
        setState(State);
        setZip(Zip);
        setOffice(Office);
        setEmail(Email);
    }
    public Instructor(Instructor c){
        this.ID = c.getID();
        this.FirstName = c.getFirstName();
        this.LastName = c.getLastName();
        this.Street = c.getStreet();
        this.City = c.getCity();
        this.State = c.getState();
        this.Zip = c.getZip();
        this.Office = c.getOffice();
        this.Email = c.getEmail();
    }
    public Instructor(){
        setID(0);
        setFirstName("");
        setLastName("");
        setStreet("");
        setCity("");
        setState("");
        setZip(0);
        setOffice("");
        setEmail("");
    }
    /****************Methods****************/
    /**
     * Finds the Instructor in the database that matches the given Instructor ID and gives the Instructor objects it's properties.
     * @param ID ID of the desired Instructor
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void selectDB(int ID)throws SQLException, ClassNotFoundException{
		
        System.out.println("<p>Starting...</p>");/*Test Message*/
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/ChattBankMDB.mdb");
        System.out.println("<p>Connection established</p>");/*Test Message*/
        Statement s = conn.createStatement();
        System.out.println("<p>Statement created</p>");/*Test Message*/
        ResultSet rs = s.executeQuery("SELECT * FROM Instructors WHERE ID = " + ID);
        System.out.println("<p>Result set ready</p>");/*Test Message*/
        rs.next();
        System.out.println("Next...");/*Test Message*/
        this.setID(Integer.parseInt(rs.getString(1)));
        this.setFirstName(rs.getString(2));
        this.setLastName(rs.getString(3));
        this.setStreet(rs.getString(4));
        this.setCity(rs.getString(5));
        this.setState(rs.getString(6));
        this.setZip(Integer.parseInt(rs.getString(7)));
        this.setOffice(rs.getString(8));
        this.setEmail(rs.getString(9));
        System.out.println("Instructor Set");/*Test Message*/
        conn.close();
    }
    
    /**
     * Inserts a new Instructor into the database.
     * @param ID ID of new Instructor
     * @param FirstName First name of new Instructor
     * @param LastName Last name of new Instructor
     * @param Street Street the new Instructor lives on
     * @param City City the new Instructor lives in
     * @param State State the new Instructor lives in
     * @param Zip Zip code of the new Instructor
     * @param Office Office number of the new Instructor
     * @param Email Email address of the new Instructor
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void insertDB(int ID, String FirstName, String LastName, String Street, String City, String State, int Zip, String Office, String Email) throws SQLException, ClassNotFoundException{

        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/RegistrationMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("insert into Instructors(ID, FirstName, LastName, Street, City, State, Zip, Office, EMail) values ('" + ID + "', '" + FirstName + "', '" + LastName + "', '" + Street + "', '" + City + "', '" + State + "', '" + Zip + "', '" + Office + "', '" + Email + "')");

        conn.close();
    }
    
    /**
     * Updates the Instructor in the database that shares an ID with the Instructor object to match the Instructor object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void updateDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/ChattBankMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("UPDATE Instructors SET FirstName = '" + this.FirstName + "', LastName = '" + this.LastName + "', Street = '" + this.Street + "', City = '" + this.City + "', State = '" + this.State + "', Zip = '" + this.Zip + "', Office = '" + this.Office + "', EMail = '" + this.Email + "' WHERE ID = '" + ID + "'");

        conn.close();
    }
    
    /**
     * Deletes the Instructor in the database that matches the ID of the Instructor object.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void deleteDB() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Basil/Desktop/java/Java III/ChattBankMDB.mdb");

        Statement s = conn.createStatement();

        s.executeUpdate ("DELETE FROM Instructors WHERE ID = '" + ID + "'");

        conn.close();
    }
    /****************Getters****************/
    public int getID(){
        return ID;
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
    public String getOffice(){
        return Office;
    }
    public String getEmail(){
        return Email;
    }
    /****************Setters****************/
    public void setID(int ID){
        this.ID=ID;
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
    public void setOffice(String Office){
        this.Office=Office;
    }
    public void setEmail(String Email){
        this.Email=Email;
    }
}