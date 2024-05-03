package com.app.hero.application.controllers;

import com.app.hero.domain.services.HeroService;
import com.app.hero.utils.HeroFaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroControllerTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    @Mock
    private HeroService heroService;
    private HeroController heroController;

    @BeforeEach
    void setUp() {
        heroController = new HeroController(heroService);
    }

    @Test
    void should_find_all_heroes() {
        when(heroService.findAllHeroes()).thenReturn(List.of(HeroFaker.getHeroDTO()));
        var response = heroController.findAllHeroes();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void should_find_hero_by_id() {
        when(heroService.findHeroById(ID)).thenReturn(HeroFaker.getHeroDTO());
        var response = heroController.findHeroById(ID);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void should_find_heroes_by_query_param() {
        when(heroService.findHeroes(NAME)).thenReturn(List.of(HeroFaker.getHeroDTO()));
        var response = heroController.findHeroesByQueryParam(NAME);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void should_create_hero() {
        when(heroService.createHero(HeroFaker.getHeroDTO())).thenReturn(HeroFaker.getHeroDTO());
        var response = heroController.createHero(HeroFaker.getHeroDTO());
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void should_update_hero() {
        when(heroService.updateHero(ID, HeroFaker.getHeroDTO())).thenReturn(HeroFaker.getHeroDTO());
        var response = heroController.updateHero(ID, HeroFaker.getHeroDTO());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void should_delete_hero() {
        doNothing().when(heroService).deleteHero(ID);
        var response = heroController.deleteHero(ID);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
