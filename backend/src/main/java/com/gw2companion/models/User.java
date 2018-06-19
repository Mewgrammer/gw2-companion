package com.gw2companion.models;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public int Id;

    public String Username;
    public String Password;
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
