package tr.bel.pendik.aquilamonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.bel.pendik.aquilamonitor.data.IpAddressEntity;

public interface IpAddressRepository extends JpaRepository<IpAddressEntity, Long> {


    IpAddressEntity findByDesc(String desc);

}    
