package model;

public class StudentData {
	
	//create private fields for student's login information
    public String studentNumber;
    public String password;

    
    //getters and setters 
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
