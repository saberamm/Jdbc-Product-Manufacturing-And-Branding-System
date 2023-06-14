package com.Investment_system.model;

import java.sql.Date;

public class Product {
    int id;
    String name;
    Date create_date;
    int category_id;
    int brand_id;

    public Product() {
    }

    public Product(String name, Date create_date) {
        this.name = name;
        this.create_date = create_date;
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_date=" + create_date +
                ", category_id=" + category_id +
                ", brand_id=" + brand_id +
                '}';
    }
}
