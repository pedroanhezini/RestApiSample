package br.com.pedroanhezini.api.facade;

import br.com.pedroanhezini.api.dto.PersonDTO;
import br.com.pedroanhezini.api.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    PersonDTO toPersonDto(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .city(person.getCity())
                .genre(person.getGenre())
                .build();
    }

    Person toPerson(PersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .lastName(personDTO.getLastName())
                .age(personDTO.getAge())
                .city(personDTO.getCity())
                .genre(personDTO.getGenre())
                .build();
    }

}
