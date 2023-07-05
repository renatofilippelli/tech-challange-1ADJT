package filippelli.renato.techchallenge1adjt.domain.repository;

import filippelli.renato.techchallenge1adjt.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}

