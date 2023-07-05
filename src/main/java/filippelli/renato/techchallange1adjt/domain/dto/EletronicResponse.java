package filippelli.renato.techchallange1adjt.domain.dto;

import filippelli.renato.techchallange1adjt.domain.entity.Eletronic;
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

    public UUID getId() {
        return this.id;
    }
}
