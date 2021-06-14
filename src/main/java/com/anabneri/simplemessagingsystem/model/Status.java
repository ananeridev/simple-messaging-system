package com.anabneri.simplemessagingsystem.model;


public class Status {

   private  String status;
   private  String message;

    public Status(final String status, final String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
