package com.app.hero.infrastructure.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hero")
public class HeroMO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hero_id_seq")
    @SequenceGenerator(name = "hero_id_seq", sequenceName = "hero_id_seq", allocationSize = 1)
    Long id;
    String name;
    String organization;
    Boolean active;
}
