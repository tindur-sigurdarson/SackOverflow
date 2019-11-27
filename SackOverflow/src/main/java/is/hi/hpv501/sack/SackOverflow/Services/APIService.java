package is.hi.hpv501.sack.SackOverflow.Services;

import is.hi.hpv501.sack.SackOverflow.Entities.Game;
import is.hi.hpv501.sack.SackOverflow.Entities.Player;
import is.hi.hpv501.sack.SackOverflow.Entities.Teams;

import java.io.IOException;
import java.util.List;

public interface APIService {
    List<Teams> getAllTeams() throws  IOException;

    List<Player> getAllPlayers() throws IOException;

    List<Game> getAllGames() throws  IOException;

    List<Player> getImage() throws IOException;
}




