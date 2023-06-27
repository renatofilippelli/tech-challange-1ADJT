package filippelli.renato.techchallange1adjt.domain.address.service;

import filippelli.renato.techchallange1adjt.domain.address.dto.AddressDTO;
import filippelli.renato.techchallange1adjt.domain.address.entity.Address;
import filippelli.renato.techchallange1adjt.domain.address.repository.AddressRepository;
import filippelli.renato.techchallange1adjt.domain.address.service.exception.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository r;

    public AddressDTO save(AddressDTO address){
        Address e = new Address();
        e.setCity(address.getCity());
        e.setDistrict(address.getDistrict());
        e.setNumber(address.getNumber());
        e.setState(address.getState());
        e.setStreet(address.getStreet());
        return new AddressDTO(r.save(e));
    }

    public Collection<AddressDTO> findAll(){
        var address = r.findAll();
        return address
                .stream()
                .map(a -> new AddressDTO(a)).collect(Collectors.toCollection(ArrayList::new));
    }

    public AddressDTO findById(UUID id) {
        var address = r.findById(id).orElseThrow(() -> new ControllerNotFoundException("not found"));
        return new AddressDTO(address);
    }
}
