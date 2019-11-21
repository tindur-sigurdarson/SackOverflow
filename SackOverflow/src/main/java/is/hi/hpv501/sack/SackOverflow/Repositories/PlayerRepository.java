package is.hi.hpv501.sack.SackOverflow.Repositories;

import is.hi.hpv501.sack.SackOverflow.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player save(Player player);
    void delete (Player player);
    List<Player> findAll();
    List<Player> findByFirstName(String name);
    Optional<Player> findById(long id);
}
