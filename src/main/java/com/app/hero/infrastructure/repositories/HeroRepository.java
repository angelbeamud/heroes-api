package com.app.hero.infrastructure.repositories;

import com.app.hero.infrastructure.models.HeroMO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<HeroMO, Long>, JpaSpecificationExecutor<HeroMO> {
    interface Specs {
        static Specification<HeroMO> byName(String name) {
            return ((root, query, criteriaBuilder) -> {
                if (StringUtils.isEmpty(name)) {
                    return null;
                } else {
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
                }
            });
        }
    }
}
