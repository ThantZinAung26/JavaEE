package ru.zakharov.enterprise.dao;


import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.entity.Product;
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

    public List<ShopOrder> getAllOrders() {
        Query query = entityManager.createQuery("SELECT o FROM ShopOrder o");
        List<ShopOrder> allOrders = query.getResultList();
        return allOrders;
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


    public void removeProductFromOrder(String orderId, Product product) {

        Query query = entityManager.createQuery("DELETE FROM ShopOrder o WHERE");



        ShopOrder shopOrder = entityManager.find(ShopOrder.class, orderId);

        List<Product> list = shopOrder.getProductsInOrder();
        list.remove(product);

        shopOrder.setProductsInOrder(list);

        entityManager.merge(shopOrder);
    }
}
