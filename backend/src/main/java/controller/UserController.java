package controller;

import exceptions.CustomHttpException;
import interfaces.IUserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController("/api/users")
public class UserController {
    @Autowired
    private IUserRepository repository;

    @CrossOrigin
    @RequestMapping("/api/users")
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for(User usr : repository.findAll()){
        	users.add(usr);
        }
        return users;
    }

    @CrossOrigin
    @RequestMapping(value="/api/users", method = RequestMethod.GET, params="email")
    public User fetchDataByEmail(@RequestParam("email") String email) throws CustomHttpException {
        User match = repository.findByEmail(email);
        if(match == null) {
            throw new CustomHttpException("User with Email" + email + " does not exist", HttpStatus.NOT_FOUND);
        }
        return match;
    }

    @CrossOrigin
    @RequestMapping(value="/api/users", method = RequestMethod.GET, params={"email", "password"})
    public User fetchDataByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) throws CustomHttpException {
        User match = repository.findByEmailAndPassword(email,password);
        if(match == null) {
            throw new CustomHttpException("User with Email '" + email + "' and Password '" + password + "' does not exist", HttpStatus.NOT_FOUND);
        }
        return match;
    }

    @CrossOrigin
    @RequestMapping(value="/api/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) throws  CustomHttpException {
        if(repository.findByEmail(user.getEmail()) != null) {
            throw new CustomHttpException("User with email '" + user.getEmail() + "' already exists", HttpStatus.NOT_MODIFIED);
        }
        user.setRegistrationDate(new Date());
    	return repository.save(user);
    }

    @CrossOrigin
    @RequestMapping(value="/api/users", method = RequestMethod.GET, params="id")
    public String findById(@RequestParam("id") Long id){
        return repository.findById(id).toString();
    }

    @CrossOrigin
    @RequestMapping(value="/api/users", method = RequestMethod.GET, params="apiKey")
    public User fetchDataByPublicKey(@RequestParam("apiKey") String apiKey) throws CustomHttpException{
        User match = repository.findByApiKey(apiKey);
        if(match == null) {
            throw new CustomHttpException("User with apiKey '" + apiKey + "'does not exist", HttpStatus.NOT_FOUND);
        }
        return match;
    }
}