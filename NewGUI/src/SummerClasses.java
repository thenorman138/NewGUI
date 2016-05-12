/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hunter
 */
 class SummerClasses {
    
    private int CourseID;
    private String dept;
    private String title;
    private int number;
    private String day;
    private int time;
    
    public SummerClasses(){
        this.CourseID = 0;
        this.dept = "";
        this.title = "";
        this.number = 0;
        this.day = "";
        this.time = 0;
    }
    
    public SummerClasses (int ID, String dept, String title, int number, String day, int time ){
        this.CourseID = CourseID;
        this.dept = dept;
        this.title = title;
        this.number = number;
        this.day = day;
        this.time = time;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
}