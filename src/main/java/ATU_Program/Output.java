package ATU_Program;

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


public class Output extends Application{
	
//	 private static TableView table = new TableView();
	 private static double K1[];
	 private static double K2[];

//     private final static ObservableList<Student> data =
//             FXCollections.observableArrayList(
//                 new Student("20761648","hbx","12","1","hhl","90","80"),
//                 new Student("","","","2","jjh","",""),
//                 new Student("","","","","","","")
//             );
     
     @Override
     public void start(Stage stage) throws Exception{
    	FXMLLoader loader = new FXMLLoader();
     	loader.setLocation(getClass().getResource("/output.fxml"));
     	VBox root = (VBox) loader.load();
     	Scene scene = new Scene(root);
     	stage.setScene(scene);
     	stage.setTitle("Output");
     	stage.show();	
     }
     
     
     public static void table(String jkl) {
    	 TableView table = new TableView();
    	 
    	 ObservableList<Student> data =
                 FXCollections.observableArrayList(
                     new Student("20761648",jkl,"12","1","hhl","90","80"),
                     new Student("","","","2","jjh","",""),
                     new Student("","","","","","","")
                 );

    	 
    	 Stage stage = new Stage();
    	 Scene scene = new Scene(new Group());
         stage.setTitle("Project Team");
         stage.setWidth(800);
         stage.setHeight(500);
  
         final Label label = new Label("Project Team");
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
     }
     
     public static void chart() {
    	 // add chart
    	 	//Defining the x axis
    	         Stage stage_chart = new Stage();
    	      NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
    	      xAxis.setLabel("Years"); 
    	        
    	      //Defining the y axis   
    	      NumberAxis yAxis = new NumberAxis   (0, 350, 50); 
    	      yAxis.setLabel("No.of schools"); 
    	        
    	      //Creating the line chart 
    	      LineChart linechart = new LineChart(xAxis, yAxis);  
    	        
    	      //Prepare XYChart.Series objects by setting data 
    	      XYChart.Series series = new XYChart.Series(); 
    	      series.setName("K1"); 
    	        
    	      series.getData().add(new XYChart.Data(1970, 15)); 
    	      series.getData().add(new XYChart.Data(1980, 30)); 
    	      series.getData().add(new XYChart.Data(1990, 60)); 
    	      series.getData().add(new XYChart.Data(2000, 120)); 
    	      series.getData().add(new XYChart.Data(2013, 240)); 
    	      series.getData().add(new XYChart.Data(2014, 300)); 
    	      
    	      XYChart.Series series2 = new XYChart.Series(); 
    	      series2.setName("K2"); 
    	        
    	      series2.getData().add(new XYChart.Data(1970, 150)); 
    	      series2.getData().add(new XYChart.Data(1980, 320)); 
    	      series2.getData().add(new XYChart.Data(1990, 100)); 
    	      series2.getData().add(new XYChart.Data(2000, 120)); 
    	      series2.getData().add(new XYChart.Data(2013, 24)); 
    	      series2.getData().add(new XYChart.Data(2014, 220)); 

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
     }
     
     public static double[] getK1() {
    	 K1[0] = 0.7;
    	 K1[1] = 0.8;
    	 return K1;
     }
     
     public static double[] getK2() {
    	 K2[0] = 0.7;
    	 K2[1] = 0.8;
    	 return K2;
     }
     
        public static class Student{
            private final String mid;
            private final String mname;
            private final String team_num;
            private final String memid;
            private final String name;
            private final String k1;
            private final String k2;
    
            
            private Student(String Mid, String Mname, String Team_num,
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
            
            public String getMid() {
                return mid;
            }
    
            public String getMname() {
                return mname;
            }
    
            public String getMemid() {
                return memid;
            }
    
            public String getName() {
                return name;
            }
    
            public String getTeam_num() {
                return team_num;
            }
    
            public String getK1() {
                return k1;
            }
    
            public String getK2() {
                return k2;
            }
        }

        
        public static class Person {
             
            private String firstName;
            private final SimpleStringProperty lastName;
            private final SimpleStringProperty email;
     
            private Person(String fName, String lName, String email) {
                this.firstName = fName;
                this.lastName = new SimpleStringProperty(lName);
                this.email = new SimpleStringProperty(email);
            }
     
            public String getFirstName() {
                return firstName;
            }
     
            public void setFirstName(String fName) {
                firstName = fName;
            }
     
            public String getLastName() {
                return lastName.get();
            }
     
            public void setLastName(String fName) {
                lastName.set(fName);
            }
     
            public String getEmail() {
                return email.get();
            }
     
            public void setEmail(String fName) {
                email.set(fName);
            }
}
	
}