package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Services.APIService;
import okhttp3.*;

import java.io.IOException;

public class APIServiceImplementation implements APIService {

    private String linkur = "https://www.fantasyfootballnerd.com/service/";
    private String apiKey = "tehrjtr76vjg";

    public APIServiceImplementation() {
    }

    @Override
    public String getAllPlayers() throws IOException {
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
