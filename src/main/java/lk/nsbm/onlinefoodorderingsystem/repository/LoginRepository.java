package lk.nsbm.onlinefoodorderingsystem.repository;

import lk.nsbm.onlinefoodorderingsystem.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends JpaRepository<UserCredential, String> {
}
