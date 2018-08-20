package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.CategoryDAO;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.dao.ShopOrderDAO;
import ru.zakharov.enterprise.entity.OrderItem;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.entity.ShopOrder;
import ru.zakharov.enterprise.logger.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@SessionScoped
public class CartListController {

    @Inject
    private ShopOrderDAO shopOrderDAO;

    @Inject
    private ProductDAO productDAO;

    @Inject
    private CategoryDAO categoryDAO;

    private HttpSession currentSession = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);

    private String orderId;

    private List<OrderItem> itemsList = new LinkedList<>();

    @Interceptors(Logger.class)
    public List<OrderItem> getOrderItems() {
        orderId = (String) currentSession.getAttribute(FieldConsts.ORDER_ID);
        itemsList = shopOrderDAO.getOrderById(orderId).getItems();
        return itemsList;
    }

    public void removeProduct(OrderItem orderItem) {

        ShopOrder shopOrder = shopOrderDAO.getOrderById(orderId);
        int index = itemsList.indexOf(orderItem);
        int quantity = orderItem.getQuantity();
        if (quantity == 1) {
            itemsList.remove(orderItem);
        } else if (quantity > 1) {
            itemsList.get(index).setQuantity(--quantity);
        }

        shopOrder.setItems(itemsList);
        shopOrderDAO.merge(shopOrder);

    }

    public List<OrderItem> getProducts() {
        orderId = (String) currentSession.getAttribute(FieldConsts.ORDER_ID);
        itemsList = shopOrderDAO.getOrderById(orderId).getItems();
        return itemsList;
    }

}
