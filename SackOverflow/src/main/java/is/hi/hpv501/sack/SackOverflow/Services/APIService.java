package is.hi.hpv501.sack.SackOverflow.Services;

import java.io.IOException;

public interface APIService {
    String getAllTeams() throws  IOException;
    
    String getAllPlayers() throws  IOException;
    
    String getGamesByWeek(String date, String away, String home, int nr) throws  IOException;
    
    String getGamePlayByPlay(String date, String away, String home, int nr) throws  IOException;
    
    String getPlayerStats(String playerName) throws  IOException;
        
    String getPlayerStats(String playerName) throws  IOException;
    
    String getTeamStats(String teamName) throws  IOException;
    
    String getLatestUpdates() throws IOException;
    
    String getAllInjuredPlayers() throws IOException;
    
    String getInjuredPlayersByTeam(String teamName) throws IOException;
}




