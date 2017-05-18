/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;



/**
 *
 * @author Hunter
 */
public class FXMLDocumentController implements Initializable {
    
      
         @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
     
    }
    
    //initializing labels and fields used to recognize and store database information
    @FXML
    private Label label;
    @FXML
    private Label errorLabel;    
    @FXML
    private TextField UserField;
    @FXML
    private TextField PassField;
    
    //The following action assists in storing the correct schema from the database into the appropriate fields once matched
    //If the match parameters of ValidCredentials are met, the button opens up the next FXML screen
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("");
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       if(ValidCredentials())
       {
       app_stage.hide();   
       app_stage.setScene(home_page_scene);
       app_stage.show();    
    }
       //if no match, the fields are cleared and the error message populated
       else
       {
           UserField.clear();
           PassField.clear();
           errorLabel.setText("Please Check Your Info and Try Again");
           }
    }
    
    //the following method reads from the database table for userID and pass, then sets them to the corresponding fields to match the input
    private boolean ValidCredentials() throws SQLException
    {
        boolean let_in = false;
        System.out.println("SELECT * FROM userTable WHERE UserName= " + "'" + UserField.getText() + "'" + "AND Password= " + "'" + PassField.getText() + "'");
        
        Connection c = null;
        java.sql.Statement stmt = null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:/Users/Hunter/NetBeansProjects/NewGUI/studentUser.sqlite");
            c.setAutoCommit(false);
            
            System.out.println("Successful Database Query");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM userTable WHERE UserName= " + "'" + UserField.getText() + "'" + "AND Password= " + "'" + PassField.getText() + "'");
            
            while ( rs.next() ){
                if (rs.getString("UserName") != null && rs.getString("Password") != null){
                    String username = rs.getString("UserName");
                    System.out.println( "UserName = " + username );
                    String password = rs.getString("Password"); 
                    System.out.println("Password = " + password); 
                    let_in = true;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Successful");
        return let_in;
        
    }
    
    @FXML
    public void facultyButtonAction (ActionEvent event) throws IOException, SQLException  {
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("FacultyLanding.fxml"));
       Scene home_page_scene = new Scene(home_page_parent);
       Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_stage.setScene(home_page_scene);
       app_stage.show();
        
}
    
    
}
