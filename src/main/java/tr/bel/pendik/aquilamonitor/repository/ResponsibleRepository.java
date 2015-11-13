package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ResponsibleEntity;

public interface ResponsibleRepository extends JpaRepository<ResponsibleEntity, Long> {


    //   public ResponsibleEntity findByDesc(String desc);

}    
