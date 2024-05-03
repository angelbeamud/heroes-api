package com.app.hero.domain.ports.app;

import com.app.hero.domain.models.HeroDTO;

import java.util.List;

public interface HeroAppPort {
    List<HeroDTO> findAllHeroes();

    HeroDTO findHeroById(Long id);

    List<HeroDTO> findHeroes(String name);

    HeroDTO createHero(HeroDTO hero);

    HeroDTO updateHero(Long id, HeroDTO hero);

    void deleteHero(Long id);
}
