package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Entities.Player;
import is.hi.hpv501.sack.SackOverflow.Repositories.PlayerRepository;
import is.hi.hpv501.sack.SackOverflow.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImplementation implements PlayerService {
    PlayerRepository repository;

    @Autowired
    public PlayerServiceImplementation(PlayerRepository playerRepository) {
        this.repository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return repository.save(player);
    }

    @Override
    public void delete(Player player) {
        repository.delete(player);
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Player> findById(long id) {
        return repository.findById(id);
    }



    @Override
    public List<Player> findByFirstName(String name) {
        return repository.findByFirstName(name);
    }

    @Override
    public List<Player> findByLastName(String name) {
        return repository.findByLastName(name);
    }
}

