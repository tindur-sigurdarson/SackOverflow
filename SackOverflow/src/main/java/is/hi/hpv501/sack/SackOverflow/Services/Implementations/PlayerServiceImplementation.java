package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Entities.Player;
import is.hi.hpv501.sack.SackOverflow.Repositories.PlayerRepository;
import is.hi.hpv501.sack.SackOverflow.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlayerServiceImplementation implements PlayerService {
    PlayerRepository repository;

    @Autowired
    public PlayerServiceImplementation(PlayerRepository playerRepository) {
        this.repository = playerRepository;
    }
    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Player> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Player> findByName(String name) {
        return repository.findByName(name);
    }
}

