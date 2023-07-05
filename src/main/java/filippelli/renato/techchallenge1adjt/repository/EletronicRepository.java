package filippelli.renato.techchallenge1adjt.repository;

import filippelli.renato.techchallenge1adjt.entity.Eletronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EletronicRepository extends JpaRepository<Eletronic, UUID> {
}

