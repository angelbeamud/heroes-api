package com.app.hero.domain.services;

import com.app.hero.domain.models.HeroDTO;
import com.app.hero.domain.ports.app.HeroAppPort;
import com.app.hero.domain.ports.infra.HeroDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService implements HeroAppPort {
    private final HeroDBPort heroDBPort;

    @Override
    public Page<HeroDTO> findAllHeroes(Pageable pageable) {
        return heroDBPort.findAllHeroes(pageable);
    }

    @Override
    public HeroDTO findHeroById(Long id) {
        return heroDBPort.findHeroById(id);
    }

    @Override
    public Page<HeroDTO> findHeroes(String name, Pageable pageable) {
        return heroDBPort.findHeroes(name, pageable);
    }

    @Override
    public HeroDTO createHero(HeroDTO hero) {
        return heroDBPort.createHero(hero);
    }

    @Override
    public HeroDTO updateHero(Long id, HeroDTO hero) {
        return heroDBPort.updateHero(id, hero);
    }

    @Override
    public void deleteHero(Long id) {
        heroDBPort.deleteHero(id);
    }
}
