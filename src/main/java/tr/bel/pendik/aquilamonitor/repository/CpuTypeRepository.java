package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.CpuTypeEntity;

public interface CpuTypeRepository extends JpaRepository<CpuTypeEntity, Long> {


    CpuTypeEntity findByDesc(String desc);

}    
