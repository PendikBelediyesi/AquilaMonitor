package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ProgramEntity;

public interface ProgramRepository extends JpaRepository<ProgramEntity, Long> {


    ProgramEntity findByDesc(String desc);

}    
