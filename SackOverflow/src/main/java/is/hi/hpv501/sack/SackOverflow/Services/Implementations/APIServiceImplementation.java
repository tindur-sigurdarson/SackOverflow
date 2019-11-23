package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import com.fasterxml.jackson.databind.JsonNode;
import is.hi.hpv501.sack.SackOverflow.Entities.Game;
import is.hi.hpv501.sack.SackOverflow.Entities.Player;
import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
import is.hi.hpv501.sack.SackOverflow.Services.APIService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class APIServiceImplementation implements APIService {

    private String linkur = "";
    private String apiKey = "35c57403-430a-49e1-bca6-c14fa2";


    public APIServiceImplementation() {
    }
    @Override
    public List<Player> getImage(){
        try {
            String token = apiKey + ":3DUbP77j";
            byte[] src = token.getBytes();
            URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nfl/2019-regular/active_players.json");
            String encoding = Base64.getUrlEncoder().encodeToString(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream) connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            //Listi búinn til fyrir lið
            List<Player> listi = new ArrayList<>();
            String line;
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                JSONObject o = new JSONObject(line);
                JSONObject obj = o.getJSONObject("activeplayers");
                JSONArray arr = obj.getJSONArray("playerentry");
                for(int i=0; i<arr.length();i++){
                    Player pl = new Player();
                    JSONObject c = (JSONObject) arr.get(i);

                    JSONObject player = c.getJSONObject("player");
                    pl.setPlayerID(player.getInt("ID"));

                    String m = player.getString("officialImageSrc");
                    pl.setMynd(m);

                    listi.add(pl);

                }
               return listi;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Player> getAllPlayers() throws IOException {
        try {
            String token = apiKey+":3DUbP77j";
            byte[] src = token.getBytes();
            URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nfl/latest/cumulative_player_stats.json");
            String encoding = Base64.getUrlEncoder().encodeToString(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            String line;
            List<Player> myndalisti = getImage();
            List<Player> leikmannalisti = new ArrayList<Player>();
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                JSONObject obj = new JSONObject(line);
                JSONObject obj2 = obj.getJSONObject("cumulativeplayerstats");
                JSONArray jsonArr = obj2.getJSONArray("playerstatsentry");
                //Listi búinn til fyrir leikmenn

                for (int i = 0; i < jsonArr.length(); i++) {
                    Player play = new Player();
                    JSONObject c = (JSONObject) jsonArr.get(i);
                    JSONObject leikmenn = c.getJSONObject("player");
                    int id = leikmenn.getInt("ID");
                    String lastName = leikmenn.getString("LastName");
                    String firstName = leikmenn.getString("FirstName");
                    String position = leikmenn.getString("Position");
                    try {
                        play.setJersey(leikmenn.getInt("JerseyNumber"));
                    } catch (JSONException e) {
                        play.setJersey(-1);
                    }
                    try {
                        JSONObject lid = c.getJSONObject("team");
                        play.setTeam(lid.getString("Name"));
                    } catch (JSONException e) {
                        String lid2 = "Free Agent";
                        play.setTeam(lid2);
                    }

                    JSONObject stats = c.getJSONObject("stats");
                    //Games Played
                    JSONObject gamesPl = stats.getJSONObject("GamesPlayed");
                    int gamesplayed = gamesPl.getInt("#text");

                    //Passing Stats
                    if (position.equals("QB")) {
                        JSONObject passAt = stats.getJSONObject("PassAttempts");
                        int passAttempts = passAt.getInt("#text");
                        play.setPassAttempts(passAttempts);
                    }
                    if (position.equals("QB")) {
                        try {
                            JSONObject passcomp = stats.getJSONObject("PassCompletions");
                            int passCompletion = passcomp.getInt("#text");
                            play.setPassCompletion(passCompletion);
                        } catch (JSONException e) {
                            int passCompletion = 0;
                            play.setPassCompletion(passCompletion);
                        }
                    }
                    if (position.equals("QB")) {
                        try {
                            JSONObject passprosenta = stats.getJSONObject("PassPct");
                            double passpct = passprosenta.getDouble("#text");
                            play.setPassPct(passpct);
                        } catch (JSONException e) {
                            double passpct = 0.0;
                            play.setPassPct(passpct);
                        }
                    }
                    if (position.equals("QB")) {
                        try {
                            JSONObject passyard = stats.getJSONObject("PassYards");
                            int passYards = passyard.getInt("#text");
                            play.setPassYards(passYards);
                        } catch (JSONException e) {
                            int passYards = 0;
                            play.setPassYards(passYards);
                        }
                    }
                    if (position.equals("QB")) {
                        JSONObject passtd = stats.getJSONObject("PassTD");
                        int passTD = passtd.getInt("#text");
                        play.setPassTD(passTD);

                        JSONObject passInt = stats.getJSONObject("PassInt");
                        int passInter = passInt.getInt("#text");
                        play.setPassInt(passInter);

                        try {
                            JSONObject fumbles = stats.getJSONObject("Fumbles");
                            int fum = fumbles.getInt("#text");
                            play.setFumbles(fum);
                        } catch (JSONException e) {
                            play.setFumbles(0);
                        }
                    }

                    //Rush Stats
                    if (position.equals("QB") || position.equals("RB")) {
                        JSONObject rushAt = stats.getJSONObject("RushAttempts");
                        int rushAttempts = rushAt.getInt("#text");
                        play.setRushAttempts(rushAttempts);
                    }
                    if (position.equals("QB") || position.equals("RB")) {
                        try {
                            JSONObject rushyard = stats.getJSONObject("RushYards");
                            int rushYards = rushyard.getInt("#text");
                            play.setRushYards(rushYards);
                        } catch (JSONException e) {
                            int rushYards = 0;
                            play.setRushYards(rushYards);
                        }
                    }
                    if (position.equals("QB") || position.equals("RB")) {
                        try {
                            JSONObject rushAVG = stats.getJSONObject("RushAverage");
                            double rushavg = rushAVG.getDouble("#text");
                            play.setRushAvg(rushavg);
                        } catch (JSONException e) {
                            double rushavg = 0.0;
                            play.setRushAvg(rushavg);
                        }
                    }
                    if (position.equals("QB") || position.equals("RB")) {
                        JSONObject rushtd = stats.getJSONObject("RushTD");
                        int rushTD = rushtd.getInt("#text");
                        play.setRushTD(rushTD);
                    }

                    //Targets and receptions
                    if (position.equals("WR") || position.equals("RB") || position.equals("TE")) {
                        JSONObject targets = stats.getJSONObject("Targets");
                        int trgts = targets.getInt("#text");
                        play.setTargets(trgts);
                        JSONObject rec = stats.getJSONObject("Receptions");
                        int recept = rec.getInt("#text");
                        play.setReceptions(recept);
                        try {
                            JSONObject recYard = stats.getJSONObject("RecYards");
                            int recYards = recYard.getInt("#text");
                            play.setRecYards(recYards);
                        } catch (JSONException e) {
                            play.setRecYards(0);
                        }
                        JSONObject rectd = stats.getJSONObject("RecTD");
                        int receptTd = rectd.getInt("#text");
                        play.setRecTD(receptTd);
                        try {
                            JSONObject fumbles = stats.getJSONObject("Fumbles");
                            play.setFumbles(fumbles.getInt("Text"));
                        } catch (JSONException e) {
                            play.setFumbles(0);
                        }

                    }
                    //varnar stats
                    if (position.equals("DB") || position.equals("LB") || position.equals("CB")
                            || position.equals("SS") || position.equals("DT") ||
                            position.equals("DE") || position.equals("ILB")
                            || position.equals("OLB") || position.equals("MLB")) {

                        JSONObject tackles = stats.getJSONObject("TackleTotal");
                        int tackl = tackles.getInt("#text");
                        play.setTackleTotal(tackl);

                        JSONObject inter = stats.getJSONObject("Interceptions");
                        int intercept = inter.getInt("#text");
                        play.setInterceptions(intercept);

                        JSONObject intertd = stats.getJSONObject("IntTD");
                        int intTD = intertd.getInt("#text");
                        play.setIntTD(intTD);

                        try {
                            JSONObject fumforc = stats.getJSONObject("FumForced");
                            play.setFumForced(fumforc.getInt("#text"));
                        } catch (JSONException e) {
                            play.setFumForced(0);
                        }

                        try {
                            JSONObject sacks = stats.getJSONObject("Sacks");
                            play.setSacks(sacks.getDouble("#text"));
                        } catch (JSONException e) {
                            play.setSacks(0);
                        }
                        try {
                            JSONObject saf = stats.getJSONObject("Safeties");
                            play.setSafeties(saf.getInt("#text"));
                        } catch (JSONException e) {
                            play.setSafeties(0);
                        }
                    }

                    //stats fyrir kicker ásamt því að bæta þeim í player
                    if (position.equals("K")) {
                        JSONObject fgM = stats.getJSONObject("FgMade");
                        play.setFgMade(fgM.getInt("#text"));

                        JSONObject fgAtt = stats.getJSONObject("FgAtt");
                        play.setFgAtt(fgAtt.getInt("#text"));

                        try {
                            JSONObject fgPct = stats.getJSONObject("FgPct");
                            play.setFgPct(fgPct.getDouble("#text"));
                        } catch (JSONException e) {
                            play.setFgPct(0.0);
                        }

                        JSONObject fgLng = stats.getJSONObject("FgLng");
                        play.setFgLng(fgLng.getInt("#text"));

                        JSONObject xpMade = stats.getJSONObject("XpMade");
                        play.setXpMade(xpMade.getInt("#text"));

                        JSONObject xpAtt = stats.getJSONObject("XpAtt");
                        play.setXpAtt(xpAtt.getInt("#text"));

                        JSONObject xpPct = stats.getJSONObject("XpPct");
                        play.setXpPct(xpPct.getDouble("#text"));
                    }

                    play.setPlayerID(id);
                    play.setLastName(lastName);
                    play.setFirstName(firstName);
                    play.setPosition(position);
                    play.setGamesPlayed(gamesplayed);
                    //try {
                        play.setMynd(myndalisti.get(i).getMynd());
                   // }catch (Exception e){

                    //}
                    //bæta leikmönnum í arraylist
                    /*List<Player> myndalisti = getImage();

                        Player lei = myndalisti.get(i);
                        play.setMynd(lei.getMynd());
                     */
                    leikmannalisti.add(play);
                }
                return leikmannalisti;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public List<Teams> getAllTeams() throws IOException {
        try {
            String token = apiKey+":3DUbP77j";
            byte[] src = token.getBytes();
            URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nfl/2019-regular/division_team_standings.json");
            String encoding = Base64.getUrlEncoder().encodeToString(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            //Listi búinn til fyrir lið
            List<Teams> listi = new ArrayList<Teams>();

            String line;
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                //  JSON obj búinn til
                JSONObject obj = new JSONObject(line);
                JSONObject obj2 = obj.getJSONObject("divisionteamstandings");
                // JSON array búið til
                JSONArray divi = obj2.getJSONArray("division");
                // sótt deildir
                for (int i =0; i<divi.length(); i++) {
                    JSONObject c = (JSONObject) divi.get(i);

                    JSONArray teamentry = c.getJSONArray("teamentry");
                    // sótt upplýsingar um lið
                    for (int j = 0; j < teamentry.length(); j++) {
                        //Nýtt lið búið til
                        Teams lidstats = new Teams();

                        JSONObject q = (JSONObject) teamentry.get(j);

                        JSONObject lid = q.getJSONObject("team");
                        String nafn = lid.getString("City");
                        nafn += " " + lid.getString("Name");
                        // upplýsingar settar í lið
                        lidstats.setDeild(c.getString("@name"));
                        lidstats.setId(lid.getInt("ID"));
                        lidstats.setName(nafn);
                        lidstats.setRank(q.getInt("rank"));
                        // Team record
                        JSONObject rec = q.getJSONObject("stats");
                        JSONObject W = rec.getJSONObject("Wins");
                        JSONObject L = rec.getJSONObject("Losses");
                        JSONObject T = rec.getJSONObject("Ties");
                        String win = W.getString("#text");
                        String loss = L.getString("#text");
                        String ties = T.getString("#text");
                        String record = win+"-"+loss+"-"+ties;
                        lidstats.setRecord(record);
                        // lið sett í lista
                        listi.add(lidstats);
                    }
                }
            }
            return listi;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public List<Game> getAllGames() throws IOException {
        try {
            String token = apiKey+":3DUbP77j";
            byte[] src = token.getBytes();
            URL url = new URL("https://api.mysportsfeeds.com/v1.2/pull/nfl/2019-regular/full_game_schedule.json");
            String encoding = Base64.getUrlEncoder().encodeToString(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            //Listi búinn til fyrir lið
            List<Game> listi = new ArrayList<Game>();

            String line;
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                JSONObject obj = new JSONObject(line);
                JSONObject obj2 = obj.getJSONObject("fullgameschedule");
                JSONArray jsonArray = obj2.getJSONArray("gameentry");
                for(int i =0; i<jsonArray.length();i++) {
                    Game leikir = new Game();
                    JSONObject c = (JSONObject) jsonArray.get(i);
                    leikir.setId(c.getInt("id"));
                    leikir.setDate(c.getString("date"));
                    leikir.setTime(c.getString("time"));
                    leikir.setWeek(c.getInt("week"));
                    leikir.setLocation(c.getString("location"));
                    JSONObject home = c.getJSONObject("homeTeam");
                    leikir.setHomeTeam(home.getString("City") + " " + home.getString("Name"));

                    JSONObject away = c.getJSONObject("awayTeam");
                    leikir.setAwayTeam(away.getString("City") + " " + away.getString("Name"));
                    listi.add(leikir);
                }

            }
            return listi;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String getGamesByWeek(int weekNr) throws IOException {
        return null;
    }

    @Override
    public String getGameScoreByDay(String date, String away, String home, int nr) throws IOException {
        return null;
    }

    @Override
    public String getGamePlayByPlay(String date, String away, String home, int nr) throws IOException {
        return null;
    }

    @Override
    public String getPlayerStats(String playerName) throws IOException {
        return null;
    }

    @Override
    public String getTeamStats(String teamName) throws IOException {
        return null;
    }

    @Override
    public String getLatestUpdates() throws IOException {
        return null;
    }

    @Override
    public String getAllInjuredPlayers() throws IOException {
        return null;
    }

    @Override
    public String getInjuredPlayersByTeam(String teamName) throws IOException {
        return null;
    }

}