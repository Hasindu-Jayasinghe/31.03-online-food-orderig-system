package lk.nsbm.onlinefoodorderingsystem.service.impl;

import lk.nsbm.onlinefoodorderingsystem.dto.ContactDetailsDto;
import lk.nsbm.onlinefoodorderingsystem.entity.ContactDetails;
import lk.nsbm.onlinefoodorderingsystem.repository.ContactDetailsRepository;
import lk.nsbm.onlinefoodorderingsystem.service.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ContactDetailsServiceImpl implements ContactDetailsService {

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveContactDetails(ContactDetailsDto contactDetailsDto){
        if (contactDetailsDto == null){
            return false;
        }

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setContactId(contactDetailsDto.getContactId());
        contactDetails.setEmail(contactDetailsDto.getEmail());
        contactDetails.setMessage(contactDetailsDto.getMessage());
        contactDetails.setName(contactDetailsDto.getName());
        contactDetails.setSubject(contactDetailsDto.getSubject());

        contactDetailsRepository.save(contactDetails);
        return true;
    }
}
