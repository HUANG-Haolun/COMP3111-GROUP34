package atu.input;
/**
 * Created by HUANG Haolun on 2022/10/20. 
 * This class is used to store the data of the csv file and show in the GUI.
 * It contains the data of the csv file and the methods to get the data.
 * It also contains the methods to set the data.
 * @author HUANG Haolun(hhuangbl@connect.ust.hk)
 * @version 1.0
 * @since 1.0
 */
import javafx.beans.property.SimpleStringProperty;

/**
 * This class is used to store the data of the csv file and show in the GUI.
 * It contains the data of the csv file and the methods to get the data.
 * It also contains the methods to set the data.
 */
public class Person {

    private final SimpleStringProperty studentid;
    private final SimpleStringProperty studentname;
    private final SimpleStringProperty k1energy;
    private final SimpleStringProperty k2energy;
    private final SimpleStringProperty k3trick1;
    private final SimpleStringProperty k3trick2;
    private final SimpleStringProperty mypreference;
    private final SimpleStringProperty concerns;
    private final SimpleStringProperty index;
    private int team_id;

    /**
     * This method is the constructor of the class Person.
     * @param student_id The student id of the person.
     * @param student_name The student name of the person.
     * @param k1_energy The energy of the k1 of the person.
     * @param k2_energy The energy of the k2 of the person.
     * @param k3_trick1 The number of the people who choose the k3 first trick.
     * @param k3_trick2 The number of the people who choose the k3 second trick.
     * @param my_preference The number of the people who prefer to do leader.
     * @param concerns The concerns of the person.
     * @param index The index of the person.
     */
    public Person(String student_id, String student_name, String k1_energy, String k2_energy, String k3_trick1,
                   String k3_trick2, String my_preference, String concerns, String index) {
        this.studentid = new SimpleStringProperty(student_id);
        this.studentname = new SimpleStringProperty(student_name);
        this.k1energy = new SimpleStringProperty(k1_energy);
        this.k2energy = new SimpleStringProperty(k2_energy);
        this.k3trick1 = new SimpleStringProperty(k3_trick1);
        this.k3trick2 = new SimpleStringProperty(k3_trick2);
        this.mypreference = new SimpleStringProperty(my_preference);
        this.concerns = new SimpleStringProperty(concerns);
        this.index = new SimpleStringProperty(index);
        this.team_id = 0;
    }

    
    /** 
     * This method is used to get the student id of the person.
     * @return String The student id of the person.
     */
    public String getStudentid() {
        return studentid.get();
    }

    
    /** 
     * This method is used to set the student id of the person.
     * @param val The student id of the person.
     */
    public void setStudentid(String val) {
        studentid.set(val);
    }

    
    /** 
     * This method is used to get the student name of the person.
     * @return String The student name of the person.
     */
    public String getStudentname() {
        return studentname.get();
    }

    
    /**
     * This method is used to set the student name of the person. 
     * @param val The student name of the person.
     */
    public void setStudentname(String val) {
        studentname.set(val);
    }

    
    /** 
     * This method is used to get the energy of the k1 of the person.
     * @return int The energy of the k1 of the person.
     */
    public int getK1energy() {
        return Integer.valueOf(k1energy.get());
    }

    
    /**
     * This method is used to set the energy of the k1 of the person. 
     * @param val The energy of the k1 of the person.
     */
    public void setK1energy(String val) {
        k1energy.set(val);
    }

    
    /**
     * This method is used to get the energy of the k2 of the person. 
     * @return int The energy of the k2 of the person.
     */
    public int getK2energy() {
        return Integer.valueOf(k2energy.get());
    }

    
    /**
     * This method is used to set the energy of the k2 of the person. 
     * @param val The energy of the k2 of the person.
     */
    public void setK2energy(String val) {
        k2energy.set(val);
    }

    
    /**
     * This method is used to get the number of the people who choose the k3 first trick. 
     * @return int The number of the people who choose the k3 first trick.
     */
    public int getK3trick1() {
        return Integer.valueOf(k3trick1.get());
    }

    
    /**
     * This method is used to set the number of the people who choose the k3 first trick. 
     * @param val The number of the people who choose the k3 first trick.
     */
    public void setK3trick1(String val) {
        k3trick1.set(val);
    }

    
    /**
     * This method is used to get the number of the people who choose the k3 second trick. 
     * @return int The number of the people who choose the k3 second trick.
     */
    public int getK3trick2() {
        return Integer.valueOf(k3trick2.get());
    }

    
    /**
     * This method is used to set the number of the people who choose the k3 second trick. 
     * @param val The number of the people who choose the k3 second trick.
     */
    public void setK3trick2(String val) {
        k3trick2.set(val);
    }

    
    /** 
     * This method is used to get the number of the people who prefer to do leader. 
     * @return int The number of the people who prefer to do leader.
     */
    public int getMypreference() {
        if(!mypreference.get().equals("")){
            return Integer.valueOf(mypreference.get());}
        else{
            return 0;
        }
    }

    
    /** 
     * This method is used to set the number of the people who prefer to do leader.
     * @param val The number of the people who prefer to do leader.
     */
    public void setMypreference(String val) {
        mypreference.set(val);
    }

    
    /**
     * This method is used to get the concerns of the person. 
     * @return String The concerns of the person.
     */
    public String getConcerns() {
        return concerns.get();
    }

    
    /** 
     * This method is used to set the concerns of the person.
     * @param val The concerns of the person.
     */
    public void setConcerns(String val) {
        concerns.set(val);
    }

    
    /**
     * This method is used to get the index of the person. 
     * @return String The index of the person.
     */
    public String getIndex() {
        return index.get();
    }

    
    /** 
     * This method is used to set the index of the person.
     * @param val The index of the person.
    */
    public void setIndex(String val) {
        index.set(val);
    }
    
    /**
     * This method is used to get the team id of the person. 
     * @return int The team id of the person.
     */
    public int get_team_id() {
    	return this.team_id;
    }
    
    /**
     * This method is used to set the team id of the person. 
     * @param num The team id of the person.
     */
    public void set_team_id(int num) {
    	this.team_id = num;
    }
}
