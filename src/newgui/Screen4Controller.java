/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import newgui.Screen3Controller.SummerClass;

/**
 * FXML Controller class
 *
 * @author Hunter
 */
public class Screen4Controller implements Initializable {

   
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //Initializing the Button that directs the user back to the home page
    @FXML
    private Button homeBtn;
    
    @FXML private TableView <SummerClass> table2;
    @FXML private TableColumn<SummerClass, String> id4;
    @FXML private TableColumn<SummerClass, String> dept4;
    @FXML private TableColumn<SummerClass, String> number4;
    @FXML private TableColumn<SummerClass, String> title4;
    @FXML private TableColumn<SummerClass, String> day4;
    @FXML private TableColumn<SummerClass, String> time4;
    @FXML private TableColumn<SummerClass, String> credits4; 
    
    
    public ObservableList<SummerClass> confirm = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CheckConnection();
        
        try{
            String query = "select * from studentSchedule";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                confirm.add(new SummerClass(
                rs.getString("CRN"),
                rs.getString("Dept"),
                rs.getString("Num"),        
                rs.getString("Title"),
                rs.getString("Day"),
                rs.getString("Time"),
                rs.getString("Credits")
                ));
                table2.setItems(confirm);
            }
            pst.close();
            rs.close();
        }catch(Exception e2){
            System.err.println(e2);
        }
        
        
        id4.setCellValueFactory(new PropertyValueFactory<>("id"));
        dept4.setCellValueFactory(new PropertyValueFactory<>("dept"));
        number4.setCellValueFactory(new PropertyValueFactory<>("number"));
        title4.setCellValueFactory(new PropertyValueFactory<>("title"));
        day4.setCellValueFactory(new PropertyValueFactory<>("day"));
        time4.setCellValueFactory(new PropertyValueFactory<>("time"));
        credits4.setCellValueFactory(new PropertyValueFactory<>("credits"));
    }    
    
    public void CheckConnection(){
            conn = databaseConnection.DbConnector();
            if(conn == null){
            System.out.println("Connection Not Successful");
            System.exit(1);
            }else{
            System.out.println("Connection Successful");
        }
    }
    
    //Following action uses the button handler to redirect back to the home page
     @FXML
    private void homeAction(ActionEvent event) throws IOException, SQLException {
    
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(home_page_scene);
       app_stage.show();
}
    
    public class SummerClass{
        private final SimpleStringProperty id;
        private final SimpleStringProperty dept;
        private final SimpleStringProperty number;
        private final SimpleStringProperty title;
        private final SimpleStringProperty day;
        private final SimpleStringProperty time;
        private final SimpleStringProperty credits;

        public SummerClass(String id, String dept, String number, String title, String day, String time, String credits) {
            this.id = new SimpleStringProperty (id);
            this.dept = new SimpleStringProperty(dept);
            this.number = new SimpleStringProperty (number);
            this.title = new SimpleStringProperty(title);
            this.day = new SimpleStringProperty(day);
            this.time = new SimpleStringProperty(time);
            this.credits = new SimpleStringProperty(credits);
        }
       
        public String getId() {
            return id.get();
        }

        public String getDept() {
            return dept.get();
        }
        
        public String getNumber() {
            return number.get();
        }

        public String getTitle() {
            return title.get();
        }
        
        public String getDay() {
            return day.get();
        }
        
        public String getTime() {
            return time.get();
        }
        
        public String getCredits(){
            return credits.get();
        }
    }   
}
