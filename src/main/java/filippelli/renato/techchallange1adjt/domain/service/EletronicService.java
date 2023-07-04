package filippelli.renato.techchallange1adjt.domain.service;

import filippelli.renato.techchallange1adjt.domain.dto.EletronicResponse;
import filippelli.renato.techchallange1adjt.domain.service.exception.ControllerNotFoundException;
import filippelli.renato.techchallange1adjt.domain.dto.EletronicRequest;
import filippelli.renato.techchallange1adjt.domain.entity.Eletronic;
import filippelli.renato.techchallange1adjt.domain.repository.EletronicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EletronicService {

    @Autowired
    private EletronicRepository r;

    public EletronicResponse save(EletronicRequest dto) {
        Eletronic e = new Eletronic();
        e.setModel(dto.getModel());
        e.setName(dto.getName());
        e.setPower(dto.getPower());
        e.setVoltage(dto.getVoltage());
        e.setOtherRelevantInformation(dto.getOtherRelevantInformation());
        var es = r.save(e);

        return new EletronicResponse(es);
    }

    public Collection<EletronicResponse> findAll() {
        var eletronic = r.findAll();
        return eletronic
                .stream()
                .map(EletronicResponse::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public EletronicResponse findById(UUID id) {
        var eletronic = r.findById(id).orElseThrow(() -> new ControllerNotFoundException("not found"));
        return new EletronicResponse(eletronic);
    }
}
