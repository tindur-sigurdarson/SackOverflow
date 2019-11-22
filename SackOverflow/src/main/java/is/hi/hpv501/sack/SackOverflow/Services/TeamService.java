package is.hi.hpv501.sack.SackOverflow.Services;

import is.hi.hpv501.sack.SackOverflow.Entities.Teams;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Teams save(Teams teams);
    void delete(Teams teams);
    List<Teams> findAll();
    List <Teams> findByName(String name);
    Optional<Teams> findById(long id);
    List<Teams> findTeamsByDeildAndRank(String deild,int rank);

}
