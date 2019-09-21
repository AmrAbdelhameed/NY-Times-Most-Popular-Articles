package com.example.nytimesmostpopulararticles.models.response;

import java.util.List;

public class ErrorBody {

    /**
     * status : ERROR
     * copyright : Copyright (c) 2019 The New York Times Company.  All Rights Reserved.
     * errors : ["Unknown GET command: viewed/0","Bad Request"]
     * results : []
     */

    private String status;
    private String copyright;
    private List<String> errors;
    private List<?> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<?> getResults() {
        return results;
    }

    public void setResults(List<?> results) {
        this.results = results;
    }
}
