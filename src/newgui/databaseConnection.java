/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hunter
 */
public class databaseConnection {
    
    
    public static Connection DbConnector(){
        try{
            Connection conn = null;
            Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection("JDBC:sqlite:/Users/Hunter/NetBeansProjects/NewGUI/studentUser.sqlite");
                    return conn;
                   
        }catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
                }
        return null;
    }
}
