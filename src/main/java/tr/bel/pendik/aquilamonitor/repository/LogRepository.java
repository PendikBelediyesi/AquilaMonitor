package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.LogEntity;

public interface LogRepository extends JpaRepository<LogEntity, Long> {


    LogEntity findByDesc(String desc);

}    
