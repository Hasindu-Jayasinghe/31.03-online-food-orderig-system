package lk.nsbm.onlinefoodorderingsystem.dto;

import lk.nsbm.onlinefoodorderingsystem.entity.User;

public class UserCredentialDto {
    private String username;
    private String password;
    private UserDto user;

    public UserCredentialDto() {
    }

    public UserCredentialDto(String username, String password) {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
