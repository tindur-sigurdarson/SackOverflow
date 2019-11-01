package is.hi.hpv501.sack.SackOverflow.Controllers;

        import com.fasterxml.jackson.annotation.JsonAlias;
        import is.hi.hpv501.sack.SackOverflow.Entities.Player;
        import is.hi.hpv501.sack.SackOverflow.Entities.Team;
        import is.hi.hpv501.sack.SackOverflow.Entities.User;
        import is.hi.hpv501.sack.SackOverflow.Services.APIService;
        import is.hi.hpv501.sack.SackOverflow.Services.Implementations.APIServiceImplementation;
        import is.hi.hpv501.sack.SackOverflow.Services.TeamService;
        import is.hi.hpv501.sack.SackOverflow.Services.UserService;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.expression.spel.ast.NullLiteral;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import javax.servlet.http.HttpSession;
        import javax.validation.Valid;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.HashMap;

@Controller
public class HomeController {

    private TeamService teamService;
    private APIServiceImplementation apiService = new APIServiceImplementation();
    private UserService userService;
    @Autowired
    public HomeController(TeamService teamService){this.teamService = teamService;}

    @RequestMapping("/")
    public String Home(Model model) throws IOException, JSONException {

        Team pats = new Team("New England Patriots","NE","6-0");
        Team jags = new Team("Jacksonville Jaguars", "JAX", "2-4");
        teamService.save(pats);
        teamService.save(jags);

 /*
        try {
            String api = apiService.getAllPlayers();
            System.out.println(api);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("teams", teamService.findAll());
        String teams = null;
        try {
            teams = apiService.getAllTeams();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(teams);
        model.addAttribute("allTeams",teams);
    */

        return "Velkominn";
    }

    @RequestMapping(value ="/addteam", method = RequestMethod.POST)
    public String addTeam(@Valid Team team, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-team";
        }
        teamService.save(team);
        model.addAttribute("teams", teamService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value="/addteam", method = RequestMethod.GET)
    public String addTeamForm(Team team){
        return "add-team";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteTeam(@PathVariable("id") long id, Model model){
        Team team = teamService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid team ID"));
        teamService.delete(team);
        model.addAttribute("teams", teamService.findAll());
        return "Velkominn";
    }


    @RequestMapping(value="/getAllTeams", method = RequestMethod.GET)
    public String getAllTeams(Model model) throws IOException {

        String teams = apiService.getAllTeams();



        model.addAttribute("allTeams",teams);

        return "Velkominn";
    }

    @RequestMapping(value="/getAllPlayers", method = RequestMethod.GET)
    public String getAllPlayers(Model model) throws IOException {
        String playerAPI = apiService.getAllPlayers();
        try {

            JSONObject obj = new JSONObject(playerAPI);
            JSONObject obj2 = obj.getJSONObject("cumulativeplayerstats");
            JSONArray jsonArr = obj2.getJSONArray("playerstatsentry");
            ArrayList<Player> leikmannalisti = new ArrayList<Player>();
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
                }catch (JSONException e){
                    play.setJersey(-1);
                }
                try {
                    JSONObject lid = c.getJSONObject("team");
                    play.setTeam(lid.getString("Name"));
                }catch (JSONException e){
                    String lid2 = "Free Agent";
                    play.setTeam(lid2);
                }



                JSONObject stats = c.getJSONObject("stats");
                //Games Played
                JSONObject gamesPl = stats.getJSONObject("GamesPlayed");
                int gamesplayed = gamesPl.getInt("#text");

                //Passing Stats
                if(position.equals("QB") ) {
                    JSONObject passAt = stats.getJSONObject("PassAttempts");
                    int passAttempts = passAt.getInt("#text");
                    play.setPassAttempts(passAttempts);
                }
                if(position.equals("QB")) {
                    try {
                        JSONObject passcomp = stats.getJSONObject("PassCompletions");
                        int passCompletion = passcomp.getInt("#text");
                        play.setPassCompletion(passCompletion);
                    }catch (JSONException e){
                        int passCompletion = 0;
                        play.setPassCompletion(passCompletion);
                    }
                }
                if(position.equals("QB")) {
                    try {
                        JSONObject passprosenta = stats.getJSONObject("PassPct");
                        double passpct = passprosenta.getDouble("#text");
                        play.setPassPct(passpct);
                    }catch (JSONException e){
                        double passpct = 0.0;
                        play.setPassPct(passpct);
                    }
                }
                if(position.equals("QB")) {
                    try {
                        JSONObject passyard = stats.getJSONObject("PassYards");
                        int passYards = passyard.getInt("#text");
                        play.setPassYards(passYards);
                    }catch (JSONException e){
                        int passYards = 0;
                        play.setPassYards(passYards);
                    }
                }
                if(position.equals("QB")) {
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
                    }catch (JSONException e){
                        play.setFumbles(0);
                    }
                }

                //Rush Stats
                if(position.equals("QB")||position.equals("RB") ) {
                    JSONObject rushAt = stats.getJSONObject("RushAttempts");
                    int rushAttempts = rushAt.getInt("#text");
                    play.setRushAttempts(rushAttempts);
                }
                if(position.equals("QB")||position.equals("RB")) {
                    try {
                        JSONObject rushyard = stats.getJSONObject("RushYards");
                        int rushYards = rushyard.getInt("#text");
                        play.setRushYards(rushYards);
                    }catch (JSONException e){
                        int rushYards = 0;
                        play.setRushYards(rushYards);
                    }
                }
                if(position.equals("QB")||position.equals("RB")) {
                    try {
                        JSONObject rushAVG = stats.getJSONObject("RushAverage");
                        double rushavg = rushAVG.getDouble("#text");
                        play.setRushAvg(rushavg);
                    }catch (JSONException e){
                        double rushavg = 0.0;
                        play.setRushAvg(rushavg);
                    }
                }
                if(position.equals("QB")||position.equals("RB")) {
                    JSONObject rushtd = stats.getJSONObject("RushTD");
                    int rushTD = rushtd.getInt("#text");
                    play.setRushTD(rushTD);
                }

                //Targets and receptions
                if(position.equals("WR")||position.equals("RB")||position.equals("TE")) {
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
                    }catch (JSONException e){
                        play.setRecYards(0);
                    }
                    JSONObject rectd = stats.getJSONObject("RecTD");
                    int receptTd = rectd.getInt("#text");
                    play.setRecTD(receptTd);
                    try {
                        JSONObject fumbles = stats.getJSONObject("Fumbles");
                        play.setFumbles(fumbles.getInt("Text"));
                    }catch (JSONException e){
                        play.setFumbles(0);
                    }

                }
                //varnar stats
                if(position.equals("DB")||position.equals("LB")||position.equals("CB")
                        ||position.equals("SS")||position.equals("DT")||
                        position.equals("DE")||position.equals("ILB")
                        ||position.equals("OLB")||position.equals("MLB")) {

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
                    }catch (JSONException e){
                        play.setFumForced(0);
                    }

