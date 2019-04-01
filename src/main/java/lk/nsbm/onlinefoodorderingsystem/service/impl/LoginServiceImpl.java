package lk.nsbm.onlinefoodorderingsystem.service.impl;

import lk.nsbm.onlinefoodorderingsystem.dto.UserCredentialDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserDto;
import lk.nsbm.onlinefoodorderingsystem.entity.User;
import lk.nsbm.onlinefoodorderingsystem.entity.UserCredential;
import lk.nsbm.onlinefoodorderingsystem.repository.LoginRepository;
import lk.nsbm.onlinefoodorderingsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public UserCredentialDto checkUserCredentials(UserCredential userCredential) {
        if (userCredential == null) {
            return null;
        }

        UserCredential credential = null;
        try {
            credential = loginRepository.findById(userCredential.getUsername()).get();

            if ( credential.getPassword().equals(userCredential.getPassword()) ){
                UserCredentialDto userCredentialDto = new UserCredentialDto(  );
                userCredentialDto.setUsername(userCredential.getUsername());
                userCredentialDto.setUser( new UserDto( credential.getUserCredential().getUserId(), credential.getUserCredential().getFirstName(), credential.getUserCredential().getUserType()  ) );
                return userCredentialDto;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Incorrect user");
        }
        return null;
    }
}
