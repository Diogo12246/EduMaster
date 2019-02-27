package pt.diogo12246.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
    private String studentFName;
    private String studentLName;
    private String studentEmail;
    private String tuitionCode;

    public Student(String email, String tCode) {
        this.studentEmail = email;
        this.tuitionCode = tCode;
    }

    public Student(String FirstName,String LastName,String email) {
        this.studentFName = FirstName;
        this.studentLName = LastName;
        this.studentEmail = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentFName() {
        return studentFName;
    }

    public void setStudentFName(String studentFName) {
        this.studentFName = studentFName;
    }

    public String getStudentLName() {
        return studentLName;
    }

    public void setStudentLName(String studentLName) {
        this.studentLName = studentLName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getTuitionCode() {
        return tuitionCode;
    }

    public void setTuitionCode(String tuitionCode) {
        this.tuitionCode = tuitionCode;
    }

    public Student(int id, String studentFName, String studentLName, String studentEmail, String tuitionCode) {
        this.id = id;
        this.studentFName = studentFName;
        this.studentLName = studentLName;
        this.studentEmail = studentEmail;
        this.tuitionCode = tuitionCode;
    }

    public Student(String id, String firstName, String lastName, String email) {
        this.tuitionCode = id;
        this.studentFName = firstName;
        this.studentLName = lastName;
        this.studentEmail = email;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return studentFName + " " + studentLName + " - " + studentEmail + "(" + + getId() + ")";
    }
}


/*
    THIS IS THE OBJECT ON ITS PUREST FORM
    CONTAINS ALL GETTERS AND SETTERS AND THE CONSTRUCTORS
    NEEDED FOR THE OBJECT TO BE USED IN THE PROGRAM
 */