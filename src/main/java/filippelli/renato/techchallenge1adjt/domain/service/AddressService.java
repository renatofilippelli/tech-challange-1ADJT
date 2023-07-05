package filippelli.renato.techchallenge1adjt.domain.service;

import filippelli.renato.techchallenge1adjt.domain.dto.AddressRequest;
import filippelli.renato.techchallenge1adjt.domain.dto.AddressResponse;
import filippelli.renato.techchallenge1adjt.domain.entity.Address;
import filippelli.renato.techchallenge1adjt.domain.repository.AddressRepository;
import filippelli.renato.techchallenge1adjt.domain.service.exception.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository r;

    public AddressResponse save(AddressRequest address){
        Address e = new Address();
        e.setCity(address.getCity());
        e.setDistrict(address.getDistrict());
        e.setNumber(address.getNumber());
        e.setState(address.getState());
        e.setStreet(address.getStreet());
        return new AddressResponse(r.save(e));
    }

    public Collection<AddressResponse> findAll(){
        var address = r.findAll();
        return address
                .stream()
                .map(AddressResponse::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public AddressResponse findById(UUID id) {
        var address = r.findById(id).orElseThrow(() -> new ControllerNotFoundException("Not Found"));
        return new AddressResponse(address);
    }
}
