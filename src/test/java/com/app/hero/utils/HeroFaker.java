package com.app.hero.utils;

import com.app.hero.domain.models.HeroDTO;
import com.app.hero.infrastructure.models.HeroMO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HeroFaker {
    public static HeroDTO getHeroDTO() {
        return HeroDTO
                .builder()
                .id(1L)
                .name("test controller")
                .organization("test controller")
                .active(true)
                .build();
    }

    public static HeroMO getHeroMO() {
        return HeroMO
                .builder()
                .id(1L)
                .name("test controller")
                .organization("test controller")
                .active(true)
                .build();
    }
}
