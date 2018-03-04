package com.TrictSystem.Beans;

import java.io.Serializable;

/**
 * Created by smile_raccoon on 2018/1/16.
 */

public class Login_Error implements Serializable {

    private String message;
    private String next;
    private String response;
    private String error;
    private Error_data data;
    private class Error_data implements Serializable{}

    @Override
    public String toString() {
        return "Login_Error{" +
                "message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Error_data getData() {
        return data;
    }

    public void setData(Error_data data) {
        this.data = data;
    }
}
