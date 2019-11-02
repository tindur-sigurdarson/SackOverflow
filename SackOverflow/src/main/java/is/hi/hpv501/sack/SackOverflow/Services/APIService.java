package is.hi.hpv501.sack.SackOverflow.Services;

import is.hi.hpv501.sack.SackOverflow.Entities.Teams;

import java.io.IOException;
import java.util.List;

public interface APIService {
    List<Teams> getAllTeams() throws  IOException;

    String getAllPlayers() throws IOException;

    String getGamesByWeek(int weekNr) throws IOException;

    String getGameScoreByDay(String date, String away, String home, int nr) throws IOException;

    String getGamePlayByPlay(String date, String away, String home, int nr) throws IOException;

    String getPlayerStats(String playerName) throws IOException;

    String getTeamStats(String teamName) throws IOException;

    String getLatestUpdates() throws IOException;

    String getAllInjuredPlayers() throws IOException;

    String getInjuredPlayersByTeam(String teamName) throws IOException;

}




