package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ServerTypeEntity;

public interface ServerTypeRepository extends JpaRepository<ServerTypeEntity, Long> {


    ServerTypeEntity findByDesc(String desc);

}    
