package ATU_Program;
/**
 * The class is used to generate the chart and table using the students infomation
 * 
 * @author bhuangak
 * @see ATU_Program.Output
 * @version 1.0
 * @since 1.0
 */

import java.io.*;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.chart.LineChart; 
import javafx.scene.chart.NumberAxis; 
import javafx.scene.chart.XYChart;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import atu.process.*;
import atu.input.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is used to generate the chart and table using the students infomation
 * after input the user information to find.
 */
public class Output{
	
//	 private static TableView table = new TableView();
	 private static Team[] teamlist;
	 private static List<Person> students;
	 private static List<Person> sort;
	 
	 /**
	  * The method is used to create the digits which are important to create the table and chart.
	  * @param teamList The array of all teams.
	  * @param STUdents The list of students who belong to the same group.
	  * @param decending The list of all studens in their k1 energy in decending order.
	  */
	 public static void createList(Team[] teamList, List<Person> STUdents, List<Person> decending) {
		 teamlist = teamList;
		 students = STUdents;
		 sort = decending;
	 }
	 
     
	 /**
	  * The method to generate students input GUI
	  * @throws Exception To avoid some trouble.
	  */
    public static void outputGUI() throws Exception{
    	 Stage stage = new Stage();
    	FXMLLoader loader = new FXMLLoader();
     	loader.setLocation(Output.class.getResource("/output.fxml"));
     	VBox root = (VBox) loader.load();
     	Scene scene = new Scene(root);
     	stage.setScene(scene);
     	stage.setTitle("Output");
     	stage.show();
     }
     
    
    /**
     * This method is used to build the chart graph
     * @param input_name The user name who use to find his/her group
     * @return int The chart graph
     */
    public static int table(String input_name, String input_id) {
    	Person Person_in = null;
    	
        if(input_name != "") {
        	for(int i=0 ; i < students.size() ; i++) {
        		String iter_name = students.get(i).getStudentname();
        		if(iter_name.equals(input_name) ) {
        			Person_in = students.get(i);
        			break;
        		}
        	}
        } else if(input_id != "") {
        	for(int i=0 ; i < students.size() ; i++) {
        		String iter_id = students.get(i).getStudentid();
        		if(iter_id.equals(input_id) ) {
        			Person_in = students.get(i);
        			input_name = students.get(i).getStudentname();
        			break;
        		}
        	}
        } else {
            return 1;
        }
        
    	if(Person_in == null) {
    		return 1;
    	}
    	
    	 TableView table = new TableView();
        int teamID = Person_in.get_team_id();
        Team team = teamlist[teamID-1];
        
        //  team overall info
         String teamid = String.valueOf(team.get_teamid());
         String leader_name = Person_in.getStudentname();
         String leader_id = String.valueOf(Person_in.getStudentid());
         int member_num = team.get_num();
         String k1_average = String.valueOf(team.get_K1_average());
         String k2_average = String.valueOf(team.get_K2_average());


         // teammates array
         Person A = team.get_A();
         Person B = team.get_B();
         Person C = team.get_C();
         Person D = team.get_D();
         List<Person> personList = new ArrayList<>();
         personList.add(A);
         personList.add(B);
         personList.add(C);
         personList.add(D);

         for(int i=0; i < member_num; i++){
            Person itr = personList.get(i);
            if(itr.getStudentname().equals(input_name)){
                personList.remove(i);
                break;
            }
         }

         // Person A
         Person A1 = personList.get(0);
         String A_name = A1.getStudentname();
         String A_K1 = String.valueOf(A1.getK1energy());
         String A_K2 = String.valueOf(A1.getK2energy());

         // Person B
         Person B1 = personList.get(1);
         String B_name = B1.getStudentname();
         String B_K1 = String.valueOf(B1.getK1energy());
         String B_K2 = String.valueOf(B1.getK2energy());       

         // extra_person info
         String ex_num = "";
         String ex_name = "";
         String ex_k1 = "";
         String ex_k2 = "";
         if(member_num == 4){
            ex_num = "3";
            Person C1 = personList.get(2);
            ex_name = C1.getStudentname();
            ex_k1 = String.valueOf(C1.getK1energy());
            ex_k2 = String.valueOf(C1.getK2energy());
         }
    	 


    	 ObservableList<Student> data =
                 FXCollections.observableArrayList(
                     new Student(leader_id,leader_name,teamid,"1",A_name,k1_average,k2_average),
                     new Student("","","","2",B_name,"",""),
                     new Student("","","",ex_num,ex_name,"","")
                 );
    	 
    	 
    	 Stage stage = new Stage();
    	 Scene scene = new Scene(new Group());
         stage.setTitle("Project Team");
         stage.setWidth(800);
         stage.setHeight(500);
         
         String leader = team.get_Leader();
         final Label label = new Label("Leader: "+leader);
         label.setFont(new Font("Arial", 20));
  
         table.setEditable(true);
         
         TableColumn input = new TableColumn("User's Input");
         TableColumn output = new TableColumn("Data Output");
         TableColumn col1 = new TableColumn("My Student Id");
         col1.setMinWidth(100);
         col1.setCellValueFactory(new PropertyValueFactory<Student, String>("mid"));
 
         TableColumn col2 = new TableColumn("My Name");
         col2.setMinWidth(100);
         col2.setCellValueFactory(new PropertyValueFactory<Student, String>("mname"));
 
         TableColumn col3 = new TableColumn("My Team No.");
         col3.setMinWidth(100);
         col3.setCellValueFactory(new PropertyValueFactory<Student, String>("team_num"));
 
         TableColumn col4 = new TableColumn("Team member");
         col4.setMinWidth(100);
         col4.setCellValueFactory(new PropertyValueFactory<Student, String>("memid"));
 
         TableColumn col5 = new TableColumn("Member name");
         col5.setMinWidth(100);
         col5.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
 
         TableColumn col6 = new TableColumn("K1_Average");
         col6.setMinWidth(100);
         col6.setCellValueFactory(new PropertyValueFactory<Student, String>("k1"));
 
         TableColumn col7 = new TableColumn("K2_Average");
         col7.setMinWidth(100);
         col7.setCellValueFactory(new PropertyValueFactory<Student, String>("k2"));
         
         input.getColumns().addAll(col1,col2);
         output.getColumns().addAll(col3,col4,col5,col6,col7);
         
         table.setItems(data);
         
         table.getColumns().addAll(input,output);
  
         final VBox vbox = new VBox();
         vbox.setSpacing(5);
         vbox.setPadding(new Insets(10, 0, 0, 10));
         vbox.getChildren().addAll(label, table);
  
         ((Group) scene.getRoot()).getChildren().addAll(vbox);
  
         stage.setScene(scene);
         stage.show();  
         
         return 0;
     }
     
    
    /**
     * This method is used to build the chart graph
     * @return the chart graph
     */
    public static int chart() {
    	 // add chart
    	if(sort == null) {
    		return 1;
    	}
    	 	//Defining the x axis
    	      Stage stage_chart = new Stage();
    	      NumberAxis xAxis = new NumberAxis(0,100,1); 
    	      xAxis.setLabel("Number of students = 100"); 
    	        
    	      //Defining the y axis   
    	      NumberAxis yAxis = new NumberAxis   (0,100,1); 
    	      yAxis.setLabel("Energy %"); 
    	        
    	      //Creating the line chart 
    	      LineChart linechart = new LineChart(xAxis, yAxis);  
    	        
    	      //Prepare XYChart.Series objects by setting data 
    	      XYChart.Series series = new XYChart.Series(); 
    	      series.setName("K1"); 

    	      
    	      XYChart.Series series2 = new XYChart.Series(); 
    	      series2.setName("K2"); 
    	      

              for(int i=0 ; i < sort.size() ; i++){
                int num = i+1;
                float k1 = sort.get(i).getK1energy();
                float k2 = sort.get(i).getK2energy();
                series.getData().add(new XYChart.Data(num, k1));
                series2.getData().add(new XYChart.Data(num, k2));
              }

    	      //Setting the data to Line chart    
    	      linechart.getData().add(series);    
    	      linechart.getData().add(series2);   
    	        
    	      //Creating a Group object  
    	      Group root = new Group(linechart); 
    	         
    	      //Creating a scene object 
    	      Scene scene2 = new Scene(root, 600, 400);  
    	      
    	      //Setting title to the Stage 
    	      stage_chart.setTitle("Line Chart"); 
    	         
    	      //Adding scene to the stage 
    	      stage_chart.setScene(scene2);
    		   
    	      //Displaying the contents of the stage 
    	      stage_chart.show();
    	      
    	      return 0;
     }
    
    
    /**
     * The class is used to save the students information who are from the same
     * team and load them to the table.
     */
    public static class Student{
            private final String mid;
            private final String mname;
            private final String team_num;
            private final String memid;
            private final String name;
            private final String k1;
            private final String k2;
            
            
            /**
             * This method is the constructor of the class Student for table input.
             * @param Mid The student id of the input student.
             * @param Mname The student name of the input student.
             * @param Team_num The number of the input student's name.
             * @param Memid The number of the teammate's order.
             * @param Name The name of the teammates.
             * @param K1 The k1 energy of the teammates.
             * @param K2 The k2 energy of the teammates.
             */
    
            
            public Student(String Mid, String Mname, String Team_num,
                    String Memid, String Name, String K1, String K2) 
            {
                this.mid = Mid;
                this.mname = Mname;
                this.team_num = Team_num;
                this.memid = Memid;
                this.name = Name;
                this.k1 = K1;
                this.k2 = K2;
            }
            
            
            /** 
             * This method is used to get the input student id.
             * @return  String The input student id.
             */
            public String getMid() {
                return mid;
            }
            
            /** 
             * This method is used to get the name of the input student.
             * @return String The student name of the input person.
             */
            public String getMname() {
                return mname;
            }
            
            /** 
             * This method is used to get the teammates' id of the input student.
             * @return String The student id of the Teammates.
             */
            public String getMemid() {
                return memid;
            }
            
            /** 
             * This method is used to get the teammates' name of the input student.
             * @return String The student name of the Teammates.
             */
            public String getName() {
                return name;
            }
            
            /** 
             * This method is used to get the team's id of the input student.
             * @return String The team's id.
             */
            public String getTeam_num() {
                return team_num;
            }
    
            /** 
             * This method is used to get the student's k1 energy.
             * @return String The K1 energy of the students.
             */
            public String getK1() {
                return k1;
            }
    
            /** 
             * This method is used to get the student's k2 energy.
             * @return String The K2 energy of the students.
             */
            public String getK2() {
                return k2;
            }
        }
	
}