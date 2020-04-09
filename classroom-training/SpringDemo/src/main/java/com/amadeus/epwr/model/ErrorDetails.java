package com.amadeus.epwr.model;

import java.util.List;

public class ErrorDetails {

    public ErrorDetails() {

    }

    public ErrorDetails(String status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    private String status;
    private List<String> errors;

    public String getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
