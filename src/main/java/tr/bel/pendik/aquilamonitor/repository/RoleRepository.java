package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
