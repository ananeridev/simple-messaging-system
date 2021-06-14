package com.anabneri.simplemessagingsystem.model;


import java.io.Serializable;

public class Messaging implements Serializable {

    private static final long serialVersionUID = 1L;

   private  String namePerson;
   private  String message;
   private boolean seen;

    public Messaging(final String namePerson, final String message, final boolean seen) {
        this.namePerson = namePerson;
        this.message = message;
        this.seen = seen;
    }


    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(final String namePerson) {
        this.namePerson = namePerson;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(final boolean seen) {
        this.seen = seen;
    }

}
