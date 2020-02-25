package is.hi.hpv501.sack.SackOverflow.Controllers;

        import is.hi.hpv501.sack.SackOverflow.Entities.Game;
        import is.hi.hpv501.sack.SackOverflow.Entities.Player;
        import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
        import is.hi.hpv501.sack.SackOverflow.Entities.User;
        import is.hi.hpv501.sack.SackOverflow.Services.Implementations.APIServiceImplementation;
        import is.hi.hpv501.sack.SackOverflow.Services.PlayerService;
        import is.hi.hpv501.sack.SackOverflow.Services.TeamService;
        import is.hi.hpv501.sack.SackOverflow.Services.UserService;
        import org.json.JSONException;
        import org.springframework.beans.factory.annotation.*;

        import org.springframework.http.HttpStatus;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.server.ResponseStatusException;

        import javax.management.Query;
        import javax.servlet.http.HttpSession;
        import javax.validation.Valid;
        import java.io.IOException;
        import java.util.List;

@RestController
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
    public User Home(Model model, HttpSession session) throws IOException, JSONException {
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
        if (sessionUser != null) {
            return sessionUser;
        } else
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You have to be logged in");
    }


    @RequestMapping(value="/Teams", method = RequestMethod.GET)
    public List<Teams> getAllTeams() throws IOException {

        List teams = apiService.getAllTeams();
        for(int i=0; i<teams.size();i++){
            Teams p = (Teams) teams.get(i);
            teamService.save(p);
        }
        return teamService.findAll();
    }
        
    @RequestMapping(value="/players", method = RequestMethod.GET)
    public List<Player> players() throws IOException {
        if(playerService.findAll().isEmpty()) {
            List playerAPI = apiService.getAllPlayers();
            for (int i = 0; i < playerAPI.size(); i++) {
                Player p = (Player) playerAPI.get(i);
                playerService.save(p);
            }
        }

        return playerService.findAll();
    }


    @RequestMapping(value="/Games", method = RequestMethod.GET)
    public List<Game> getAllGames(Model model) throws IOException {
        List gamesAPI = apiService.getAllGames();

        return gamesAPI;


    }

    @RequestMapping(value= "/playerSearch", method = RequestMethod.POST)
    public List<Player> searchPlayer(@RequestParam(value = "search", required = false) String search){
        List<Player> player = playerService.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(search,search);
        return player;
    }

}
