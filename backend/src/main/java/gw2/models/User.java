package gw2.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long Id;

    @Column(name="username")
    public String Username;

    @Column(name="password")
    public String Password;

    @Column(name="apikey")
    public String ApiKey;

    public User(String username, String password, String apiKey) {
        Username = username;
        Password = password;
        ApiKey = apiKey;
    }

    public User() {}

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s', apiKey='%s']",
                Id, Username, Password, ApiKey);
    }

}
