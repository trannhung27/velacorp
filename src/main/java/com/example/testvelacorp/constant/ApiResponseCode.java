package com.example.testvelacorp.constant;

import com.example.testvelacorp.dto.response.IApiResponse;

public enum ApiResponseCode implements IApiResponse {
    BAD_REQUEST("400", "BAD_REQUEST"),
    ENTITY_NOT_FOUND("400", "ENTITY_NOT_FOUND"),
    ;

    private String code;
    private String error;

    private ApiResponseCode(String code, String error) {
        this.code = code;
        this.error = error;
    }

    public String getCode() {
        return this.code;
    }

    public String getError() {
        return this.error;
    }
}
