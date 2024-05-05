package com.app.hero.domain.ports.app;

import com.app.hero.domain.models.HeroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HeroAppPort {
    Page<HeroDTO> findAllHeroes(Pageable pageable);

    HeroDTO findHeroById(Long id);

    Page<HeroDTO> findHeroes(String name, Pageable pageable);

    HeroDTO createHero(HeroDTO hero);

    HeroDTO updateHero(Long id, HeroDTO hero);

    void deleteHero(Long id);
}
