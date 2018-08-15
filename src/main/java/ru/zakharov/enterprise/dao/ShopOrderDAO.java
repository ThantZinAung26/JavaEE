package ru.zakharov.enterprise.dao;



import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.entity.ShopOrder;


import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ShopOrderDAO extends AbstractDAO{

    public ShopOrder merge(ShopOrder shopOrder) {
        return entityManager.merge(shopOrder);
    }

    public List<ShopOrder> getAllOrders() {
        Query query = entityManager.createQuery("SELECT o FROM ShopOrder o");
        List<ShopOrder> allOrders = query.getResultList();
        return allOrders;
    }

    public void removeOrderById(String orderId) {
        ShopOrder shopOrder = entityManager.find(ShopOrder.class, orderId);
        entityManager.remove(shopOrder);
    }

    public List<Product> getProductsInOrderById(String orderId) {
        ShopOrder shopOrder = entityManager.find(ShopOrder.class, orderId);
        return shopOrder.getProductsInOrder();
    }
}
