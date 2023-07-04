package filippelli.renato.techchallange1adjt.domain.repository;

import filippelli.renato.techchallange1adjt.domain.entity.Eletronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EletronicRepository extends JpaRepository<Eletronic, UUID> {
}

