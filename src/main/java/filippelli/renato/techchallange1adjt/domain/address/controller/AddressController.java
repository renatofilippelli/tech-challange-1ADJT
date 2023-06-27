package filippelli.renato.techchallange1adjt.domain.address.controller;

import filippelli.renato.techchallange1adjt.domain.address.dto.AddressDTO;
import filippelli.renato.techchallange1adjt.domain.address.entity.Address;
import filippelli.renato.techchallange1adjt.domain.address.service.AddressService;
import filippelli.renato.techchallange1adjt.domain.address.service.exception.DefaultError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/adresses", produces = {"application/json"})
@Tag(name = "adresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Operation(summary = "teste", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO address) {
        var addressSaved = addressService.save(address);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand((addressSaved.getId()))
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(addressSaved);
    }

    @Operation(summary = "Get All", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @GetMapping
    public ResponseEntity<Collection<AddressDTO>> findAll() {
        return ResponseEntity
                .ok()
                .body(addressService.findAll());
    }

    @Operation(summary = "Get by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable UUID id) {
        return ResponseEntity
                .ok()
                .body(addressService.findById(id));
    }
}