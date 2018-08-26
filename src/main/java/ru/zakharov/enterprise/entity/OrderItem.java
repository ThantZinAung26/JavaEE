package ru.zakharov.enterprise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem extends AbstractEntity{

    public OrderItem() {
    }

    @ManyToOne
    private Product product;

    @ManyToOne
    private ShopOrder shopOrder;

    @Column
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShopOrder getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(ShopOrder shopOrder) {
        this.shopOrder = shopOrder;
    }
}
