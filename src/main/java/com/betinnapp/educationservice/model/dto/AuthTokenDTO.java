package com.betinnapp.educationservice.model.dto;

import java.util.UUID;

public class AuthTokenDTO {

    private UUID token;

    public UUID get() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
