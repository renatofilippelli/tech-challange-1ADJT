package filippelli.renato.techchallange1adjt.domain.address.service;

import filippelli.renato.techchallange1adjt.domain.address.entity.Address;
import filippelli.renato.techchallange1adjt.domain.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository r;

    public Address save(Address address){
        return r.save(address);
    }

    public Collection<Address> findAll(){
        return r.findAll();
    }
}
