package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.OsEntity;


public interface OsRepository extends JpaRepository<OsEntity, Long> {
    OsEntity findByDesc(String desc);
}    
