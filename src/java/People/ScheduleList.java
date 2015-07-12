package People;

import java.sql.*;
import java.util.ArrayList;

public class ScheduleList {
    ArrayList<Section> sectionList = new ArrayList();
    int count = 0;
    Section s1 = new Section();
    
    /**
     * Adds the Section that matches the given CRN to the ScheduleList
     * @param crn CRN of class to add
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void add(int crn)throws SQLException, ClassNotFoundException{
        System.out.println(crn + " coming through");
        s1.selectDB(crn);
        System.out.println("...");
        sectionList.add(s1);
        System.out.println("Section Added");
        count++;
    }
    
    /**
     * Adds the Section that matches the given Section object to the ScheduleList
     * @param s Section object to be added
     */
    public void add(Section s){
        System.out.println("Anything");
        sectionList.add(s);
        count++;
    }
    
    /**
     * Removes the Section that matches the given Section object from the ScheduleList
     * @param s Section object to be removed
     */
    public void remove(Section s){
        sectionList.remove(s);
        count--;
    }
    
    public Section getSection(int index){
        return sectionList.get(index);
    }
    
    public int getCount(){
        return count;
    }
}
