package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.ParameterEntity;

public interface ParameterRepository extends JpaRepository<ParameterEntity, Long> {


    ParameterEntity findByDesc(String desc);

}    
