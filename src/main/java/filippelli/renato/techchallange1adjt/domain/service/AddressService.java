package filippelli.renato.techchallange1adjt.domain.service;

import filippelli.renato.techchallange1adjt.domain.dto.AddressRequest;
import filippelli.renato.techchallange1adjt.domain.entity.Address;
import filippelli.renato.techchallange1adjt.domain.repository.AddressRepository;
import filippelli.renato.techchallange1adjt.domain.service.exception.ControllerNotFoundException;
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

    public AddressRequest save(AddressRequest address){
        Address e = new Address();
        e.setCity(address.getCity());
        e.setDistrict(address.getDistrict());
        e.setNumber(address.getNumber());
        e.setState(address.getState());
        e.setStreet(address.getStreet());
        return new AddressRequest(r.save(e));
    }

    public Collection<AddressRequest> findAll(){
        var address = r.findAll();
        return address
                .stream()
                .map(AddressRequest::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public AddressRequest findById(UUID id) {
        var address = r.findById(id).orElseThrow(() -> new ControllerNotFoundException("not found"));
        return new AddressRequest(address);
    }
}
