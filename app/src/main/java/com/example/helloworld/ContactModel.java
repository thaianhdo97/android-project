package com.example.helloworld;

public class ContactModel {
    private String name;
    private String phone;
    private int avatar;

    public ContactModel(String name, String phone, int avatar) {
        this.name = name;
        this.phone = phone;
        this.avatar = avatar;
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
