package Model;

public class Institution {
    private int id;
    private String institutionName;
    private String institutionStamp;
    private String institutionCity;
    private int institutionSales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionStamp() {
        return institutionStamp;
    }

    public void setInstitutionStamp(String institutionStamp) {
        this.institutionStamp = institutionStamp;
    }

    public String getInstitutionCity() {
        return institutionCity;
    }

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    public int getInstitutionSales() {
        return institutionSales;
    }

    public void setInstitutionSales(int institutionSales) {
        this.institutionSales = institutionSales;
    }

    public Institution(int id, String institutionName, String institutionStamp, String institutionCity, int institutionSales) {
        this.id = id;
        this.institutionName = institutionName;
        this.institutionStamp = institutionStamp;
        this.institutionCity = institutionCity;
        this.institutionSales = institutionSales;
    }

    public Institution() {

    }
}
