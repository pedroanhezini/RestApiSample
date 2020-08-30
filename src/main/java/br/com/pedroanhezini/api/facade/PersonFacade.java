package br.com.pedroanhezini.api.facade;

import br.com.pedroanhezini.api.dto.PersonDTO;
import br.com.pedroanhezini.api.exception.PersonNotFoundException;
import br.com.pedroanhezini.api.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonFacade {

    private final PersonService personService;

    private final PersonConverter personConverter;

    public PersonDTO findById(String id) throws PersonNotFoundException {
        return personConverter.toPersonDto(personService.findById(id));
    }

    public List<PersonDTO> findAll() {
        return personService.findAll()
                .stream()
                .map(personConverter::toPersonDto)
                .collect(Collectors.toList());
    }

    public PersonDTO create(PersonDTO personDTO) {
        var savedPerson = personService.create(personConverter.toPerson(personDTO));
        return personConverter.toPersonDto(savedPerson);
    }

    public PersonDTO update(String id, PersonDTO personDTO) throws PersonNotFoundException {
        var savedPerson = personService.update(id, personConverter.toPerson(personDTO));
        return personConverter.toPersonDto(savedPerson);
    }

    public void delete(String id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
