package is.hi.hpv501.sack.SackOverflow.Controllers;

        import com.fasterxml.jackson.core.JsonGenerationException;
        import com.fasterxml.jackson.databind.JsonMappingException;
        import com.fasterxml.jackson.databind.JsonNode;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import is.hi.hpv501.sack.SackOverflow.Entities.Team;
        import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
        import is.hi.hpv501.sack.SackOverflow.Services.Implementations.APIServiceImplementation;
        import is.hi.hpv501.sack.SackOverflow.Services.TeamService;


        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.json.simple.parser.JSONParser;
        import org.json.simple.parser.ParseException;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import javax.validation.Valid;

        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Iterator;


@Controller
public class HomeController {

    private TeamService teamService;
    private APIServiceImplementation apiService = new APIServiceImplementation();

    @Autowired
    public HomeController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping("/")
    public String Home(Model model) {
        model.addAttribute("teams", teamService.findAll());
        String teams = null;
        try {
            teams = apiService.getAllTeams();
        } catch (IOException e) {
            e.printStackTrace();
        }


            try {
                JSONObject jsonObj = new JSONObject(teams);

                // Getting JSON Array node
                JSONArray nflLid = jsonObj.getJSONArray("NFLTeams");
                ArrayList<Teams> show = new ArrayList<Teams>();
                // looping through All Contacts
                for (int i = 0; i < nflLid.length(); i++) {
                    JSONObject c = (JSONObject) nflLid.get(i);

                    String code = c.getString("code");
                    String fullName = c.getString("fullName");
                    String shortName = c.getString("shortName");

                    Teams lid = new Teams();
                    lid.setCode(code);
                    lid.setFullName(fullName);
                    lid.setCity(shortName);
                    show.add(lid);

                }
                model.addAttribute("allTeams", show);
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }



        //System.out.println(teams);

        return "Velkominn";
    }

    @RequestMapping(value = "/addteam", method = RequestMethod.POST)
    public String addTeam(@Valid Team team, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-team";
        }
        teamService.save(team);
        model.addAttribute("teams", teamService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value = "/addteam", method = RequestMethod.GET)
    public String addTeamForm(Team team) {
        return "add-team";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTeam(@PathVariable("id") long id, Model model) {
        Team team = teamService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid team ID"));
        teamService.delete(team);
        model.addAttribute("teams", teamService.findAll());
        return "Velkominn";
    }



    @RequestMapping(value = "/getAllTeams", method = RequestMethod.GET)
    public String getAllTeams(Model model) throws IOException, ParseException, JSONException {

        String teams = apiService.getAllTeams();
        ArrayList<HashMap<String, String>> lidListi = null;
        if (teams != null) {
            try {
                JSONObject jsonObj = new JSONObject(teams);

                // Getting JSON Array node
                JSONArray nflLid = jsonObj.getJSONArray("NFLTeams");

                // looping through All Contacts
                for (int i = 0; i < nflLid.length(); i++) {
                    JSONObject c = (JSONObject) nflLid.get(i);

                    String code = c.getString("code");
                    String fullName = c.getString("fullName");
                    String shortName = c.getString("shortName");


                    model.addAttribute("allTeams", fullName);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
        }

            return "Velkominn";
    }


}


