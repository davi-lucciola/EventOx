package br.com.eventox.infrastructure.database.repositories.interfaces;

import br.com.eventox.infrastructure.database.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventJpaRepository extends JpaRepository<EventEntity, Integer> {
}
