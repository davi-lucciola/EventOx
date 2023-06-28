package br.com.eventox.application.controllers;

import br.com.eventox.domain.models.EventDO;
import br.com.eventox.domain.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<List<EventDO>> findAll() {
        return new ResponseEntity<>(service.findAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDO> detail(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(service.findEventById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody EventDO event) {
        service.createEvent(event);
        return new ResponseEntity<>(new Response(
                "EVENT_SAVE",
                "Evento criado com sucesso."
        ), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable Integer id, @RequestBody EventDO event) throws Exception {
        service.updateEvent(id, event);
        return new ResponseEntity<>(new Response(
                "EVENT_UPDATE",
                "Evento editado com sucesso."
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) throws Exception {
        service.deleteEvent(id);
        return new ResponseEntity<>(new Response(
                "EVENT_DELETE",
                "Evento removido com sucesso."
        ), HttpStatus.OK);
    }

}
