package atu.input;

/**
 * Created by HUANG Haolun on 2022/10/20.
 * This class is used to store the data of the csv file and show the statistics by GUI.
 * It contains the data of the csv file and the methods to get the data.
 * It also contains the methods to set the data.
 * @author HUANG Haolun(mihawkhhuangbl@gmail.com)
 * @version 1.0
 * @since 1.0
 */
import javafx.beans.property.SimpleStringProperty;

/**
 * This class is used to store the data of the csv file and show the statistics by GUI.
 * It contains the data of the csv file and the methods to get the data.
 * It also contains the methods to set the data.
 */
public class Statistics {

    private final SimpleStringProperty entry;
    private final SimpleStringProperty value;
    private final SimpleStringProperty index;


    /**
     * This method is the constructor of the class Statistics.
     * @param fName The entry of the statistics.
     * @param lName The value of the statistics.
     * @param index The index of the statistics.
     */
    public Statistics(String fName, String lName, String index) {
        this.entry = new SimpleStringProperty(fName);
        this.value = new SimpleStringProperty(lName);
        this.index = new SimpleStringProperty(index);
    }

    
    /** 
     * This method is used to get the entry of the statistics.
     * @return String The entry of the statistics.
     */
    public String getEntry() {
        return entry.get();
    }

    
    /** 
     * This method is used to set the entry of the statistics.
     * @param val The entry of the statistics.
     */
    public void setEntry(String val) {
        entry.set(val);
    }

    
    /** 
     * This method is used to get the index of the statistics.
     * @return String The index of the statistics.
     */ 
    public String getValue() {
        return value.get();
    }

    
    /** 
     * This method is used to set the value of the statistics.
     * @param val The value of the statistics.
     */
    public void setValue(String val) {
        value.set(val);
    }

    
    /** 
     * This method is used to get the index of the statistics.
     * @return String The index of the statistics.
     */
    public String getIndex() {
        return index.get();
    }

    
    /** 
     * This method is used to set the index of the statistics.
     * @param val The index of the statistics.
     */
    public void setIndex(String val) {
        index.set(val);
    }

}

