package com.app.hero.infrastructure.adapters;

import com.app.hero.domain.models.HeroDTO;
import com.app.hero.domain.ports.infra.HeroDBPort;
import com.app.hero.infrastructure.mappers.HeroDBMapper;
import com.app.hero.infrastructure.repositories.HeroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroDBAdapter implements HeroDBPort {
    private final HeroRepository heroRepository;
    private final HeroDBMapper heroDBMapper;

    @Override
    public List<HeroDTO> findAllHeroes() {
        return heroRepository.findAll().stream().map(heroDBMapper::toHeroDTO).collect(Collectors.toList());
    }

    @Override
    public HeroDTO findHeroById(Long id) {
        return heroDBMapper.toHeroDTO(heroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hero not found")));
    }

    @Override
    public List<HeroDTO> findHeroes(String name) {
        return heroRepository.findByNameContaining(name).stream().map(heroDBMapper::toHeroDTO).collect(Collectors.toList());
    }

    @Override
    public HeroDTO createHero(HeroDTO hero) {
        return heroDBMapper.toHeroDTO(heroRepository.save(heroDBMapper.toHeroMO(hero)));
    }

    @Override
    public HeroDTO updateHero(Long id, HeroDTO hero) {
        heroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hero not found"));
        return heroDBMapper.toHeroDTO(heroRepository.save(heroDBMapper.toHeroMO(hero)));
    }

    @Override
    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }
}
