package com.Investment_system.model;

public class Shareholder {
    int id;
    String name;
    String phone_number;
    String national_code;

    public Shareholder() {
    }

    public Shareholder(int id, String name, String phone_number, String national_code) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.national_code = national_code;
    }

    public Shareholder(String name, String phone_number, String national_code) {
        this.name = name;
        this.phone_number = phone_number;
        this.national_code = national_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getNational_code() {
        return national_code;
    }

    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }

    @Override
    public String toString() {
        return "Shareholder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", national_code='" + national_code + '\'' +
                '}';
    }
}
