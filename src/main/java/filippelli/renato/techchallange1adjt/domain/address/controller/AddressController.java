package filippelli.renato.techchallange1adjt.domain.address.controller;

import filippelli.renato.techchallange1adjt.domain.address.entity.Address;
import filippelli.renato.techchallange1adjt.domain.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/adresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address) {
        var addressSaved = addressService.save(address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((addressSaved.getId())).toUri();
        return ResponseEntity.created(uri).body(addressSaved);
    }

    @GetMapping
    public ResponseEntity<Collection<Address>> findall(){
        return ResponseEntity.ok().body(addressService.findAll());
    }
}
