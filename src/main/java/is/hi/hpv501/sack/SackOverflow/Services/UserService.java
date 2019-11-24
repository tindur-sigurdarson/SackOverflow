package is.hi.hpv501.sack.SackOverflow.Services;

import is.hi.hpv501.sack.SackOverflow.Entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUName(String uName);
    User login(User user);
}