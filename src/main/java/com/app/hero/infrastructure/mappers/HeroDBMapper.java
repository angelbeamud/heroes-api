package com.app.hero.infrastructure.mappers;

import com.app.hero.domain.models.HeroDTO;
import com.app.hero.infrastructure.models.HeroMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeroDBMapper {
    HeroDTO toHeroDTO(HeroMO heroMO);
    HeroMO toHeroMO(HeroDTO heroDTO);
}
