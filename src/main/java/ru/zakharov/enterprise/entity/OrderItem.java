package ru.zakharov.enterprise.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;



@Entity
public class OrderItem extends AbstractEntity{

    public OrderItem() {

    }

    @ManyToOne
    private Product product;

    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        setId(product.getId());
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
