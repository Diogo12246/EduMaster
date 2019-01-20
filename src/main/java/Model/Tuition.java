package Model;

public class Tuition {
    private int id;
    private String tuitionCode;
    private int tuitionValue;
    private boolean tuitionPaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTuitionCode() {
        return tuitionCode;
    }

    public void setTuitionCode(String tuitionCode) {
        this.tuitionCode = tuitionCode;
    }

    public int getTuitionValue() {
        return tuitionValue;
    }

    public void setTuitionValue(int tuitionValue) {
        this.tuitionValue = tuitionValue;
    }

    public boolean isTuitionPaid() {
        return tuitionPaid;
    }

    public void setTuitionPaid(boolean tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
    }

    public Tuition(int id, String tuitionCode, int tuitionValue, boolean tuitionPaid) {
        this.id = id;
        this.tuitionCode = tuitionCode;
        this.tuitionValue = tuitionValue;
        this.tuitionPaid = tuitionPaid;
    }

    public Tuition() {
    }
}
