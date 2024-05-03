package com.example.testvelacorp.exception;


import com.example.testvelacorp.dto.response.IApiResponse;

public class HandleException  extends RuntimeException{
    protected String code;
    protected String message;
    protected String messageDescription;

    public HandleException() {
    }

    public HandleException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public HandleException(IApiResponse apiResponse) {
        this.code = apiResponse.getCode();
        this.message = apiResponse.getError();
    }

    public HandleException(String code, String message, String messageDescription) {
        super(message);
        this.messageDescription = messageDescription;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDescription() {
        return this.messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public String toString() {
        return "BaseException{code='" + this.code + "', message='" + this.message + "', messageDescription='" + this.messageDescription + "'}";
    }
}

