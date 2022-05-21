package com.example.springgraphql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String genres;
    private String runtime;
    private Integer certificate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", nullable = false, updatable = false)
    private Director director;
    private String language;

    @Column(name = "release_date")
    private String releaseDate;

    public Movie(String title, String genres, String runtime, Integer certificate, Director director, String language, String releaseDate) {
        this.title = title;
        this.genres = genres;
        this.runtime = runtime;
        this.certificate = certificate;
        this.director = director;
        this.language = language;
        this.releaseDate = releaseDate;
    }
}
