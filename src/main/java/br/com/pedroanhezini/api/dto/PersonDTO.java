package br.com.pedroanhezini.api.dto;

import br.com.pedroanhezini.api.model.Genre;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Integer id;

    private String name;

    private String lastName;

    private Integer age;

    private Genre genre;

    private String city;


}

