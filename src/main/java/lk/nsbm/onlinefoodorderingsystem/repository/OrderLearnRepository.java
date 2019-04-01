package lk.nsbm.onlinefoodorderingsystem.repository;

import lk.nsbm.onlinefoodorderingsystem.entity.ContactDetails;
import lk.nsbm.onlinefoodorderingsystem.entity.OrderLearn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLearnRepository extends JpaRepository<OrderLearn, Integer> {
}