                    try{
                        JSONObject sacks = stats.getJSONObject("Sacks");
                        play.setSacks(sacks.getDouble("#text"));
                    }catch (JSONException e){
                        play.setSacks(0);
                    }
                    try {
                        JSONObject saf = stats.getJSONObject("Safeties");
                        play.setSafeties(saf.getInt("#text"));
                    }catch (JSONException e){
                        play.setSafeties(0);
                    }
                }

                //stats fyrir kicker ásamt því að bæta þeim í arraylistan
                if (position.equals("K")){
                    JSONObject fgM = stats.getJSONObject("FgMade");
                    play.setFgMade(fgM.getInt("#text"));

                    JSONObject fgAtt = stats.getJSONObject("FgAtt");
                    play.setFgAtt(fgAtt.getInt("#text"));

                    try {
                        JSONObject fgPct = stats.getJSONObject("FgPct");
                        play.setFgPct(fgPct.getDouble("#text"));
                    }catch (JSONException e){
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

                play.setPlayerID(i);
                play.setLastName(lastName);
                play.setFirstName(firstName);
                play.setPosition(position);
                play.setGamesPlayed(gamesplayed);

                //bæta leikmönnum í arraylist
                leikmannalisti.add(play);

            }
            model.addAttribute("allPlayers", leikmannalisti);
            System.out.println("virkar");
        } catch (JSONException e){
            System.out.println("virkar ekki");
        }
        return "Velkominn";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpGET(User user){
        return "signup";
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpPOST(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "signup";
        }
        User exists = userService.findByUName(user.getuName());
        if(exists == null){
            userService.save(user);
        }
        model.addAttribute("movies", userService.findAll());
        return "Velkominn";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersGET(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@Valid User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "login";
        }
        model.addAttribute("movies",userService.findAll());
        User exists = userService.login(user);
        if(exists != null){
            session.setAttribute("LoggedInUser", user);
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession session, Model model){
        model.addAttribute("movies",userService.findAll());
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser  != null){
            model.addAttribute("loggedinuser", sessionUser);
            return "loggedInUser";
        }
        return "redirect:/";
    }

}
