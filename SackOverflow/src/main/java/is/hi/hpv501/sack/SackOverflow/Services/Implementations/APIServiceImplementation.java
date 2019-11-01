package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Services.APIService;
import okhttp3.*;

import java.io.IOException;

public class APIServiceImplementation implements APIService {

    public APIServiceImplementation() {
    }

    @Override
    public String getAllTeams() throws IOException {
       // String apiKey = "tehrjtr76vjg";
        String teamUrl = "https://www.fantasyfootballnerd.com/service/nfl-teams/json/tehrjtr76vjg/";
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
     /*   Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                try {
                    throw new IOException(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resp = response.body().string();
                if(response.isSuccessful()){

                }
            }
        }); */
    }

  /*  @Override
    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }

   */

}
