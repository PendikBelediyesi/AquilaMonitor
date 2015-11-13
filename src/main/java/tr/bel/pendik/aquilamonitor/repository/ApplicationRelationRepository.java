package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ApplicationRelationEntity;

public interface ApplicationRelationRepository extends JpaRepository<ApplicationRelationEntity, Long> {


    ApplicationRelationEntity findByDesc(String desc);

}    
