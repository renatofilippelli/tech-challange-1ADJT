package filippelli.renato.techchallange1adjt.domain.service;

import filippelli.renato.techchallange1adjt.domain.dto.PersonRequest;
import filippelli.renato.techchallange1adjt.domain.dto.PersonResponse;
import filippelli.renato.techchallange1adjt.domain.entity.Person;
import filippelli.renato.techchallange1adjt.domain.repository.PersonRepository;
import filippelli.renato.techchallange1adjt.domain.service.exception.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository r;

    public PersonResponse save(PersonRequest dto) {
        Person p = new Person();
        p.setBirthdate(dto.getBirthdate());
        p.setGender(dto.getGender());
        p.setKinship(dto.getKinship());
        p.setName(dto.getName());
        p.setOtherRelevantInformation(dto.getOtherRelevantInformation());
        return new PersonResponse(r.save(p));
    }

    public Collection<PersonResponse> findAll() {
        var person = r.findAll();
        return person
                .stream()
                .map(PersonResponse::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public PersonResponse findById(UUID id) {
        var person = r.findById(id).orElseThrow(() -> new ControllerNotFoundException("not found"));
        return new PersonResponse(person);
    }
}
