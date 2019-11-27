package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
import is.hi.hpv501.sack.SackOverflow.Repositories.TeamRepository;
import is.hi.hpv501.sack.SackOverflow.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImplementation implements TeamService {
    TeamRepository repository;

    @Autowired
    public TeamServiceImplementation(TeamRepository teamRepository) {
        this.repository = teamRepository;
    }

    @Override
    public Teams save(Teams team) {
        return repository.save(team);
    }

    @Override
    public void delete(Teams team) {
        repository.delete(team);
    }

    @Override
    public List<Teams> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Teams> findById(long id) {
        return repository.findById(id);
    }


}