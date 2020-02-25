package is.hi.hpv501.sack.SackOverflow.Controllers;

import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
import is.hi.hpv501.sack.SackOverflow.Entities.User;
import is.hi.hpv501.sack.SackOverflow.Services.APIService;
import is.hi.hpv501.sack.SackOverflow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signUpPOST(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error...");
        }
        User exists = userService.findByUName(user.getuName());
        if(exists == null){
            return userService.save(user);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username unavailable");
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> usersGET() {
        return userService.findAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User loginPOST(@Valid @RequestBody User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }
        User exists = userService.login(user);
        if (exists != null) {
            session.setAttribute("LoggedInUser", user);
            return exists;
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login unsuccessful");
    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public User loggedinGET(HttpSession session) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser != null) {
            return sessionUser;
        } else
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You have to be logged in");
    }
}
