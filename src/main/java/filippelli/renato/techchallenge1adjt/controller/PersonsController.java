package filippelli.renato.techchallenge1adjt.controller;

import filippelli.renato.techchallenge1adjt.dto.PersonRequest;
import filippelli.renato.techchallenge1adjt.dto.PersonResponse;
import filippelli.renato.techchallenge1adjt.service.PersonService;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/persons", produces = {"application/json"})
@Tag(name = "persons")
public class PersonsController {

    @Autowired
    private PersonService service;

    @Operation(summary = "Create new person", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @PostMapping
    public ResponseEntity<PersonResponse> save(@RequestBody @Valid PersonRequest dto) {
        var personSaved = service.save(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand((personSaved.getId()))
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(personSaved);
    }

    @Operation(summary = "List all persons", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @GetMapping
    public ResponseEntity<Collection<PersonResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(service.findAll());
    }

    @Operation(summary = "List one person by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = DefaultError.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable UUID id) {
        return ResponseEntity
                .ok()
                .body(service.findById(id));
    }
}
