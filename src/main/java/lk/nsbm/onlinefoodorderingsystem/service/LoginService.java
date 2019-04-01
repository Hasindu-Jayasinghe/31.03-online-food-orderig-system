package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.UserCredentialDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserDto;
import lk.nsbm.onlinefoodorderingsystem.entity.UserCredential;

public interface LoginService {
    public UserCredentialDto checkUserCredentials(UserCredential userCredential);
}
