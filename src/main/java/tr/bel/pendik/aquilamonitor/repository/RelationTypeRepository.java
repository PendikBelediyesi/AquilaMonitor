package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.RelationTypeEntity;

public interface RelationTypeRepository extends JpaRepository<RelationTypeEntity, Long> {


    RelationTypeEntity findByDesc(String desc);

}    
