package ru.zakharov.enterprise.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product extends AbstractEntity {

    private String fullDescription = "";

    private int price = 0;

    private String picFileName = "";

    @ManyToOne
    private Category category = null;

    public Product() {

    }

    public Product(String name, String shortDescription) {
        setName(name);
        setShortDescription(shortDescription);
    }

    public Product(String name, String shortDescription,
                   String fullDescription, int price, String picFileName) {
        setName(name);
        setShortDescription(shortDescription);
        this.fullDescription = fullDescription;
        this.price = price;
        this.picFileName = picFileName;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public String getPicFileName() {
        return picFileName;
    }

    public int getPrice() {
        return price;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
