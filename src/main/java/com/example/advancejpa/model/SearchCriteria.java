package com.example.advancejpa.model;

import java.util.List;

public class SearchCriteria {

    private String key;
    private SearchOperation searchOperation;
    private boolean isOrOperation;
    private List<Object> arguments;

    public SearchCriteria(String key, SearchOperation searchOperation, boolean isOrOperation, List<Object> arguments) {
        this.key=key;
        this.searchOperation=searchOperation;
        this.isOrOperation=isOrOperation;
        this.arguments=arguments;
    }

    public enum SearchOperation {

        EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, LIKE, STARTS_WITH, IN;

        public static SearchOperation getSearchOperation(final char input)
        {
            switch (input) {
                case ':': return EQUALITY;
                case '!': return NEGATION;
                case '>': return GREATER_THAN;
                case '<': return LESS_THAN;
                case '~': return LIKE;
                default: return null;
            }
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SearchOperation getSearchOperation() {
        return searchOperation;
    }

    public void setSearchOperation(SearchOperation searchOperation) {
        this.searchOperation = searchOperation;
    }

    public boolean isOrOperation() {
        return isOrOperation;
    }

    public void setOrOperation(boolean orOperation) {
        isOrOperation = orOperation;
    }

    public List<Object> getArguments() {
        return arguments;
    }

    public void setArguments(List<Object> arguments) {
        this.arguments = arguments;
    }
}
