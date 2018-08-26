package ru.zakharov.enterprise.dao;


import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.entity.OrderItem;

import ru.zakharov.enterprise.entity.ShopOrder;
import ru.zakharov.enterprise.logger.Logger;


import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityGraph;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class ShopOrderDAO extends AbstractDAO {

    @Interceptors(Logger.class)
    public ShopOrder merge(ShopOrder shopOrder) {
        return entityManager.merge(shopOrder);
    }

    @Interceptors(Logger.class)
    public OrderItem merge(OrderItem orderItem) {
        return entityManager.merge(orderItem);
    }

    public List<ShopOrder> getAllOrders() {
        Query query = entityManager.createQuery("SELECT o FROM ShopOrder o",ShopOrder.class);
        return (List<ShopOrder>) query.getResultList();
    }

    public List<OrderItem> getItem(String orderId, String productId) {
        Query query = entityManager.createQuery("SELECT o FROM OrderItem o WHERE o.shopOrder.id =:orderId " +
                "AND o.product.id =:productId");
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);
        List<OrderItem> orderItems = query.getResultList();
        if (orderItems == null) return null;
        return orderItems;
    }

    @Interceptors(Logger.class)
    public void removeOrderById(String orderId) {
        ShopOrder shopOrder = entityManager.find(ShopOrder.class, orderId);
        entityManager.remove(shopOrder);
    }

    public ShopOrder getOrderById(String orderId) {
        EntityGraph graph = this.entityManager.getEntityGraph("graph.ShopOrder.products");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);
        return entityManager.find(ShopOrder.class, orderId, hints);
    }
}
