package com.app.hero.infrastructure.adapters;

import com.app.hero.domain.exceptions.HeroNotFoundException;
import com.app.hero.domain.models.HeroDTO;
import com.app.hero.domain.ports.infra.HeroDBPort;
import com.app.hero.infrastructure.mappers.HeroDBMapper;
import com.app.hero.infrastructure.repositories.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.app.hero.infrastructure.repositories.HeroRepository.Specs.byName;

@Service
@RequiredArgsConstructor
public class HeroDBAdapter implements HeroDBPort {
    private final HeroRepository heroRepository;
    private final HeroDBMapper heroDBMapper;

    @Override
    public Page<HeroDTO> findAllHeroes(Pageable pageable) {
        return heroRepository.findAll(pageable).map(heroDBMapper::toHeroDTO);
    }

    @Override
    public HeroDTO findHeroById(Long id) {
        return heroDBMapper.toHeroDTO(heroRepository.findById(id).orElseThrow(() -> new HeroNotFoundException("404", "Hero not found")));
    }

    @Override
    public Page<HeroDTO> findHeroes(String name, Pageable pageable) {
        return heroRepository.findAll(byName(name), pageable).map(heroDBMapper::toHeroDTO);
    }

    @Override
    public HeroDTO createHero(HeroDTO hero) {
        return heroDBMapper.toHeroDTO(heroRepository.save(heroDBMapper.toHeroMO(hero)));
    }

    @Override
    public HeroDTO updateHero(Long id, HeroDTO hero) {
        existsHero(id);
        return heroDBMapper.toHeroDTO(heroRepository.save(heroDBMapper.toHeroMO(hero)));
    }

    @Override
    public void deleteHero(Long id) {
        existsHero(id);
        heroRepository.deleteById(id);
    }

    private void existsHero(Long id) {
        if (!heroRepository.existsById(id)) {
            throw new HeroNotFoundException("404", "Hero not found");
        }
    }
}
