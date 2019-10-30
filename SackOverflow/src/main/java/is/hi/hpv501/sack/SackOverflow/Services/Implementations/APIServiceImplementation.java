package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Services.APIService;
import okhttp3.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class APIServiceImplementation implements APIService {

    private String linkur = "";
    private String apiKey = "35c57403-430a-49e1-bca6-c14fa2";

    public APIServiceImplementation() {
    }
/*
    @Override
    public String getAllPlayers() throws IOException {
        linkur="https://api.mysportsfeeds.com/v1.2/pull/nfl/2019-regular/cumulative_player_stats.json";
        String teamUrl = linkur+"players/json/"+apiKey;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(teamUrl)
                .build();
        try{
            Response response = client.newCall(request).execute();
            return response.body().string();

        }catch (IOException e){

            e.printStackTrace();
        }
        return "villa";
    }
*/

    @Override
    public String getAllPlayers() throws IOException {
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
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "Bla";
    }

    @Override
    public String getAllTeams() throws IOException {
        String teamUrl = linkur+"nfl-teams/json/"+apiKey;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(teamUrl)
                .build();
        try{
            Response response = client.newCall(request).execute();
            return response.body().string();

        }catch (IOException e){

            e.printStackTrace();
        }
        return "villa";
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
