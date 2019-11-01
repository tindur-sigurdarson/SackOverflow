package is.hi.hpv501.sack.SackOverflow.Entities;

public class Teams {
    private String code;
    private String fullName;
    private String city;

    public Teams(){ }
    public Teams(String code, String fullName, String city) {
        this.code = code;
        this.fullName = fullName;
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  code + ", "+ fullName+ ", " + city;
    }

}
