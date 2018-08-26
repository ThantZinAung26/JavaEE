package ru.zakharov.enterprise.dto;


import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.entity.Product;

import java.util.Date;

public class ProductDTO {

    private String id;

    private String name;

    private String shortDescription;

    private Date creationDate;

    private String categoryId;

    private String fullDescription;

    private int price;

    private String pictureFileName;

    public ProductDTO(Product product) {
        if (product == null) return;
        this.id = product.getId();
        this.name = product.getName();
        this.shortDescription = product.getShortDescription();
        this.creationDate = product.getCreationDate();
        Category category = product.getCategory();
        if (category == null) categoryId = "";
        else
            this.categoryId = category.getId();
        this.fullDescription = product.getFullDescription();
        this.price = product.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public ProductDTO() {

    }

}
