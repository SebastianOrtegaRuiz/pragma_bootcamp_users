package com.pragma.foodCourt.infraestructure.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data found for the requested petition", "Cellphone number is not valid");

    private final String message;
    private final String validMessage;

    ExceptionResponse(String message, String validMessage) {
        this.message = message;
        this.validMessage = validMessage;
    }

    public String getMessage() {
        return this.message;
    }

    public String getValidMessage() {
        return this.validMessage;
    }
}
