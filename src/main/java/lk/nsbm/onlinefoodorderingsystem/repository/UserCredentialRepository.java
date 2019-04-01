package lk.nsbm.onlinefoodorderingsystem.repository;

import lk.nsbm.onlinefoodorderingsystem.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository extends JpaRepository<UserCredential,String> {
}
