package interfaces;

import model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository  extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findByApiKey(String apiKey);
}
