package is.hi.hpv501.sack.SackOverflow.Repositories;

import is.hi.hpv501.sack.SackOverflow.Entities.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    List<Player> findAll();
    List<Player> findByName(String name);
    Optional<Player> findById(long id);
}
