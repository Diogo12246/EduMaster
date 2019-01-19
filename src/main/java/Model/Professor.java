package Model;

public class Professor {
    private int id;
    private String ProfessorFName;
    private String ProfessorLName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessorFName() {
        return ProfessorFName;
    }

    public void setProfessorFName(String professorFName) {
        ProfessorFName = professorFName;
    }

    public String getProfessorLName() {
        return ProfessorLName;
    }

    public void setProfessorLName(String professorLName) {
        ProfessorLName = professorLName;
    }

    public Professor(int id, String professorFName, String professorLName) {
        this.id = id;
        ProfessorFName = professorFName;
        ProfessorLName = professorLName;
    }


    public Professor() {
    }

    @Override
    public String toString() {
        return getProfessorFName() + " " + getProfessorLName();
    }
}
