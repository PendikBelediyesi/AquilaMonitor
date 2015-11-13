package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    ApplicationEntity findByDesc(String desc);

}    
