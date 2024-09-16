package com.commerce.error;

public abstract class CommerceError extends RuntimeException {
    private String mensaje;

    public CommerceError(String message) {
        this.mensaje = message;
    }

    public String getMessage() {
        return mensaje;
    }
}

