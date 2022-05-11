package com.example.happytours;

public class modelClass {

    int photo;
    String city;
    String phone;
    String name;

    public modelClass(int photo, String city, String phone, String name) {
        this.photo = photo;
        this.city = city;
        this.phone = phone;
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }
    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {

        this.name = name;
    }
}
