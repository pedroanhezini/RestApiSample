package br.com.pedroanhezini.api.repository;

import br.com.pedroanhezini.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
