package ru.zakharov.enterprise.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product extends AbstractEntity {

    private String fullDescription = "";

    private int price = 0;

    private String pictureFileName = "";

    @ManyToOne
    private Category category = null;

    public Product() {
    }

    public Product(String name, String shortDescription) {
        setName(name);
        setShortDescription(shortDescription);
    }

    public Product(String name, String shortDescription,
                   String fullDescription, int price, String pictureFileName) {
        setName(name);
        setShortDescription(shortDescription);
        this.fullDescription = fullDescription;
        this.price = price;
        this.pictureFileName = pictureFileName;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public String getPictureFileName() {
        return pictureFileName;
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

    public void setPictureFileName(String picFileName) {
        this.pictureFileName = picFileName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
