package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUsernameAndPassword(String username, String password);


}    
