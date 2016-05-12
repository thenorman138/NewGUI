/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.python.google.common.collect.Table;

/**
 * FXML Controller class
 *
 * @author Hunter
 */
public class FacultyLandingController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        CRNColumn.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, Integer>("CRN"));
        DeptColumn.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Dept"));
        NumColumn.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Num"));
        TitleColumn.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Title"));
        DayColumn.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Day"));
        TimeColumn.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Time"));
        CreditColumn.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Credits")); 
        
        CRNAddCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, Integer>("CRN"));
        DeptAddCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Dept"));
        NumAddCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Num"));
        TitleAddCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Title"));
        DayAddCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Day"));
        TimeAddCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Time"));
        CreditAddCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Credits")); 
        
        CRNDeleteCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, Integer>("CRN"));
        DeptDeleteCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Dept"));
        NumDeleteCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Num"));
        TitleDeleteCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Title"));
        DayDeleteCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Day"));
        TimeDeleteCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Time"));
        CreditDeleteCol.setCellValueFactory(new PropertyValueFactory<facultyScheduleTable, String>("Credits"));
        
        deleteTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>(){
            
            public void changed(ObservableValue<?> observable, Object oldvalue, Object newValue){
                index.set(data.indexOf(newValue));
            }
            
        });
        
        facultyTable.setItems(data);
        additionTable.setItems(data1);
        deleteTable.setItems(data);
        
    }
    
    //defining tabPane and tabs
    @FXML
    TabPane tabPane1;
    @FXML
    Tab SchedTab;
    @FXML
    Tab AddTab;
    @FXML
    Tab DeleteTab;        
  
    //defining table and columns
    @FXML
    private TableView <facultyScheduleTable> facultyTable;
    @FXML
    private TableColumn <facultyScheduleTable, Integer> CRNColumn;
    @FXML
    private TableColumn <facultyScheduleTable, String> DeptColumn;
    @FXML
    private TableColumn <facultyScheduleTable, String> NumColumn;
    @FXML
    private TableColumn <facultyScheduleTable, String> TitleColumn;
    @FXML
    private TableColumn <facultyScheduleTable, String> DayColumn;
    @FXML
    private TableColumn <facultyScheduleTable, String> TimeColumn;
    @FXML
    private TableColumn <facultyScheduleTable, String> CreditColumn;
    
    //defining the table that reflects addition changes
    @FXML
    private TableView <facultyScheduleTable> additionTable;
    @FXML
    private TableColumn <facultyScheduleTable, Integer> CRNAddCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> DeptAddCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> NumAddCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> TitleAddCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> DayAddCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> TimeAddCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> CreditAddCol;
    
    //defining the table that holds the list subject to deletion
    @FXML
    private TableView<facultyScheduleTable> deleteTable;
    @FXML
    private TableColumn <facultyScheduleTable, Integer> CRNDeleteCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> DeptDeleteCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> NumDeleteCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> TitleDeleteCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> DayDeleteCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> TimeDeleteCol;
    @FXML
    private TableColumn <facultyScheduleTable, String> CreditDeleteCol;
    
    
    
    
    //defining textFields
    @FXML
    private TextField DeptField;
    @FXML
    private TextField CourseNumField ;    
    @FXML
    private TextField CourseTitleField;
    @FXML
    private TextField DayField;
    @FXML
    private TextField TimeField;
    @FXML
    private TextField CreditField;
    
    //Defining Buttons
    @FXML
    private Button addHomeBtn;
    @FXML
    private Button delHomeBtn;
    @FXML
    private Button AddCourseBtn;
    @FXML
    private Button DeleteCourseBtn;
    @FXML
    private Button LogoutButton;
    
    @FXML
    private int startCRN = 20201;
    @FXML
    final ObservableList<facultyScheduleTable> data = FXCollections.observableArrayList(
            
        new facultyScheduleTable(startCRN++,"CPSC","1010","Intro to Java","MWF","9:00-10:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","1020","Java II","TR","9:00-10:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","2110","Operating Systems","TR","12:00-1:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","2120","O.S. II","MWF","2:00-3:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","2130","Network Structures","MWF","9:00-10:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","3110","Advanced Algorithms","TR","1:00-2:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","3120","Intro to Databases","T","3:00-4:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","4220","Database Management","MTR","11:00-12:15","3"),
        new facultyScheduleTable(startCRN++,"CPSC","4700","System Architectures","W","9:15-11:15","3")
    );
    
    
    @FXML
    final ObservableList<facultyScheduleTable> data1 = FXCollections.observableArrayList();
    
    @FXML
    public void addCourseAction(ActionEvent event) throws IOException, SQLException{
        
        facultyScheduleTable entry = new facultyScheduleTable(startCRN, DeptField.getText(), CourseNumField.getText(), CourseTitleField.getText(),DayField.getText(),TimeField.getText(), CreditField.getText() );
        startCRN++;
        
        facultyScheduleTable entry1 = new facultyScheduleTable(startCRN, DeptField.getText(), CourseNumField.getText(), CourseTitleField.getText(),DayField.getText(),TimeField.getText(), CreditField.getText() );
        startCRN++;

        data.add(entry);
        data1.add(entry1);
        
        DeptField.clear();
        CourseNumField.clear();
        CourseTitleField.clear();
        DayField.clear();
        TimeField.clear();
        CreditField.clear();
        
        
        
        
        
        
        //tabPane1.getSelectionModel().select(SchedTab);
    }
    
    @FXML
    private IntegerProperty index = new SimpleIntegerProperty();
    
    @FXML
    public void deleteCourseAction(ActionEvent event) throws IOException, SQLException{
        data.remove(index.get());
        deleteTable.getSelectionModel().clearSelection();
        
    }
    
    @FXML
    public void logoutAction(ActionEvent event) throws IOException, SQLException{
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(home_page_scene);
       app_stage.show();
    }
    
    
  
  
    
    @FXML
    public void getAddTabAction(ActionEvent event) throws IOException, SQLException{
        tabPane1.getSelectionModel().select(AddTab);
    }
    @FXML
    public void getDeleteTabAction(ActionEvent event) throws IOException, SQLException{
        tabPane1.getSelectionModel().select(DeleteTab);
    }
    @FXML
    public void getSchedTabAction(ActionEvent event) throws IOException, SQLException{
        tabPane1.getSelectionModel().select(SchedTab);
    }
    
  
}
