/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hunter
 */
public class Screen2Controller implements Initializable {
    
    
    //initialize drop down box
    @FXML
    private ComboBox<String> comboBox;
    
    
    //Button action opens new fxml screen
    @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException, SQLException {
    
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("Screen3.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(home_page_scene);
       app_stage.show();
}
    
    //method to create observable list stored in dropdown box
    @FXML
    private void newAction(ActionEvent event){
    
    }
        ObservableList<String> list = FXCollections.observableArrayList(
        "Summer - 2016", "Fall - 2016");
    ; 

    //method that applies list to comboBox/dropdown
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.setItems(list);
    }    
    
}
