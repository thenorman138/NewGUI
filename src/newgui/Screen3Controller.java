/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.lang.Integer;
import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Hunter
 */
public class Screen3Controller implements Initializable {
    
    
            Connection conn;
            PreparedStatement pst = null;
            ResultSet rs = null;
    
            @FXML private Button continuebtn;
            //@FXML private Button studAddCrseBtn;
            @FXML private Button yesBtn;
            @FXML private Button testbtn;
            
            //empty label used for successful result text after registration
            @FXML private Label regStatus;
                
            
            @FXML private TableView<SummerClass> table;
            
            @FXML private TableColumn<SummerClass, String> id;
            @FXML private TableColumn<SummerClass, String> dept;
            @FXML private TableColumn<SummerClass, String> number;
            @FXML private TableColumn<SummerClass, String> title;
            @FXML private TableColumn<SummerClass, String> day;
            @FXML private TableColumn<SummerClass, String> time;
            @FXML private TableColumn<SummerClass, String> credits;
            @FXML private TableColumn<SummerClass, Boolean> checkbox;
            
            
            @FXML private TextField CRNf;
            @FXML private TextField Deptf;
            @FXML private TextField Numf;
            @FXML private TextField Titlef;
            @FXML private TextField Dayf;
            @FXML private TextField Timef;
            @FXML private TextField Creditsf;
            
    
    
            
            private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
            private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();
        
