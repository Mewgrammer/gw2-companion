package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private static final long serialVersionUID = -3009157732242241606L;

    @JsonProperty
    private long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("apiKey")
    private String apiKey;

       @JsonProperty("registrationDate")
    private Date registrationDate;

    public User() {}

    public User(String email, String password, String apiKey) {
        this.email = email;
        this.password = password;
        this.registrationDate = new Date();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return String.format("[id=%d, email='%s', password='%s', apiKey='%s', registrationDate='%s']", id, email, password, apiKey, registrationDate.toString());
    }
}
