package filippelli.renato.techchallange1adjt.domain.address.controller;

import filippelli.renato.techchallange1adjt.domain.address.entity.Address;
import filippelli.renato.techchallange1adjt.domain.address.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(value = "/adresses", produces = {"application/json"})
@Tag(name = "adresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address) {
        var addressSaved = addressService.save(address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((addressSaved.getId())).toUri();
        return ResponseEntity.created(uri).body(addressSaved);
    }

    @Operation(summary = "teste", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping
    public ResponseEntity<Collection<Address>> findall(){
        return ResponseEntity.ok().body(addressService.findAll());
    }
}
