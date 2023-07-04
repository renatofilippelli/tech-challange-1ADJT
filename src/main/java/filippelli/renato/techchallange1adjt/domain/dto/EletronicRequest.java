package filippelli.renato.techchallange1adjt.domain.dto;

import filippelli.renato.techchallange1adjt.domain.entity.Eletronic;

public class EletronicRequest {
    private String name;
    private String model;
    private String power;
    private String voltage;
    private String otherRelevantInformation;

    public EletronicRequest() {}

    public EletronicRequest(
            String name, String model, String power, String voltage, String otherRelevantInformation) {
        this.name = name;
        this.model = model;
        this.power = power;
        this.voltage = voltage;
        this.otherRelevantInformation = otherRelevantInformation;
    }

    public EletronicRequest(Eletronic ea) {
        this.name = ea.getName();
        this.model = ea.getModel();
        this.power = ea.getPower();
        this.voltage = ea.getVoltage();
        this.otherRelevantInformation = ea.getOtherRelevantInformation();
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

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getOtherRelevantInformation() {
        return otherRelevantInformation;
    }

    public void setOtherRelevantInformation(String otherRelevantInformation) {
        this.otherRelevantInformation = otherRelevantInformation;
    }
}
