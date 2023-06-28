package br.com.eventox.domain.services;

import br.com.eventox.application.exceptions.DomainException;
import br.com.eventox.application.exceptions.NotFoundException;
import br.com.eventox.domain.models.EventDO;
import br.com.eventox.infrastructure.database.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventDO> findAllEvents() {
        return eventRepository.findAll();
    }

    public EventDO findEventById(Integer id) throws NotFoundException {
        EventDO savedEvent = eventRepository.findById(id);
        if (savedEvent == null) {
            throw new NotFoundException("NOT_FOUND", "Evento não encontrado.");
        }

        return savedEvent;
    }

    public void createEvent(EventDO event) {
        eventRepository.save(event);
    }

    public void updateEvent(Integer id, EventDO event) throws Exception {
        EventDO savedEvent = findEventById(id);

        if (event.getCapacity() < savedEvent.getSold()) {
            throw new DomainException("INVALID_CAPACITY", "A capacidade não pode ser menor que a quantidade de ingressos vendidos");
        }

        event.setId(id);
        event.setSold(savedEvent.getSold());
        eventRepository.save(event);
    }

    public void deleteEvent(Integer id) throws Exception {
        this.findEventById(id);
        eventRepository.delete(id);
    }

}
