package com.app.hero.application.api;

import com.app.hero.domain.models.HeroDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "heroes")
public interface HeroApi {
    @Operation(summary = "Find all heroes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HeroDTO.class)
                    )
            }),
            @ApiResponse(responseCode = "404", description = "Heroes not found", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<HeroDTO>> findAllHeroes(@PageableDefault Pageable pageable);

    @Operation(summary = "Find hero by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HeroDTO.class)
                    )
            }),
            @ApiResponse(responseCode = "404", description = "Hero not found", content = @Content)
    })
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HeroDTO> findHeroById(@PathVariable(name = "id") Long id);

    @Operation(summary = "Find hero by query param")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HeroDTO.class)
                    )
            }),
            @ApiResponse(responseCode = "404", description = "Heroes not found", content = @Content)
    })
    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<HeroDTO>> findHeroesByQueryParam(@RequestParam(name = "name", required = false) String name, @PageableDefault Pageable pageable);

    @Operation(summary = "Create hero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful operation", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HeroDTO.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HeroDTO> createHero(@RequestBody HeroDTO hero);

    @Operation(summary = "Update hero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HeroDTO.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
    })
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HeroDTO> updateHero(@PathVariable(name = "id") Long id, @RequestBody HeroDTO hero);

    @Operation(summary = "Delete hero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Hero not found")
    })
    @DeleteMapping(value = "{id}")
    ResponseEntity<Void> deleteHero(@PathVariable(name = "id") Long id);
}
