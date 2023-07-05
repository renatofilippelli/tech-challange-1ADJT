package filippelli.renato.techchallenge1adjt.service;

import filippelli.renato.techchallenge1adjt.dto.PersonRequest;
import filippelli.renato.techchallenge1adjt.dto.PersonResponse;
import filippelli.renato.techchallenge1adjt.entity.Person;
import filippelli.renato.techchallenge1adjt.repository.PersonRepository;
import filippelli.renato.techchallenge1adjt.service.exception.ControllerNotFoundException;
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
        var person = r.findById(id).orElseThrow(() -> new ControllerNotFoundException("Not Found"));
        return new PersonResponse(person);
    }
}
