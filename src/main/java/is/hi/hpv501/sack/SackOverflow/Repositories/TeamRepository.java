package is.hi.hpv501.sack.SackOverflow.Repositories;


import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TeamRepository extends JpaRepository<Teams,Long> {

    /*
    Prufu interface
     */

    Teams save(Teams team);
    void delete(Teams team);
    List<Teams> findAll();
    List<Teams> findByName(String name);
    Optional<Teams> findById(long id);
    List<Teams> findTeamsByDeildAndRank(String deild,int rank);

}
