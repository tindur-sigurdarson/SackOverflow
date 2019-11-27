package is.hi.hpv501.sack.SackOverflow.Controllers;

        import is.hi.hpv501.sack.SackOverflow.Entities.Player;
        import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
        import is.hi.hpv501.sack.SackOverflow.Entities.User;
        import is.hi.hpv501.sack.SackOverflow.Services.Implementations.APIServiceImplementation;
        import is.hi.hpv501.sack.SackOverflow.Services.PlayerService;
        import is.hi.hpv501.sack.SackOverflow.Services.TeamService;
        import is.hi.hpv501.sack.SackOverflow.Services.UserService;
        import org.json.JSONException;
        import org.springframework.beans.factory.annotation.*;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

        import javax.management.Query;
        import javax.servlet.http.HttpSession;
        import javax.validation.Valid;
        import java.io.IOException;
        import java.util.List;

@Controller
public class HomeController {

    private TeamService teamService;
    private APIServiceImplementation apiService = new APIServiceImplementation();
    private UserService userService;
    private PlayerService playerService;

    @Autowired
    public HomeController(TeamService teamService, PlayerService playerService,UserService userService){
        this.teamService = teamService;
        this.playerService=playerService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String Home(Model model, HttpSession session) throws IOException, JSONException {
        User sessionUser = (User) session.getAttribute("loggedInUser");
        String[] arr = {"ARI", "ATL", "BAL", "BUF",
                "CAR", "CIN", "CHI", "CLE",
                "DAL", "DEN", "DET", "GRE",
                "HOU", "IND", "JAC", "KAN",
                "LAC", "LAR", "MIA", "MIN",
                "NOS", "NYG", "NYJ", "OAK",
                "PHI", "PIT", "SAN", "SEA",
                "TAM", "TEN", "WAS"};
        int rand = (int)(Math.random()*32);
        List<User> us = userService.findAll();
        for(int i =0; i<us.size();i++){
            if(us.get(i).getuName().equals(sessionUser.getuName())){
                if(us.get(i).getFavTeam().equals("RANDOM")){
                    sessionUser.setFavTeam(arr[rand]);
                }else {
                    sessionUser.setFavTeam(us.get(i).getFavTeam());
                }
                break;
            }
        }
        if(sessionUser !=null){
            model.addAttribute("notandi",sessionUser);
        }else{
            model.addAttribute("notandi",null);
        }
        return "Index";
    }



    @RequestMapping(value="/Teams", method = RequestMethod.GET)
    public String getAllTeams(Model model) throws IOException {

        List teams = apiService.getAllTeams();
        for(int i=0; i<teams.size();i++){
            Teams p = (Teams) teams.get(i);
            teamService.save(p);
        }

        //AFC East
        Teams afcEast0 = (Teams) teams.get(0);
        model.addAttribute("afcEast1",afcEast0.getName());
        model.addAttribute("afcEast11",afcEast0.getRecord());

        Teams afcEast1 = (Teams) teams.get(1);
        model.addAttribute("afcEast2",afcEast1.getName());
        model.addAttribute("afcEast22",afcEast1.getRecord());

        Teams afcEast2 = (Teams) teams.get(2);
        model.addAttribute("afcEast3",afcEast2.getName());
        model.addAttribute("afcEast33",afcEast2.getRecord());

        Teams afcEast3 = (Teams) teams.get(3);
        model.addAttribute("afcEast4",afcEast3.getName());
        model.addAttribute("afcEast44",afcEast3.getRecord());
        //AFC North
        Teams afcNorth1 = (Teams) teams.get(4);
        model.addAttribute("afcNorth1",afcNorth1.getName());
        model.addAttribute("afcNorth11",afcNorth1.getRecord());

        Teams afcNorth2 = (Teams) teams.get(5);
        model.addAttribute("afcNorth2",afcNorth2.getName());
        model.addAttribute("afcNorth22",afcNorth2.getRecord());

        Teams afcNorth3 = (Teams) teams.get(6);
        model.addAttribute("afcNorth3",afcNorth3.getName());
        model.addAttribute("afcNorth33",afcNorth3.getRecord());

        Teams afcNorth4 = (Teams) teams.get(7);
        model.addAttribute("afcNorth4",afcNorth4.getName());
        model.addAttribute("afcNorth44",afcNorth4.getRecord());
        //AFC South
        Teams afcSouth1 = (Teams) teams.get(8);
        model.addAttribute("afcSouth1",afcSouth1.getName());
        model.addAttribute("afcSouth11",afcSouth1.getRecord());

        Teams afcSouth2 = (Teams) teams.get(9);
        model.addAttribute("afcSouth2",afcSouth2.getName());
        model.addAttribute("afcSouth22",afcSouth2.getRecord());

        Teams afcSouth3 = (Teams) teams.get(10);
        model.addAttribute("afcSouth3",afcSouth3.getName());
        model.addAttribute("afcSouth33",afcSouth3.getRecord());

        Teams afcSouth4 = (Teams) teams.get(11);
        model.addAttribute("afcSouth4",afcSouth4.getName());
        model.addAttribute("afcSouth44",afcSouth4.getRecord());
        //AFC West
        Teams afcWest1 = (Teams) teams.get(12);
        model.addAttribute("afcWest1",afcWest1.getName());
        model.addAttribute("afcWest11",afcWest1.getRecord());

        Teams afcWest2 = (Teams) teams.get(13);
        model.addAttribute("afcWest2",afcWest2.getName());
        model.addAttribute("afcWest22",afcWest2.getRecord());

        Teams afcWest3 = (Teams) teams.get(14);
        model.addAttribute("afcWest3",afcWest3.getName());
        model.addAttribute("afcWest33",afcWest3.getRecord());

        Teams afcWest4 = (Teams) teams.get(15);
        model.addAttribute("afcWest4",afcWest4.getName());
        model.addAttribute("afcWest44",afcWest4.getRecord());
        //NFC East
        Teams nfcEast1 = (Teams) teams.get(16);
        model.addAttribute("nfcEast1",nfcEast1.getName());
        model.addAttribute("nfcEast11",nfcEast1.getRecord());

        Teams nfcEast2 = (Teams) teams.get(17);
        model.addAttribute("nfcEast2",nfcEast2.getName());
        model.addAttribute("nfcEast22",nfcEast2.getRecord());

        Teams nfcEast3 = (Teams) teams.get(18);
        model.addAttribute("nfcEast3",nfcEast3.getName());
        model.addAttribute("nfcEast33",nfcEast3.getRecord());

        Teams nfcEast4 = (Teams) teams.get(19);
        model.addAttribute("nfcEast4",nfcEast4.getName());
        model.addAttribute("nfcEast44",nfcEast4.getRecord());
        //NFC North
        Teams nfcNorth1 = (Teams) teams.get(20);
        model.addAttribute("nfcNorth1",nfcNorth1.getName());
        model.addAttribute("nfcNorth11",nfcNorth1.getRecord());

        Teams nfcNorth2 = (Teams) teams.get(21);
        model.addAttribute("nfcNorth2",nfcNorth2.getName());
        model.addAttribute("nfcNorth22",nfcNorth2.getRecord());

        Teams nfcNorth3 = (Teams) teams.get(22);
        model.addAttribute("nfcNorth3",nfcNorth3.getName());
        model.addAttribute("nfcNorth33",nfcNorth3.getRecord());

        Teams nfcNorth4 = (Teams) teams.get(23);
        model.addAttribute("nfcNorth4",nfcNorth4.getName());
        model.addAttribute("nfcNorth44",nfcNorth4.getRecord());
        //NFC South
        Teams nfcSouth1 = (Teams) teams.get(24);
        model.addAttribute("nfcSouth1",nfcSouth1.getName());
        model.addAttribute("nfcSouth11",nfcSouth1.getRecord());

        Teams nfcSouth2 = (Teams) teams.get(25);
        model.addAttribute("nfcSouth2",nfcSouth2.getName());
        model.addAttribute("nfcSouth22",nfcSouth2.getRecord());

        Teams nfcSouth3 = (Teams) teams.get(26);
        model.addAttribute("nfcSouth3",nfcSouth3.getName());
        model.addAttribute("nfcSouth33",nfcSouth3.getRecord());

        Teams nfcSouth4 = (Teams) teams.get(27);
        model.addAttribute("nfcSouth4",nfcSouth4.getName());
        model.addAttribute("nfcSouth44",nfcSouth4.getRecord());
        //NFC West
        Teams nfcWest1 = (Teams) teams.get(28);
        model.addAttribute("nfcWest1",nfcWest1.getName());
        model.addAttribute("nfcWest11",nfcWest1.getRecord());

        Teams nfcWest2 = (Teams) teams.get(29);
        model.addAttribute("nfcWest2",nfcWest2.getName());
        model.addAttribute("nfcWest22",nfcWest2.getRecord());

        Teams nfcWest3 = (Teams) teams.get(30);
        model.addAttribute("nfcWest3",nfcWest3.getName());
        model.addAttribute("nfcWest33",nfcWest3.getRecord());

        Teams nfcWest4 = (Teams) teams.get(31);
        model.addAttribute("nfcWest4",nfcWest4.getName());
        model.addAttribute("nfcWest44",nfcWest4.getRecord());


        return "teams";
    }
        
    @RequestMapping(value="/players", method = RequestMethod.GET)
    public String players(Model model) throws IOException {
        if(playerService.findAll().isEmpty()) {
            List playerAPI = apiService.getAllPlayers();
            for (int i = 0; i < playerAPI.size(); i++) {
                Player p = (Player) playerAPI.get(i);
                playerService.save(p);
            }
        }

        model.addAttribute("allPlayers",playerService.findAll());

        return "players";
    }


    @RequestMapping(value="/Games", method = RequestMethod.GET)
    public String getAllGames(Model model) throws IOException {
        List gamesAPI = apiService.getAllGames();

        model.addAttribute("allGames", gamesAPI);

        return "Games";
    }

    @RequestMapping(value= "/playerSearch", method = RequestMethod.POST)
    public String searchPlayer(@RequestParam(value = "search", required = false) String search, Model model){
        List<Player> player = playerService.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(search,search);
        model.addAttribute("allPlayers", player);
        return "players";
    }

}
