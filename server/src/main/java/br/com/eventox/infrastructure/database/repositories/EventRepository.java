package br.com.eventox.infrastructure.database.repositories;

import br.com.eventox.domain.models.EventDO;
import br.com.eventox.infrastructure.database.converters.EventConverter;
import br.com.eventox.infrastructure.database.entities.EventEntity;
import br.com.eventox.infrastructure.database.repositories.interfaces.EventJpaRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    @Autowired
    private EventJpaRepository eventJpaRepository;

    public List<EventDO> findAll() {
        return eventJpaRepository.findAll().stream().map(EventConverter::converter).toList();
    }

    public EventDO findById(Integer id) {
        return eventJpaRepository.findById(id).map(EventConverter::converter).orElseGet(() -> null);
    }

    public EventDO save(EventDO domain) {
        return EventConverter.converter(eventJpaRepository
                .saveAndFlush(EventConverter.converter(domain)));
    }

    public void delete(Integer id) {
        eventJpaRepository.deleteById(id);
    }
}
