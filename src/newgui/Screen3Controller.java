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
import java.sql.SQLException;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Hunter
 */
public class Screen3Controller implements Initializable {
    
    
            @FXML private Button continuebtn;
            
            @FXML private TableView<SummerClass> table;
            
            @FXML private TableColumn<SummerClass, Integer> id;
            @FXML private TableColumn<SummerClass, String> dept;
            @FXML private TableColumn<SummerClass,Integer> number;
            @FXML private TableColumn<SummerClass, String> title;
            @FXML private TableColumn<SummerClass, String> day;
            @FXML private TableColumn<SummerClass, String> time;
            @FXML private TableColumn<SummerClass, Boolean> checkbox;
            
            private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
            private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();
        
            private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);
        
            private final int maxNumSelected = 3;
            
    public ObservableList<SummerClass> list1 = FXCollections.observableArrayList(
            new SummerClass (10001, "ACCT", 1010 , "Intro to Acct (3)", "MWF", "1:00 - 2:15" ),
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
            new SummerClass (10028, "STEM", 3010 , "Stem Education in Business (3)", "MWF", "1:00 - 2:15" )
);  
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        day.setCellValueFactory(new PropertyValueFactory<>("day"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
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
        private final SimpleIntegerProperty id;
        private final SimpleStringProperty dept;
        private final SimpleIntegerProperty number;
        private final SimpleStringProperty title;
        private final SimpleStringProperty day;
        private final SimpleStringProperty time;

        public SummerClass(Integer id, String dept, Integer number, String title, String day, String time) {
            this.id = new SimpleIntegerProperty (id);
            this.dept = new SimpleStringProperty(dept);
            this.number = new SimpleIntegerProperty (number);
            this.title = new SimpleStringProperty(title);
            this.day = new SimpleStringProperty(day);
            this.time = new SimpleStringProperty(time);
        }
       
        public Integer getId() {
            return id.get();
        }

        public String getDept() {
            return dept.get();
        }
        
        public Integer getNumber() {
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
    }   
    
    
    @FXML
    private void onContinue(ActionEvent event) throws IOException, SQLException {
    
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("Screen4.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(home_page_scene);
       app_stage.show();
}
    
}

