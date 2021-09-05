package com.example.helloworld;

public class ContactModel {
    private String name;
    private String phone;
    private int avatar;

    public ContactModel(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.avatar = image;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAvatar() {
        return avatar;
    }
}
