package com.example.springgraphql.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQLExceptionHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getNested).collect(Collectors.toList());
    }

    public GraphQLError getNested(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching exception) {
            if (exception.getException() instanceof GraphQLError) {
                return (GraphQLError) exception.getException();
            }
        }
        return error;
    }
}
