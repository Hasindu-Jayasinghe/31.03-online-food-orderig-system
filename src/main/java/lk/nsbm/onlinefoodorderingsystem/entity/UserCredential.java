package lk.nsbm.onlinefoodorderingsystem.entity;

import lk.nsbm.onlinefoodorderingsystem.dto.UserCredentialDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserCredential {
    @Id
    private String username;
    private String password;


    public UserCredential(String username, String password, User user) {
        this.username = username;
        this.password = password;
        this.user = user;
    }

    @OneToOne
    private User user;

    public UserCredential() {
    }

    public UserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUserCredential() {
        return user;
    }

    public void setUserCredential(User user) {
        this.user = user;
    }
}
