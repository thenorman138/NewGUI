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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hunter
 */
public class Screen4Controller implements Initializable {

   
    //Initializing the Button that directs the user back to the home page
    @FXML
    private Button homeBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    
}
