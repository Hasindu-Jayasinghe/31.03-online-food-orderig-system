package lk.nsbm.onlinefoodorderingsystem.service.impl;

import lk.nsbm.onlinefoodorderingsystem.dto.ContactDetailsDto;
import lk.nsbm.onlinefoodorderingsystem.dto.OrderDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserCredentialDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserDto;
import lk.nsbm.onlinefoodorderingsystem.entity.*;
import lk.nsbm.onlinefoodorderingsystem.repository.ContactDetailsRepository;
import lk.nsbm.onlinefoodorderingsystem.repository.UserCredentialRepository;
import lk.nsbm.onlinefoodorderingsystem.repository.UserRepository;
import lk.nsbm.onlinefoodorderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean registerUser(UserCredentialDto userCredentialDto) {
        if (userCredentialDto == null) {
            return false;
        }

        UserCredential userCredential = new UserCredential();
        userCredential.setUsername(userCredentialDto.getUsername());
        userCredential.setPassword(userCredentialDto.getPassword());

        User user = new User();
        user.setFirstName(userCredentialDto.getUser().getFirstName());
        user.setLastName(userCredentialDto.getUser().getLastName());
        user.setEmail(userCredentialDto.getUser().getEmail());
        user.setUserType(userCredentialDto.getUser().getUserType());

        User user1 = userRepository.save(user);
        if (user1 != null) {
            userCredential.setUserCredential(user1);
            UserCredential save = userCredentialRepository.save(userCredential);

            return save != null;
        }
        return false;

    }

    @Override
    public List<ContactDetailsDto> getUserComments() {

        List<ContactDetailsDto> contactDetailsDtos = contactDetailsRepository.findAll().stream().map(
                contactDetails -> new ContactDetailsDto(
                        contactDetails.getContactId(),
                        contactDetails.getName(),
                        contactDetails.getEmail(),
                        contactDetails.getSubject(),
                        contactDetails.getMessage())).collect(Collectors.toList());

        return contactDetailsDtos;
    }
}
