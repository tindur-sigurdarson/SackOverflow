package is.hi.hpv501.sack.SackOverflow.Services;

import is.hi.hpv501.sack.SackOverflow.Entities.Player;


import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Player save(Player player);
    void delete(Player player);
    List<Player> findAll();
    List<Player> findByName(String name);
    Optional<Player> findById(long id);

}
