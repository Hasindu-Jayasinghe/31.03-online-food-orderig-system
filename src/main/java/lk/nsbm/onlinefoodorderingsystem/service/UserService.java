package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.ContactDetailsDto;
import lk.nsbm.onlinefoodorderingsystem.dto.OrderDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserCredentialDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserDto;

import java.util.List;

public interface UserService {

    public boolean registerUser(UserCredentialDto userCredentialDto);
    public List<ContactDetailsDto> getUserComments();
}
