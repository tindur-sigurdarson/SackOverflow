package is.hi.hpv501.sack.SackOverflow.Entities;


import javax.persistence.*;
import java.util.Set;


@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String shortName;
    private String record;

    @ElementCollection(targetClass=Division.class)
    @Column(name="division",nullable = false)
    @CollectionTable(name="team_division", joinColumns = {@JoinColumn(name="team_id")})
    public Set<Division> divisions;




    public Team(){
    }


    public Team(String name, String shortName, String record) {
        this.name = name;
        this.shortName = shortName;
        this.record = record;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getRecord() {
        return record;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
