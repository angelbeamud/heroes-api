package com.app.hero.infrastructure.repositories;

import com.app.hero.infrastructure.models.HeroMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<HeroMO, Long> {
    List<HeroMO> findByNameContaining(String name);
}
