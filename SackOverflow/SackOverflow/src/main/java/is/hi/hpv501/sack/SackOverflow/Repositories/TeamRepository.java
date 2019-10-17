package is.hi.hpv501.sack.SackOverflow.Repositories;


import is.hi.hpv501.sack.SackOverflow.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TeamRepository extends JpaRepository<Team,Long> {

    /*
    Prufu interface
     */

    Team save(Team team);
    void delete(Team team);
    List<Team> findAll();
    List<Team> findByName(String name);
    Optional<Team> findById(long id);
    //@Query("SELECT")
}
