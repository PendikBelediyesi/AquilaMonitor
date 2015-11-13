package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.MonitorLogEntity;

public interface MonitorLogRepository extends JpaRepository<MonitorLogEntity, Long> {


    //public MonitorLogEntity findByDesc(String desc);

}    
