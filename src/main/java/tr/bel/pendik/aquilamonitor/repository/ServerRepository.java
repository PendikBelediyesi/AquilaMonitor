package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ServerEntity;

public interface ServerRepository extends JpaRepository<ServerEntity, Long> {


    ServerEntity findByDesc(String desc);

}    
