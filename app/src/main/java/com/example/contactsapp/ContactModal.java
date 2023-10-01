package com.example.contactsapp;

public class ContactModal {

    private String name;
    private String surname;
    private String emailAddress;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactModal(String name,
                        String surname,
                        String emailAddress) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
    }

}
