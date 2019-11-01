package is.hi.hpv501.sack.SackOverflow.Services.Implementations;

import is.hi.hpv501.sack.SackOverflow.Entities.User;
import is.hi.hpv501.sack.SackOverflow.Repositories.UserRepository;
import is.hi.hpv501.sack.SackOverflow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    UserRepository repository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByUName(String uName) {
        return null;
    }

    @Override
    public User login(User user) {
        User exists = findByUName(user.getuName());
        if(exists != null){
            if(exists.getPassword().equals(user.getPassword())){
                return user;
            }
        }
        return null;

    }
}