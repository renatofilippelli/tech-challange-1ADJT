package filippelli.renato.techchallange1adjt.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EletronicRequest {

    private static final String FIELD_MANDATORY = "field is mandatory.";
    private static final String FIELD_GREATER_THAN_ZERO = "field must be greater than zero.";
    private static final String FIELD_SIZE_TOO_LONG = "field size must be less than 255 characters";
    @NotBlank(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String name;
    @NotBlank(message = FIELD_MANDATORY)
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String model;
    @NotNull(message = FIELD_MANDATORY)
    @Positive(message = FIELD_GREATER_THAN_ZERO)
    private Integer power;
    @NotNull(message = FIELD_MANDATORY)
    @Positive(message = FIELD_GREATER_THAN_ZERO)
    private Integer voltage;
    @Size(max = 255, message = FIELD_SIZE_TOO_LONG)
    private String otherRelevantInformation;

    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public Integer getPower() {
        return power;
    }
    public Integer getVoltage() {
        return voltage;
    }
    public String getOtherRelevantInformation() {
        return otherRelevantInformation;
    }
}
