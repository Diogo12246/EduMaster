package Model;

public class Discipline {
    private int id;
    private String disciplineName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Discipline(int id, String disciplineName) {
        this.id = id;
        this.disciplineName = disciplineName;
    }

    public Discipline() {
    }

    @Override
    public String toString() {
        return disciplineName + "(" + + getId() + ")";
    }
}

/*
    THIS IS THE OBJECT ON ITS PUREST FORM
    CONTAINS ALL GETTERS AND SETTERS AND THE CONSTRUCTORS
    NEEDED FOR THE OBJECT TO BE USED IN THE PROGRAM
 */