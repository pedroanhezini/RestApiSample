package br.com.pedroanhezini.api.controller;

import br.com.pedroanhezini.api.dto.PersonDTO;
import br.com.pedroanhezini.api.exception.PersonNotFoundException;
import br.com.pedroanhezini.api.facade.PersonFacade;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/people")
@AllArgsConstructor
public class PersonController {

    private final PersonFacade personFacade;

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable String id) throws PersonNotFoundException {
        return personFacade.findById(id);
    }

    @GetMapping
    public List<PersonDTO> findAll() {
        return personFacade.findAll();
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personFacade.create(personDTO);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable String id,
                            @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personFacade.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws PersonNotFoundException {
        personFacade.delete(id);
    }


}
