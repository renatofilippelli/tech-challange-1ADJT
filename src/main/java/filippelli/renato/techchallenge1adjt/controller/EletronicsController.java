package filippelli.renato.techchallenge1adjt.controller;

import filippelli.renato.techchallenge1adjt.dto.EletronicRequest;
import filippelli.renato.techchallenge1adjt.dto.EletronicResponse;
import filippelli.renato.techchallenge1adjt.service.EletronicService;
import filippelli.renato.techchallenge1adjt.service.exception.DefaultError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/eletronics", produces = {"application/json"})
@Tag(name = "eletronics")
public class EletronicsController {

    @Autowired
    private EletronicService service;

    @Operation(summary = "Create new eletronic", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @PostMapping
    public ResponseEntity<EletronicResponse> save(@RequestBody @Valid EletronicRequest dto) {
        var eletronicSaved = service.save(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand((eletronicSaved.getId()))
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(eletronicSaved);
    }

    @Operation(summary = "List all eletronics", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @GetMapping
    public ResponseEntity<Collection<EletronicResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(service.findAll());
    }

    @Operation(summary = "List one eletronic by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<EletronicResponse> findById(@PathVariable UUID id) {
        return ResponseEntity
                .ok()
                .body(service.findById(id));
    }
}
