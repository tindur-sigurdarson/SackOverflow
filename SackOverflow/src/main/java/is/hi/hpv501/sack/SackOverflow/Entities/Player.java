
package is.hi.hpv501.sack.SackOverflow.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String position;
    private int jerseyNumber;
    private Team team;
    private boolean injury;
    private int age;
    private int gamesPlayed;
    private int passAttempts;
    private int passCompletions;
    private double passPct;
    private int passYards;
    private int passTD;
    private int passInt;
    private int rushAttempts;
    private int rushYards;
    private double rushAvg;
    private int rushTD;
    private int targets;
    private int receptions;
    private int recYards;
    private int tackleTotal;
    private double sacks;
    private int safeties;
    private int interceptions;
    private int intTD;
    private int fumbles;
    private int fumForced;
    private int fgMade;
    private int fgAtt;
    private double fgPct;
    private int fgLng;
    private int xpMade;
    private int xpAtt;
    private double xpPct;


    public Player(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public boolean isInjury() {
        return injury;
    }

    public void setInjury(boolean injury) {
        this.injury = injury;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getPassAttempts() {
        return passAttempts;
    }

    public void setPassAttempts(int passAttempts) {
        this.passAttempts = passAttempts;
    }

    public int getPassCompletions() {
        return passCompletions;
    }

    public void setPassCompletions(int passCompletions) {
        this.passCompletions = passCompletions;
    }

    public double getPassPct() {
        return passPct;
    }

    public void setPassPct(double passPct) {
        this.passPct = passPct;
    }

    public int getPassYards() {
        return passYards;
    }

    public void setPassYards(int passYards) {
        this.passYards = passYards;
    }

    public int getPassTD() {
        return passTD;
    }

    public void setPassTD(int passTD) {
        this.passTD = passTD;
    }

    public int getPassInt() {
        return passInt;
    }

    public void setPassInt(int passInt) {
        this.passInt = passInt;
    }

    public int getRushAttempts() {
        return rushAttempts;
    }

    public void setRushAttempts(int rushAttempts) {
        this.rushAttempts = rushAttempts;
    }

    public int getRushYards() {
        return rushYards;
    }

    public void setRushYards(int rushYards) {
        this.rushYards = rushYards;
    }

    public double getRushAvg() {
        return rushAvg;
    }

    public void setRushAvg(double rushAvg) {
        this.rushAvg = rushAvg;
    }

    public int getRushTD() {
        return rushTD;
    }

    public void setRushTD(int rushTD) {
        this.rushTD = rushTD;
    }

    public int getTargets() {
        return targets;
    }

    public void setTargets(int targets) {
        this.targets = targets;
    }

    public int getReceptions() {
        return receptions;
    }

    public void setReceptions(int receptions) {
        this.receptions = receptions;
    }

    public int getRecYards() {
        return recYards;
    }

    public void setRecYards(int recYards) {
        this.recYards = recYards;
    }

    public int getTackleTotal() {
        return tackleTotal;
    }

    public void setTackleTotal(int tackleTotal) {
        this.tackleTotal = tackleTotal;
    }

    public double getSacks() {
        return sacks;
    }

    public void setSacks(double sacks) {
        this.sacks = sacks;
    }

    public int getSafeties() {
        return safeties;
    }

    public void setSafeties(int safeties) {
        this.safeties = safeties;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public int getIntTD() {
        return intTD;
    }

    public void setIntTD(int intTD) {
        this.intTD = intTD;
    }

    public int getFumbles() {
        return fumbles;
    }

    public void setFumbles(int fumbles) {
        this.fumbles = fumbles;
    }

    public int getFumForced() {
        return fumForced;
    }

    public void setFumForced(int fumForced) {
        this.fumForced = fumForced;
    }

    public int getFgMade() {
        return fgMade;
    }

    public void setFgMade(int fgMade) {
        this.fgMade = fgMade;
    }

    public int getFgAtt() {
        return fgAtt;
    }

    public void setFgAtt(int fgAtt) {
        this.fgAtt = fgAtt;
    }

    public double getFgPct() {
        return fgPct;
    }

    public void setFgPct(double fgPct) {
        this.fgPct = fgPct;
    }

    public int getFgLng() {
        return fgLng;
    }

    public void setFgLng(int fgLng) {
        this.fgLng = fgLng;
    }

    public int getXpMade() {
        return xpMade;
    }

    public void setXpMade(int xpMade) {
        this.xpMade = xpMade;
    }

    public int getXpAtt() {
        return xpAtt;
    }

    public void setXpAtt(int xpAtt) {
        this.xpAtt = xpAtt;
    }

    public double getXpPct() {
        return xpPct;
    }

    public void setXpPct(double xpPct) {
        this.xpPct = xpPct;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}