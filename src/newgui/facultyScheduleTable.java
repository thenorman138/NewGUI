/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Hunter
 */
public class facultyScheduleTable {

   
    
    private SimpleStringProperty CRN;
    private SimpleStringProperty Dept;
    private SimpleStringProperty Num;
    private SimpleStringProperty Title;
    private SimpleStringProperty Day;
    private SimpleStringProperty Time;
    private SimpleStringProperty Credits;
    
    public facultyScheduleTable(){
        
    }
    
    public facultyScheduleTable(String sCRN, String sDept, String sNum, String sTitle, String sDay, String sTime, String sCredits){
            this.CRN = new SimpleStringProperty (sCRN);
            this.Dept = new SimpleStringProperty (sDept);
            this.Num = new SimpleStringProperty (sNum);
            this.Title = new SimpleStringProperty (sTitle);
            this.Day = new SimpleStringProperty (sDay);
            this.Time = new SimpleStringProperty (sTime);
            this.Credits = new SimpleStringProperty (sCredits);
            
            
        }
    
        public String getCRN (){
            return CRN.get();
    }
        
        public void setCRN(String v){
            CRN.set(v);
    }
        
        public String getDept (){
            return Dept.get();
    }
        
        public void setDept (String v){
            Dept.set(v);
    }
        public String getNum (){
            return Num.get();
    }
        
        public void setNum(String v){
            Num.set(v);
    }
        
        public String getTitle (){
            return Title.get();
    }
        
        public void setTitle(String v){
            Title.set(v);
    }
        public String getDay (){
            return Day.get();
    }
        
        public void setDay(String v){
            Day.set(v);
    }
        public String getTime (){
            return Time.get();
    }
        
        public void setTime(String v){
            Time.set(v);
    }
         public String getCredits (){
            return Credits.get();
    }
        
        public void setCredits(String v){
            Credits.set(v);
    }
        
       
    
    
}
