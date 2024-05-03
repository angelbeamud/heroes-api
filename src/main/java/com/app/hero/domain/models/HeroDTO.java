package com.app.hero.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeroDTO {
    @JsonProperty("id")
    Long id;
    @NonNull
    @JsonProperty("name")
    String name;
    @NonNull
    @JsonProperty("organization")
    String organization;
    @NonNull
    @JsonProperty("active")
    Boolean active;
}
