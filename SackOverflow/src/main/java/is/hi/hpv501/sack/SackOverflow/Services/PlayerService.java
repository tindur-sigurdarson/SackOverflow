package is.hi.hpv501.sack.SackOverflow.Services;

import is.hi.hpv501.sack.SackOverflow.Entities.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<Player> findAll();
    Optional<Player> findById(long id);
    List<Player> findByName(String name);
}
