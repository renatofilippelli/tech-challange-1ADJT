package filippelli.renato.techchallenge1adjt.domain.dto;

import filippelli.renato.techchallenge1adjt.domain.entity.Person;

import java.time.LocalDate;
import java.util.UUID;

public class PersonResponse {

    private UUID id;
    private String name;
    private LocalDate birthdate;
    private String gender;
    private String kinship;
    private String otherRelevantInformation;

    public PersonResponse(Person p) {
        this.id = p.getId();
        this.name = p.getName();
        this.birthdate = p.getBirthdate();
        this.gender = p.getGender();
        this.kinship = p.getKinship();
        this.otherRelevantInformation = p.getOtherRelevantInformation();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getKinship() {
        return kinship;
    }

    public String getOtherRelevantInformation() {
        return otherRelevantInformation;
    }
}
