package is.hi.hpv501.sack.SackOverflow.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    private String fullName;
    private String shortName;

    public Team(){
    }

    public Team(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public long getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