            private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);
        
            @FXML
            private IntegerProperty index = new SimpleIntegerProperty();
            
            private final int maxNumSelected = 3;
            
            public void CheckConnection(){
            conn = databaseConnection.DbConnector();
            if(conn == null){
            System.out.println("Connection Not Successful");
            System.exit(1);
            }else{
            System.out.println("Connection Successful");
        }
    }
            
    public ObservableList<SummerClass> list1 = FXCollections.observableArrayList(
            /**new SummerClass (10001, "ACCT", 1010 , "Intro to Acct (3)", "MWF", "1:00 - 2:15" ),
            new SummerClass (10002, "ACCT", 2010 , "Acct for Bus. (3)", "MWF", "9:00 - 10:15" ),
            new SummerClass (10003, "ART", 1010 , "Fund. of Art (3)", "TR", "3:00 - 4:15" ),
            new SummerClass (10004, "ART", 1110 , "Art History (3)", "MWF", "1:00 - 2:15" ),
            new SummerClass (10005, "BIOL", 1010 , "Principles of Biology I (3)", "TR", "9:00 - 10:15" ),
            new SummerClass (10006, "BIOL", 2010 , "Principles of Biology II (3)", "MWF", "3:00 - 4:15" ),
            new SummerClass (10007, "CHEM", 1010 , "Principles of Chemistry I (3)", "MWF", "1:00 - 2:15" ),
            new SummerClass (10008, "CHEM", 2010 , "Principles of Chemistry II (3)", "TR", "9:00 - 10:15" ),
            new SummerClass (10009, "CPSC", 1010 , "Java I (3)", "TR", "3:00 - 4:15" ),
            new SummerClass (10010, "CPSC", 2010 , "Java II (3)", "MWF", "9:00 - 10:15" ),
            new SummerClass (10011, "ENGL", 1010 , "Composition I (3)", "MWF", "1:00 - 2:15" ),
            new SummerClass (10012, "ENGL", 2010 , "Composition II (3)", "TR", "3:00 - 4:15" ),
            new SummerClass (10013, "FIN", 1010 , "Principles of Finance I (3)", "MWF", "1:00 - 2:15" ),
            new SummerClass (10014, "FIN", 2010 , "Principles of Finance II (3)", "TR", "9:00 - 10:15" ),
            new SummerClass (10015, "GEO", 1010 , "Intro to Geology (3)", "MWF", "3:00 - 4:15" ),
            new SummerClass (10016, "GEO", 3610 , "Geology in History (3)", "TR", "1:00 - 2:15" ),
            new SummerClass (10017, "HIST", 1210 , "Western History (3)", "MWF", "9:00 - 10:15" ),
            new SummerClass (10018, "HIST", 1510 , "Fund. of History (3)", "MWF", "3:00 - 4:15" ),
            new SummerClass (10019, "MATH", 1010 , "Elementary Algebra (3)", "TR", "1:00 - 2:15" ),
            new SummerClass (10020, "MATH", 2010 , "Linear Algebra (3)", "MWF", "9:00 - 10:15" ),
            new SummerClass (10021, "NUTR", 1010 , "Nutrition Fundamentals (3)", "TR", "3:00 - 4:15" ),
            new SummerClass (10022, "PHYS", 1010 , "Intro to Physics (3)", "MWF", "1:00 - 2:15" ),
            new SummerClass (10023, "PHYS", 2010 , "Physics II (3)", "MWF", "9:00 - 10:15" ),
            new SummerClass (10024, "POL", 1010 , "Political Science I (3)", "TR", "3:00 - 4:15" ),
            new SummerClass (10025, "POL", 1010 , "Political Science II (3)", "MWF", "1:00 - 2:15" ),
            new SummerClass (10026, "STEM", 1010 , "Stem Education I (3)", "TR", "9:00 - 10:15" ),
            new SummerClass (10027, "STEM", 2010 , "Advanced Stem Education (3)", "TR", "3:00 - 4:15" ),
            new SummerClass (10028, "STEM", 3010 , "Stem Education in Business (3)", "MWF", "1:00 - 2:15" )**/
);  
    
    /**
     *
     */
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        CheckConnection();
        
        //list1.clear();
        
      table.setOnMouseClicked (event ->{
        try{
            SummerClass sc = (SummerClass)table.getSelectionModel().getSelectedItem();
            
            String query = "SELECT * FROM courseSchedule WHERE CRN = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1,sc.getId());
            rs = pst.executeQuery();
            
            while(rs.next()){
                CRNf.setText(rs.getString("CRN"));
                Deptf.setText(rs.getString("Dept"));
                Numf.setText(rs.getString("Num"));
                Titlef.setText(rs.getString("Title"));
                Dayf.setText(rs.getString("Day"));
                Timef.setText(rs.getString("Time"));
                Creditsf.setText(rs.getString("Credits"));
            }
            
            pst.close();
            rs.close();
            
        }catch(SQLException ex){
            
        }
    });
    
        
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        day.setCellValueFactory(new PropertyValueFactory<>("day"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        credits.setCellValueFactory(new PropertyValueFactory<>("credits"));
        checkbox.setCellValueFactory(new PropertyValueFactory<SummerClass, Boolean>(""));
        checkbox.setCellFactory(new Callback<TableColumn<SummerClass, Boolean>, TableCell<SummerClass, Boolean>>(){
            public TableCell<SummerClass, Boolean> call(TableColumn<SummerClass, Boolean> p){
                return new CheckBoxTableCell<SummerClass, Boolean>();
            }
        
    });
        
        
        table.setItems(list1); 
       
        
        //configureCheckBox(checkBox);
       
        
        
        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount)->{
            if (newSelectedCount.intValue() >= maxNumSelected){
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(true));
            }else{
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(false));
            }
        });
        
       /**table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>(){
            
            public void changed(ObservableValue<?> observable, Object oldvalue, Object newValue){
                index.set(list1.indexOf(newValue));
                System.out.println("Selected Row is:" +newValue);
                
                
            }
            
        });**/

       
        
    }
    
    
    private void configureCheckBox(CheckBox checkBox){
        if (checkBox.isSelected()){
            selectedCheckBoxes.add(checkBox);
        }else{
            unselectedCheckBoxes.add(checkBox);
        }
        
        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) ->{
            if (isNowSelected){
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            }else{
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }
        });
    }
 
    public static class CheckBoxTableCell<S,T> extends TableCell<S,T>{
        
        private final CheckBox checkBox;
        private ObservableValue<T> ov;
        
        
        public CheckBoxTableCell(){
            this.checkBox = new CheckBox();
            this.checkBox.setAlignment(Pos.CENTER);
            
            
            
            setAlignment(Pos.CENTER);
            setGraphic(checkBox);
        }
        
        @Override public void updateItem(T item, boolean empty){
            super.updateItem(item, empty);
            if(empty){
                setText(null);
                setGraphic(null);
            }else{
                setGraphic(checkBox);
                if(ov instanceof BooleanProperty){
                    checkBox.selectedProperty().unbindBidirectional((BooleanProperty)ov);
                }
                ov = getTableColumn().getCellObservableValue(getIndex());
                if (ov instanceof BooleanProperty){
                    checkBox.selectedProperty().bindBidirectional((BooleanProperty) ov);
                }
            }
        }
        
        
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
    
    @FXML
    public void onAddCourse(ActionEvent event) throws IOException, SQLException{
        
        
        //list1.remove(index.get());
        
        //regStatus.setText("10009 | CPSC | 1010 | Java I | (3) | TR | 3:00 - 4:15");
        //regStatus.setTextAlignment(TextAlignment.CENTER);   
        
    }
    
    @FXML
    public void testAction(ActionEvent event) throws IOException, SQLException{
        try{
            String query = "select * from courseSchedule";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                list1.add(new SummerClass(
                rs.getString("CRN"),
                rs.getString("Dept"),
                rs.getString("Num"),        
                rs.getString("Title"),
                rs.getString("Day"),
                rs.getString("Time"),
                rs.getString("Credits")
                ));
                table.setItems(list1);
            }
            pst.close();
            rs.close();
        }catch(Exception e2){
            System.err.println(e2);
        }
        list1.clear();
        try{
            String query = "select * from courseSchedule";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                list1.add(new SummerClass(
                rs.getString("CRN"),
                rs.getString("Dept"),
                rs.getString("Num"),        
                rs.getString("Title"),
                rs.getString("Day"),
                rs.getString("Time"),
                rs.getString("Credits")
                ));
                table.setItems(list1);
            }
            pst.close();
            rs.close();
        }catch(Exception e2){
            System.err.println(e2);
        }
        
    }
    
    
    @FXML
    private void onContinue(ActionEvent event) throws IOException, SQLException {
        
        try{
            String query = "INSERT INTO studentSchedule (CRN, Dept, Num, Title, Day, Time, Credits) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, CRNf.getText());
            pst.setString(2, Deptf.getText());
            pst.setString(3, Numf.getText());
            pst.setString(4, Titlef.getText());
            pst.setString(5, Dayf.getText());
            pst.setString(6, Timef.getText());
            pst.setString(7, Creditsf.getText());
            pst.execute();
            pst.close();
            CRNf.clear();
            
            //facultyTable.setItems(dbData);    
        }catch(Exception e3){
            System.err.println(e3);
        }
    
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("Screen4.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(home_page_scene);
       app_stage.show();
       
       
}
    
    
}

