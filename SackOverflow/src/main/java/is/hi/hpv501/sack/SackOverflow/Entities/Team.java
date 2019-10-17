package is.hi.hpv501.sack.SackOverflow.Entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private Double rating;

    @ElementCollection(targetClass=Division.class)
    @Column(name="division",nullable = false)
    @CollectionTable(name="team_division", joinColumns = {@JoinColumn(name="team_id")})
    public Set<Division> divisions;



    public Team(){
    }

    public Team(String name, String description, Double rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
