package gw2.api.controller;

import com.netflix.appinfo.InstanceInfo;
import gw2.api.exceptions.CustomHttpException;
import gw2.api.model.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController("/api/users")
public class UserController {

    private final String databaseServiceName = "database-service";
    private DiscoveryClient discoveryClient;
    private RestTemplate template;

    public UserController(DiscoveryClient discoveryClient) {
        this.template = new RestTemplate();
        this.discoveryClient = discoveryClient;
    }

    @CrossOrigin
    @RequestMapping("/api/users")
    public Object findAll() {
        final ServiceInstance instance = this.discoveryClient.getInstances(this.databaseServiceName).get(0);
        final String url = instance.getUri()  + "/api/users";
        System.out.println("[API] Requesting " + url);
        final ResponseEntity users = this.template.getForEntity(url, String.class);
        return users.getBody();
    }

    @CrossOrigin
    @RequestMapping("/")
    public String hello() {
        return "Api-Service is Running !";
    }

    @CrossOrigin
    @RequestMapping(value="/api/users", method = RequestMethod.GET, params={"email", "password"})
    public User fetchDataByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) throws CustomHttpException {
       System.out.println("Login Request For User=" + email + " Password=" + password);
       final ServiceInstance instance = this.discoveryClient.getInstances(this.databaseServiceName).get(0);
       final String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/api/users" + "?email=" + email + "&?password=" + password;
       final ResponseEntity<User> resp = this.template.getForEntity(url, User.class);
       System.out.println("Login Response:" + resp.getBody());
       return resp.getBody();
    }

    @CrossOrigin
    @RequestMapping(value="/api/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) throws CustomHttpException {
        final ServiceInstance instance = this.discoveryClient.getInstances(this.databaseServiceName).get(0);
        final String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/api/users";
        final ResponseEntity<User> resp = this.template.postForEntity(url, user, User.class);
        return resp.getBody();
    }
}