package is.hi.hpv501.sack.SackOverflow.Services;

import is.hi.hpv501.sack.SackOverflow.Entities.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Team save(Team team);
    void delete(Team team);
    List<Team> findAll();
    Optional<Team> findById(long id);
    List<Team> findByName(String name);


}
