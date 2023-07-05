package filippelli.renato.techchallange1adjt.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PersonRequest {
    private static final String FIELD_MANDATORY = "field is mandatory.";
    private static final String FIELD_SIZE_TOO_LONG = "field size must be less than 255 characters";

    @NotNull(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String name;
    @NotNull(message = FIELD_MANDATORY)
    @Past
    private LocalDate birthdate;
    @NotNull(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String gender;
    @NotNull(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String kinship;
    @NotNull(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String otherRelevantInformation;

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
