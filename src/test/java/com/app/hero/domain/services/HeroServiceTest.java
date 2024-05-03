package com.app.hero.domain.services;

import com.app.hero.domain.models.HeroDTO;
import com.app.hero.domain.ports.infra.HeroDBPort;
import com.app.hero.utils.HeroFaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroServiceTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    @Mock
    private HeroDBPort heroDBPort;
    private HeroService heroService;

    @BeforeEach
    void setUp() {
        heroService = new HeroService(heroDBPort);
    }

    @Test
    void should_find_all_heroes() {
        when(heroDBPort.findAllHeroes()).thenReturn(List.of(HeroFaker.getHeroDTO()));
        List<HeroDTO> heroes = heroService.findAllHeroes();
        assertNotNull(heroes);
        assertFalse(heroes.isEmpty());
    }

    @Test
    void should_find_hero_by_id() {
        when(heroDBPort.findHeroById(ID)).thenReturn(HeroFaker.getHeroDTO());
        HeroDTO hero = heroService.findHeroById(1L);
        assertNotNull(hero);
        assertEquals(ID, hero.getId());
    }

    @Test
    void should_find_heroes_by_name() {
        when(heroDBPort.findHeroes(NAME)).thenReturn(List.of(HeroFaker.getHeroDTO()));
        List<HeroDTO> heroes = heroService.findHeroes(NAME);
        assertNotNull(heroes);
        assertFalse(heroes.isEmpty());
    }

    @Test
    void should_create_hero() {
        HeroDTO heroToCreate = HeroFaker.getHeroDTO();
        when(heroDBPort.createHero(heroToCreate)).thenReturn(heroToCreate);
        HeroDTO createdHero = heroService.createHero(heroToCreate);
        assertNotNull(createdHero);
        assertEquals(heroToCreate.getName(), createdHero.getName());
    }

    @Test
    void should_update_hero() {
        HeroDTO updatedHero = HeroFaker.getHeroDTO();
        when(heroDBPort.updateHero(ID, updatedHero)).thenReturn(updatedHero);
        HeroDTO returnedHero = heroService.updateHero(ID, updatedHero);
        assertNotNull(returnedHero);
        assertEquals(updatedHero.getName(), returnedHero.getName());
    }

    @Test
    void should_delete_hero() {
        doNothing().when(heroDBPort).deleteHero(1L);
        assertDoesNotThrow(() -> heroService.deleteHero(1L));
    }
}
