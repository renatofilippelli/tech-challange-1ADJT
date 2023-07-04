package filippelli.renato.techchallange1adjt.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import filippelli.renato.techchallange1adjt.domain.entity.Eletronic;

import java.util.UUID;

public class EletronicResponse {

    private UUID id;
    private String name;
    private String model;
    private Integer power;
    private Integer voltage;
    private String otherRelevantInformation;

    public EletronicResponse() {}

    public EletronicResponse(
            UUID id, String name, String model, Integer power, Integer voltage, String otherRelevantInformation) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.power = power;
        this.voltage = voltage;
        this.otherRelevantInformation = otherRelevantInformation;
    }

    public EletronicResponse(Eletronic ea) {
        this.id = ea.getId();
        this.name = ea.getName();
        this.model = ea.getModel();
        this.power = ea.getPower();
        this.voltage = ea.getVoltage();
        this.otherRelevantInformation = ea.getOtherRelevantInformation();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public String getOtherRelevantInformation() {
        return otherRelevantInformation;
    }

    public void setOtherRelevantInformation(String otherRelevantInformation) {
        this.otherRelevantInformation = otherRelevantInformation;
    }
}
