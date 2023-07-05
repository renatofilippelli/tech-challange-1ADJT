package filippelli.renato.techchallenge1adjt.domain.dto;

import filippelli.renato.techchallenge1adjt.domain.entity.Eletronic;
import java.util.UUID;

public class EletronicResponse {

    private UUID id;
    private String name;
    private String model;
    private Integer power;
    private Integer voltage;
    private String otherRelevantInformation;

    public EletronicResponse(Eletronic ea) {
        this.id = ea.getId();
        this.name = ea.getName();
        this.model = ea.getModel();
        this.power = ea.getPower();
        this.voltage = ea.getVoltage();
        this.otherRelevantInformation = ea.getOtherRelevantInformation();
    }

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

    public UUID getId() {
        return this.id;
    }
}
