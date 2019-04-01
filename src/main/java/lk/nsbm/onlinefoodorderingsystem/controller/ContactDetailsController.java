package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.ContactDetailsDto;
import lk.nsbm.onlinefoodorderingsystem.service.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/contacts")
public class ContactDetailsController {

    @Autowired
    private ContactDetailsService contactDetailsService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveContact(@RequestBody ContactDetailsDto contactDetailsDto){
        return contactDetailsService.saveContactDetails(contactDetailsDto);
    }

}
