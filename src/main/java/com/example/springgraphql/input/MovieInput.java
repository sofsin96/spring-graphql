package com.example.springgraphql.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieInput {
    private String title;
    private String genres;
    private String runtime;
    private Integer certificate;
    private Integer directorId;
    private String language;
    private String releaseDate;
}
