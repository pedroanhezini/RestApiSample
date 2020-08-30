package br.com.pedroanhezini.api.service;

import br.com.pedroanhezini.api.exception.PersonNotFoundException;
import br.com.pedroanhezini.api.model.Person;
import br.com.pedroanhezini.api.repository.PersonRepository;
import br.com.pedroanhezini.api.utils.NumberUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.pedroanhezini.api.utils.NumberUtils.toInteger;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person findById(String id) throws PersonNotFoundException {
        return Optional.ofNullable(toInteger(id, null))
                .flatMap(personRepository::findById)
                .orElseThrow(() -> new PersonNotFoundException("person not found"));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(String id, Person person) throws PersonNotFoundException {
        var foundPerson = findById(id);
        foundPerson.update(person);
        return personRepository.save(foundPerson);
    }

    public void delete(String id) throws PersonNotFoundException {
        var foundPerson = findById(id);
        personRepository.delete(foundPerson);
    }

}
