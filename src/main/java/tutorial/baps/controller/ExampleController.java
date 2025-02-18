package tutorial.baps.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tutorial.baps.request.TalentRequest;
import tutorial.baps.response.TalentResponse;
import tutorial.baps.service.ExampleService;

/**
 * FIXME: Delete this later
 */
@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @Operation(summary = "Get all the talents")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all the talents")
    })
    @GetMapping
    public List<TalentResponse> getAll() {
        return exampleService.getAll();
    }

    @Operation(summary = "Get all the talents")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all the talents")
    })
    @GetMapping("/{id}")
    public TalentResponse getOne(@PathVariable Long id) {
        return exampleService.getOne(id);
    }

    @Operation(summary = "Create a new talent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Talent created successfully"),
            @ApiResponse(responseCode = "400", description = "Could not create talent")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TalentResponse create(@Valid @RequestBody TalentRequest talentRequest) {
        return exampleService.create(talentRequest);
    }

    @Operation(summary = "Update an existing talent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Talent updated successfully"),
            @ApiResponse(responseCode = "400", description = "Could not update talent")
    })
    @PatchMapping("/{id}")
    public TalentResponse update(@PathVariable Long id, @Valid @RequestBody TalentRequest talentRequest) {
        return exampleService.update(id, talentRequest);
    }

    @Operation(summary = "Switch a talent's activation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Talent activated/deactivated successfully"),
            @ApiResponse(responseCode = "400", description = "Could not activate/deactivate talent")
    })
    @PutMapping("/{id}/activation")
    public TalentResponse activation(@PathVariable Long id) {
        return exampleService.activation(id);
    }

    @Operation(summary = "Delete an existing talent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Talent deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Could not delete talent")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exampleService.delete(id);
    }
}
