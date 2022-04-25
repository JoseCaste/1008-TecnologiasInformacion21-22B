package com.informatica.formulariocontacto.model;


import java.io.Serializable;

public class Contacto implements Serializable {
    private String name;

    private String email;

    private String phone;

    private String birthday;

    private String contactDescription;

    public Contacto(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Contacto(String name, String email, String phone, String birthday, String contactDescription) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.contactDescription = contactDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getContactDescription() {
        return contactDescription;
    }

    public void setContactDescription(String contactDescription) {
        this.contactDescription = contactDescription;
    }
}
