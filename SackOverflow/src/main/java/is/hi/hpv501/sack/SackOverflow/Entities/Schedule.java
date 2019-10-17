package is.hi.hpv501.sack.SackOverflow.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long gameId;
    private long gameWeek;
    private String gameDate;
    private String awayTeam;
    private String homeTeam;
    private String gameTimeET;

    public Schedule(){
    }

    public Schedule(String gameDate, String awayTeam, String homeTeam, String gameTimeET) {
        this.gameDate = gameDate;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.gameTimeET = gameTimeET;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGameTimeET() {
        return gameTimeET;
    }

    public void setGameTimeET(String gameTimeET) {
        this.gameTimeET = gameTimeET;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getGameWeek() {
        return gameWeek;
    }

    public void setGameWeek(long gameWeek) {
        this.gameWeek = gameWeek;
    }
}
