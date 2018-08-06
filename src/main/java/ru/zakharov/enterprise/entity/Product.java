package ru.zakharov.enterprise.entity;

import java.util.UUID;

public class Product {

    private String id = UUID.randomUUID().toString();

    private String name = "";

    private String shortDescription = "";

    private String fullDescription = "";

    private int price = 0;

    private String picFileName = "";

    public Product() {
    }

    public Product(String name, String shortDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
    }


    public Product(String name, String shortDescription,
                   String fullDescription, int price, String picFileName) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.price = price;
        this.picFileName = picFileName;
    }

    public String getName() {
        return this.name;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public String getPicFileName() {
        return picFileName;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
