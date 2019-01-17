package Model;

public class Student {
    private int id;
    private String studentFName;
    private String studentLName;
    private String studentEmail;
    private int tuition_id;

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

    public int getTuition_id() {
        return tuition_id;
    }

    public void setTuition_id(int tuition_id) {
        this.tuition_id = tuition_id;
    }

    public Student(int id, String studentFName, String studentLName, String studentEmail, int tuition_id) {
        this.id = id;
        this.studentFName = studentFName;
        this.studentLName = studentLName;
        this.studentEmail = studentEmail;
        this.tuition_id = tuition_id;
    }

    public Student() {
    }
}
