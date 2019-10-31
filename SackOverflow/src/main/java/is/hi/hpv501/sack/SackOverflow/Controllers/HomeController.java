package is.hi.hpv501.sack.SackOverflow.Controllers;

        import is.hi.hpv501.sack.SackOverflow.Entities.Team;
        import is.hi.hpv501.sack.SackOverflow.Entities.User;
        import is.hi.hpv501.sack.SackOverflow.Services.APIService;
        import is.hi.hpv501.sack.SackOverflow.Services.Implementations.APIServiceImplementation;
        import is.hi.hpv501.sack.SackOverflow.Services.TeamService;
        import is.hi.hpv501.sack.SackOverflow.Services.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import javax.servlet.http.HttpSession;
        import javax.validation.Valid;
        import java.io.IOException;

@Controller
public class HomeController {

    private TeamService teamService;
    private APIServiceImplementation apiService = new APIServiceImplementation();
    private UserService userService;
    @Autowired
    public HomeController(TeamService teamService){this.teamService = teamService;}

    @RequestMapping("/")
    public String Home(Model model){

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
        System.out.println(teams);


        model.addAttribute("allTeams",teams);

        return "Velkominn";
    }

    @RequestMapping(value="/getAllPlayers", method = RequestMethod.GET)
    public String getAllPlayers(Model model) throws IOException {

        String allPlayers = apiService.getAllPlayers();

        System.out.println(allPlayers);


        model.addAttribute("allPlayers",allPlayers);

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
