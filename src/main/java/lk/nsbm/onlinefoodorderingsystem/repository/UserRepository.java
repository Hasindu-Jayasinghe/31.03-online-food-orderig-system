package lk.nsbm.onlinefoodorderingsystem.repository;

import lk.nsbm.onlinefoodorderingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
