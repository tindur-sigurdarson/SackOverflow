package is.hi.hpv501.sack.SackOverflow.Entities;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String uName;
    private String password;
    private String favTeam;

    public User(){
    }
    public User(String uName, String password, String favTeam){
        this.uName = uName;
        this.password = password;
        this.favTeam = favTeam;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavTeam() {
        return favTeam;
    }

    public void setFavTeam(String favTeam) {
        this.favTeam = favTeam;
    }

    @Override
    public String toString() {
        return this.uName;
    }
}
