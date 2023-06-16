package filippelli.renato.techchallange1adjt.domain.address.repository;

import filippelli.renato.techchallange1adjt.domain.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
