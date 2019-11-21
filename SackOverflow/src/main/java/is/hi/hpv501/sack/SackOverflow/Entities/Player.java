
package is.hi.hpv501.sack.SackOverflow.Entities;



import javax.persistence.*;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int playerID;
    private String firstName;
    private String lastName;
    private int jersey;
    private String position;

    private String team;

    private int gamesPlayed;
    private int passAttempts;
    private int passCompletion;
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
    private int recTD;
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


    public Player(int playerID, String firstName, String lastName, int jersey, String position,
                  String team, int gamesPlayed, int passAttempts, int passCompletion, double passPct,
                  int passYards, int passTD, int passInt, int rushAttempts, int rushYards, double rushAvg,
                  int rushTD, int targets, int receptions, int recYards, int recTD, int tackleTotal,
                  double sacks, int safeties, int interceptions, int intTD, int fumbles, int fumForced,
                  int fgMade, int fgAtt, double fgPct, int fgLng, int xpMade, int xpAtt, double xpPct) {

        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jersey = jersey;
        this.position = position;
        this.team = team;
        this.gamesPlayed = gamesPlayed;
        this.passAttempts = passAttempts;
        this.passCompletion = passCompletion;
        this.passPct = passPct;
        this.passYards = passYards;
        this.passTD = passTD;
        this.passInt = passInt;
        this.rushAttempts = rushAttempts;
        this.rushYards = rushYards;
        this.rushAvg = rushAvg;
        this.rushTD = rushTD;
        this.targets = targets;
        this.receptions = receptions;
        this.recYards = recYards;
        this.recTD = recTD;
        this.tackleTotal = tackleTotal;
        this.sacks = sacks;
        this.safeties = safeties;
        this.interceptions = interceptions;
        this.intTD = intTD;
        this.fumbles = fumbles;
        this.fumForced = fumForced;
        this.fgMade = fgMade;
        this.fgAtt = fgAtt;
        this.fgPct = fgPct;
        this.fgLng = fgLng;
        this.xpMade = xpMade;
        this.xpAtt = xpAtt;
        this.xpPct = xpPct;
    }




    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
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

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
        this.jersey = jersey;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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

    public int getPassCompletion() {
        return passCompletion;
    }

    public void setPassCompletion(int passCompletion) {
        this.passCompletion = passCompletion;
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

    public int getRecTD() {
        return recTD;
    }

    public void setRecTD(int recTD) {
        this.recTD = recTD;
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

    @Override
    public String toString() {
      /*
        if(position.equals("QB")){
          return  "Player{" +
                    "playerID=" + playerID +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", jersey=" + jersey +
                    ", position='" + position + '\'' +
                    ", team='" + team + '\'' +
                    ", gamesPlayed=" + gamesPlayed +
                    ", passAttempts=" + passAttempts +
                    ", passCompletion=" + passCompletion +
                    ", passPct=" + passPct +
                    ", passYards=" + passYards +
                    ", passTD=" + passTD +
                    ", passInt=" + passInt +
                    ", rushAttempts=" + rushAttempts +
                    ", rushYards=" + rushYards +
                    ", rushAvg=" + rushAvg +
                    ", rushTD=" + rushTD +
                    ", fumbles=" + fumbles+
                  '}';
        }
        if(position.equals("RB")){
            return "Player{" +
                "playerID=" + playerID +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", jersey=" + jersey +
                        ", position='" + position + '\'' +
                        ", team='" + team + '\'' +
                        ", gamesPlayed=" + gamesPlayed +
                        ", rushAttempts=" + rushAttempts +
                        ", rushYards=" + rushYards +
                        ", rushAvg=" + rushAvg +
                        ", rushTD=" + rushTD +
                        ", receptions=" + receptions +
                        ", recYards=" + recYards +
                        ", recTD=" + recTD +
                        ", fumbles=" + fumbles+
                    '}';
            }
        if(position.equals("WR") || position.equals("TE")){
            return  "Player{" +
                    "playerID=" + playerID +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", jersey=" + jersey +
                    ", position='" + position + '\'' +
                    ", team='" + team + '\'' +
                    ", gamesPlayed=" + gamesPlayed +
                    ", targets=" + targets +
                    ", receptions=" + receptions +
                    ", recYards=" + recYards +
                    ", recTD=" + recTD +
                    ", fumbles=" + fumbles+
                    '}';
        }

        if(position.equals("DB")||position.equals("LB")||position.equals("CB")
                ||position.equals("SS")||position.equals("DT")||
                position.equals("DE")||position.equals("ILB")
                ||position.equals("OLB")||position.equals("MLB")|| position.equals("FS")){
            return  "Player{" +
                    "playerID=" + playerID +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", jersey=" + jersey +
                    ", position='" + position + '\'' +
                    ", team='" + team + '\'' +
                    ", tackleTotal=" + tackleTotal +
                    ", sacks=" + sacks +
                    ", safeties=" + safeties +
                    ", interceptions=" + interceptions +
                    ", intTD=" + intTD +
                    ", fumForced=" + fumForced +
                    '}';

        }
        if(position.equals("K")){
            return "Player{" +
                    "playerID=" + playerID +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", jersey=" + jersey +
                    ", position='" + position + '\'' +
                    ", team='" + team + '\'' +
                    ", gamesPlayed=" + gamesPlayed +
                    ", fgMade=" + fgMade +
                    ", fgAtt=" + fgAtt +
                    ", fgPct=" + fgPct +
                    ", fgLng=" + fgLng +
                    ", xpMade=" + xpMade +
                    ", xpAtt=" + xpAtt +
                    ", xpPct=" + xpPct +
                    '}';
        }
        if (position.equals("OT")||position.equals("G")||position.equals("C")||position.equals("P")){
            return "Player{" +
                    "playerID=" + playerID +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", jersey=" + jersey +
                    ", position='" + position + '\'' +
                    ", team='" + team + '\'' +
                    ", gamesPlayed=" + gamesPlayed+
                    '}';
        }
        return "Player{" +
                "playerID=" + playerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jersey=" + jersey +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", passAttempts=" + passAttempts +
                ", passCompletion=" + passCompletion +
                ", passPct=" + passPct +
                ", passYards=" + passYards +
                ", passTD=" + passTD +
                ", passInt=" + passInt +
                ", rushAttempts=" + rushAttempts +
                ", rushYards=" + rushYards +
                ", rushAvg=" + rushAvg +
                ", rushTD=" + rushTD +
                ", targets=" + targets +
                ", receptions=" + receptions +
                ", recYards=" + recYards +
                ", recTD=" + recTD +
                ", tackleTotal=" + tackleTotal +
                ", sacks=" + sacks +
                ", safeties=" + safeties +
                ", interceptions=" + interceptions +
                ", intTD=" + intTD +
                ", fumbles=" + fumbles +
                ", fumForced=" + fumForced +
                ", fgMade=" + fgMade +
                ", fgAtt=" + fgAtt +
                ", fgPct=" + fgPct +
                ", fgLng=" + fgLng +
                ", xpMade=" + xpMade +
                ", xpAtt=" + xpAtt +
                ", xpPct=" + xpPct +
                '}';

       */
      return this.lastName;
    }
}