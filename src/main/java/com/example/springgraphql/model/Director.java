package com.example.springgraphql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private String birthDate;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Movie> movies;

    public Director(Integer id) {
        this.id = id;
    }

    public Director(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
