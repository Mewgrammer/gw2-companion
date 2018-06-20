package gw2.repositories;

import gw2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByApiKey(String apiKey);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}