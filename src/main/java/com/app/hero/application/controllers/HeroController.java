package com.app.hero.application.controllers;

import com.app.hero.application.api.HeroApi;
import com.app.hero.application.annotation.LogExecutionTime;
import com.app.hero.domain.models.HeroDTO;
import com.app.hero.domain.ports.app.HeroAppPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HeroController implements HeroApi {

    private final HeroAppPort heroAppPort;

    @Override
    @LogExecutionTime
    public ResponseEntity<List<HeroDTO>> findAllHeroes() {
        return ResponseEntity.ok(heroAppPort.findAllHeroes());
    }

    @Override
    @LogExecutionTime
    public ResponseEntity<HeroDTO> findHeroById(Long id) {
        return ResponseEntity.ok(heroAppPort.findHeroById(id));
    }

    @Override
    @LogExecutionTime
    public ResponseEntity<List<HeroDTO>> findHeroesByQueryParam(String name) {
        return ResponseEntity.ok(heroAppPort.findHeroes(name));
    }

    @Override
    @LogExecutionTime
    public ResponseEntity<HeroDTO> createHero(HeroDTO hero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(heroAppPort.createHero(hero));
    }

    @Override
    @LogExecutionTime
    public ResponseEntity<HeroDTO> updateHero(Long id, HeroDTO hero) {
        return ResponseEntity.ok(heroAppPort.updateHero(id, hero));
    }

    @Override
    @LogExecutionTime
    public ResponseEntity<Void> deleteHero(Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
