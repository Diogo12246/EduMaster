package Model;

public class Student {
    private int id;
    private String studentFName;
    private String studentLName;
    private int studentCode;
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

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public int getTuition_id() {
        return tuition_id;
    }

    public void setTuition_id(int tuition_id) {
        this.tuition_id = tuition_id;
    }
}
