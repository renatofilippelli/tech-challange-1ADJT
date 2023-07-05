package filippelli.renato.techchallenge1adjt.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class AddressRequest {
    private static final String FIELD_MANDATORY = "field is mandatory.";
    private static final String FIELD_GREATER_THAN_ZERO = "field must be greater than zero.";
    private static final String FIELD_SIZE_TOO_LONG = "field size must be less than 255 characters";
    @NotBlank(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String street;
    @Positive(message = FIELD_GREATER_THAN_ZERO)
    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer number;
    @NotBlank(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String district;
    @NotBlank(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String city;
    @NotBlank(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String state;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
