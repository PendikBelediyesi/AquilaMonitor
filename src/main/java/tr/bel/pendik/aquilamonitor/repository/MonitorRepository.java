package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.MonitorEntity;

public interface MonitorRepository extends JpaRepository<MonitorEntity, Long> {


    MonitorEntity findByDesc(String desc);

}    
