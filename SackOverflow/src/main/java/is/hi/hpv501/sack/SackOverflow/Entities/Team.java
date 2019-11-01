package is.hi.hpv501.sack.SackOverflow.Entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Team {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private String name;
    private String description;
    private String rating;


    public Team(){
    }

    public Team( String name, String description, String rating) {

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Team{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

}
