package com.example.app.interfaces;

public class Response {
    private String statusMessage;

    public Response(String msg) {
        this.statusMessage = msg;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}