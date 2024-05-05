package com.app.hero.infrastructure.adapters;

import com.app.hero.domain.models.HeroDTO;
import com.app.hero.infrastructure.mappers.HeroDBMapper;
import com.app.hero.infrastructure.repositories.HeroRepository;
import com.app.hero.utils.HeroFaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroDBAdapterTest {
    private static final Long ID = 1L;
    private static final String NAME = "name";
    @Mock
    private HeroRepository heroRepository;
    private HeroDBMapper heroDBMapper;
    private HeroDBAdapter heroDBAdapter;

    @BeforeEach
    void setUp() {
        heroDBMapper = Mappers.getMapper(HeroDBMapper.class);
        heroDBAdapter = new HeroDBAdapter(heroRepository, heroDBMapper);
    }

    @Test
    void should_find_all_heroes() {
        when(heroRepository.findAll()).thenReturn(List.of(HeroFaker.getHeroMO()));
        List<HeroDTO> heroes = heroDBAdapter.findAllHeroes();
        assertNotNull(heroes);
        assertFalse(heroes.isEmpty());
    }
}
