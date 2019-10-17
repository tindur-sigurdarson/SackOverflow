package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Services.APIService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class APIServiceImplementation implements APIService {

    private OkHttpClient client = new OkHttpClient();


    @Override
    public String getAllTeams() throws IOException {
        String apiKey = "tehrjtr76vjg";
        String teamUrl = "https://www.fantasyfootballnerd.com/service/nfl-teams/json/" + apiKey + "/";
        Request request = new Request.Builder().url(teamUrl).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
