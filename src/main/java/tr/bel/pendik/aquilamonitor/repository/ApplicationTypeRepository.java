package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ApplicationTypeEntity;

public interface ApplicationTypeRepository extends JpaRepository<ApplicationTypeEntity, Long> {


    ApplicationTypeEntity findByDesc(String desc);

}    
