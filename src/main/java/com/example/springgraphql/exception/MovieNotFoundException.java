package com.example.springgraphql.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class MovieNotFoundException extends RuntimeException implements GraphQLError {

    public MovieNotFoundException(Integer id) {
        super("Movie with id " + id + " not found.");
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
