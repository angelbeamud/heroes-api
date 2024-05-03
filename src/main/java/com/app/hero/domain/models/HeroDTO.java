package com.app.hero.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeroDTO {
    Long id;
    String name;
    String organization;
    Boolean active;
}
