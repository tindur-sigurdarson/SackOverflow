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
    public HomeController(TeamService teamService, PlayerService playerService){
        this.teamService = teamService;
        this.playerService=playerService;
    }

    @RequestMapping("/")
    public String Home(Model model) throws IOException, JSONException {

        return "index";
    }

    

    @RequestMapping(value="/addteam", method = RequestMethod.GET)
    public String addTeamForm(Teams team){
        return "add-team";
    }



    @RequestMapping(value="/Teams", method = RequestMethod.GET)
    public String getAllTeams(Model model, String lid) throws IOException {

        List teams = apiService.getAllTeams();
        for(int i=0; i<teams.size();i++){
            Teams p = (Teams) teams.get(i);
            teamService.save(p);
        }
        model.addAttribute("allTeams",teams);
        model.addAttribute("lidnafn",teamService.findAll());

        return "teams";
    }
        
    @RequestMapping(value="/players", method = RequestMethod.GET)
    public String players(Model model) throws IOException {
        List playerAPI = apiService.getAllPlayers();
        for(int i=0; i<playerAPI.size();i++){
            Player p = (Player) playerAPI.get(i);
            playerService.save(p);
        }
        model.addAttribute("allPlayers",playerAPI);

        return "players";
    }


    @RequestMapping(value="/Games", method = RequestMethod.GET)
    public String getAllGames(Model model) throws IOException {
        List gamesAPI = apiService.getAllGames();

        model.addAttribute("allGames", gamesAPI);

        return "Games";
    }
    
    @RequestMapping(value="/SackOverflow", method = RequestMethod.GET)
    public String getHome(Model model) throws IOException {

        return "index";
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
        model.addAttribute("users", userService.findAll());
        return "index";
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
    @RequestMapping(value= "/playerSearch", method = RequestMethod.POST)
    public String searchPlayer(@RequestParam(value = "search", required = false) String search, Model model){

        List<Player> player = playerService.findByFirstName(search);
        //List<Player> playlast = playerService.findByLastName(search);
        model.addAttribute("allPlayers", player);
        return "players";
    }

}
