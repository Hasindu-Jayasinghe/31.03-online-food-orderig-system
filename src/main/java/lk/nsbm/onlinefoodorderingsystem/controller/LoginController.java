package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.UserCredentialDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserDto;
import lk.nsbm.onlinefoodorderingsystem.entity.UserCredential;
import lk.nsbm.onlinefoodorderingsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/check_credentials")
    public UserCredentialDto loginUser(@RequestBody UserCredential userCredential){
        return loginService.checkUserCredentials(userCredential);
    }

}
