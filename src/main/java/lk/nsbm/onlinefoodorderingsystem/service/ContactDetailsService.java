package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.ContactDetailsDto;
import lk.nsbm.onlinefoodorderingsystem.entity.ContactDetails;

public interface ContactDetailsService {
    public boolean saveContactDetails(ContactDetailsDto contactDetailsDto);
}
