package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ServerProgramEntity;

public interface ServerProgramRepository extends JpaRepository<ServerProgramEntity, Long> {

    ServerProgramEntity findByDesc(String desc);

}    
