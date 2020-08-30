package br.com.pedroanhezini.api.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "PERSON")
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Column(nullable = false)
    private String city;

    public void update(Person from) {
        this.name = from.getName();
        this.lastName = from.getLastName();
        this.age = from.getAge();
        this.genre = from.getGenre();
        this.city = from.getCity();
    }


}
