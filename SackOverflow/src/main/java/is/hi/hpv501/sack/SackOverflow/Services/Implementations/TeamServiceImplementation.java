package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Entities.Team;
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
    public Team save(Team team) {
        return repository.save(team);
    }

    @Override
    public void delete(Team team) {
        repository.delete(team);
    }

    @Override
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Team> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Team> findByName(String name) {

        return null;
    }
}