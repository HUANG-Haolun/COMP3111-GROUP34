package atu.input;
/**
 * Created by HUANG Haolun on 2022/10/20.
 * this is for showing the input data in the GUI
 * @author HUANG Haolun(hhuangbl@connect.ust.hk)
 * @version 1.0
 * @since 1.0
 * @see atu.input.Person
 * @see atu.input.Statistics
 */
import java.io.*;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import atu.input.*;
/**
 * This class is used to show the input data in the GUI.
 */
public class UIApplication{
    private static TableView<Statistics> stat_table = new TableView<Statistics>();
    private static TableView<Person> person_table = new TableView<Person>();

    private final static ObservableList<Statistics> stat_data = FXCollections.observableArrayList();
    
    private final static ObservableList<Person> person_data = FXCollections.observableArrayList();
    
    public static final String delimiter = ",";

    public static final String quotation = "\"";

    /**
     * This method is used to read the csv file and store the data in the table.
     * @param csvFile The name of the csv file.
     * @return PeopleList The data of the csv file.
     */
    public static PeopleList read(String csvFile) {
        System.out.print("\n");
        PeopleList students = new PeopleList();
        try {
            File file = new File(csvFile);
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = " ";
            String[] tempArr;
            String[] tempArr1;
            br.readLine(); // skip the first line
            int i = 0;
            float[] k1_energy = {0,100,0};
            float[] k2_energy = {0,100,0};
            int k3_tick1 = 0;
            int k3_tick2 = 0;
            int my_pref = 0;
            while ((line = br.readLine()) != null) {
                tempArr1 = line.split(quotation);
                tempArr = tempArr1[4].split(delimiter);
                if(tempArr1[6].equals(","))
                {
                    tempArr1[6] = "";
                }
                Person tempStu = new Person(tempArr1[0].substring(0,tempArr1[0].length()-1), tempArr1[1], tempArr[1], tempArr[2], tempArr[3], tempArr[4],
                        tempArr1[5], tempArr1[6], String.valueOf(i));
                person_data.add(tempStu);
                students.addStudent(tempStu);
                i++;
                if(Integer.valueOf(tempArr[1]) > k1_energy[2]){
                    k1_energy[2] = Integer.valueOf(tempArr[1]);
                } else if (Integer.valueOf(tempArr[1]) <k1_energy[1]) {
                    k1_energy[1] = Integer.valueOf(tempArr[1]);
                }
                k1_energy[0] += Integer.valueOf(tempArr[1]);
                if(Integer.valueOf(tempArr[2]) > k2_energy[2]){
                    k2_energy[2] = Integer.valueOf(tempArr[2]);
                } else if (Integer.valueOf(tempArr[2]) <k2_energy[1]) {
                    k2_energy[1] = Integer.valueOf(tempArr[2]);
                }
                k2_energy[0] += Integer.valueOf(tempArr[2]);
                if(tempArr[3].equals("1")){
                    k3_tick1++;
                }
                if(tempArr[4].equals("1")){
                    k3_tick2++;
                }
                if(tempArr1[5].equals("1")){
                    my_pref++;
                }
            }
            br.close();
            k1_energy[0] /= i;
            k2_energy[0] /= i;
            students.setk1(k1_energy);
            students.setk2(k2_energy);
            students.setk3t1(k3_tick1);
            students.setk3t2(k3_tick2);
            students.setpref(my_pref);
            stat_data.add(new Statistics("Total Number of Students", String.valueOf(i),"0"));
            stat_data.add(new Statistics("K1_Energy(Average, Min, Max)", "("+String.valueOf(k1_energy[0])+", "+String.valueOf((int)(k1_energy[1]))+", "+String.valueOf((int)(k1_energy[2]))+")","1"));
            stat_data.add(new Statistics("K2_Energy(Average, Min, Max)", "("+String.valueOf(k2_energy[0])+", "+String.valueOf((int)(k2_energy[1]))+", "+String.valueOf((int)(k2_energy[2]))+")","2"));
            stat_data.add(new Statistics("K3_Tick1 = 1", String.valueOf(k3_tick1),"3"));
            stat_data.add(new Statistics("K3_Tick2 = 1", String.valueOf(k3_tick2),"4"));
            stat_data.add(new Statistics("My_Preference = 1", String.valueOf(my_pref),"5"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return students;
    }
    
    /**
     * This method is used to show the data in the GUI.
     */
    public static void inputUI(){
    	Stage stage_stat = new Stage();
        Scene scene_stat = new Scene(new Group());
        stage_stat.setTitle("Table of students' personal data");
        stage_stat.setWidth(350);
        stage_stat.setHeight(500);

        final Label label_stat = new Label("Statistics");
        label_stat.setFont(new Font("Arial", 20));

        stat_table.setEditable(true);

        TableColumn raw_index_column = new TableColumn("Row_Index");
        raw_index_column.setMinWidth(100);
        raw_index_column.setCellValueFactory(new PropertyValueFactory<Person, String>("index"));

        TableColumn entry_column = new TableColumn("Entry");
        entry_column.setMinWidth(100);
        entry_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("entry"));

        TableColumn value_column = new TableColumn("Value");
        value_column.setMinWidth(100);
        value_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("value"));

        stat_table.setItems(stat_data);
        stat_table.getColumns().addAll(raw_index_column, entry_column, value_column);
        stat_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final VBox vbox_stat = new VBox();
        vbox_stat.setSpacing(5);
        vbox_stat.setPadding(new Insets(10, 0, 0, 10));
        vbox_stat.getChildren().addAll(label_stat, stat_table);

        ((Group) scene_stat.getRoot()).getChildren().addAll(vbox_stat);

        stage_stat.setScene(scene_stat);
        stage_stat.show();

        Stage stage_person = new Stage();
        Scene scene_person = new Scene(new Group());
        stage_person.setTitle("Table of statistics data");
        stage_person.setWidth(1100);
        stage_person.setHeight(500);

        final Label label_person = new Label("Person");
        label_person.setFont(new Font("Arial", 20));

        person_table.setEditable(true);

        TableColumn raw_index_column_statistic = new TableColumn("Row_Index");
        raw_index_column_statistic.setMinWidth(100);
        raw_index_column_statistic.setCellValueFactory(new PropertyValueFactory<Person, String>("index"));


        TableColumn studentid_column = new TableColumn("Student_ID");
        studentid_column.setMinWidth(100);
        studentid_column.setCellValueFactory(new PropertyValueFactory<Person, String>("studentid"));

        TableColumn studentname_column = new TableColumn("Student_Name");
        studentname_column.setMinWidth(250);
        studentname_column.setCellValueFactory(new PropertyValueFactory<Person, String>("studentname"));

        TableColumn k1energy_column = new TableColumn("K1_Energy");
        k1energy_column.setMinWidth(100);
        k1energy_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k1energy"));

        TableColumn k2energy_column = new TableColumn("k2_Energy");
        k2energy_column.setMinWidth(100);
        k2energy_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k2energy"));

        TableColumn k3trick1_column = new TableColumn("K3_Trick1");
        k3trick1_column.setMinWidth(100);
        k3trick1_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k3trick1"));

        TableColumn k3trick2_column = new TableColumn("K3_Trick2");
        k3trick2_column.setMinWidth(100);
        k3trick2_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k3trick2"));

        TableColumn mypreference_column = new TableColumn("My_Preference");
        mypreference_column.setMinWidth(100);
        mypreference_column.setCellValueFactory(new PropertyValueFactory<Person, String>("mypreference"));

        TableColumn concerns_column = new TableColumn("Concerns");
        concerns_column.setMinWidth(100);
        concerns_column.setCellValueFactory(new PropertyValueFactory<Person, String>("concerns"));

        person_table.setItems(person_data);
        person_table.getColumns().addAll(raw_index_column_statistic, studentid_column, studentname_column, k1energy_column, k2energy_column,
                k3trick1_column, k3trick2_column, mypreference_column, concerns_column);
        person_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final VBox vbox_person = new VBox();
        vbox_person.setSpacing(5);
        vbox_person.setPadding(new Insets(10, 0, 0, 10));
        vbox_person.getChildren().addAll(label_person, person_table);

        ((Group) scene_person.getRoot()).getChildren().addAll(vbox_person);

        stage_person.setScene(scene_person);
        stage_person.show();
    }
}