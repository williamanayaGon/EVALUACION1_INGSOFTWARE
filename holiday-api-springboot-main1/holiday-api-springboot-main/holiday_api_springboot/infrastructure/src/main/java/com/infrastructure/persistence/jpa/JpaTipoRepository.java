package com.infrastructure.persistence.jpa;

import com.infrastructure.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaTipoRepository extends JpaRepository<TipoEntity, Long> {
    @Modifying
    @Query("DELETE FROM TipoEntity t WHERE t.id = :id")
    void deleteById(@Param("id") Long id);
}