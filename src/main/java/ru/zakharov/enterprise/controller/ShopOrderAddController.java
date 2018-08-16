package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.dao.ShopOrderDAO;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.entity.ShopOrder;
import ru.zakharov.enterprise.logger.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
@ManagedBean
public class ShopOrderAddController {

    @Inject
    private ShopOrderDAO shopOrderDAO;

    @Inject
    private ProductDAO productDAO;

    private HttpSession currentSession = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);


    private ShopOrder shopOrder = new ShopOrder();
    private List<Product> list = new LinkedList<>();


    private String name = null;

    private String fio = null;

    private String address = null;

    private String shortDescription = null;

    private Date creationDate = null;

    private int quantity;

    @Interceptors(Logger.class)
    public void init(HttpSession session) {
        currentSession = session;
        currentSession.setAttribute(FieldConsts.ORDER_ID, shopOrder.getId());
        shopOrder.setProductsInOrder(list);
        shopOrder.setName(name);
        shopOrder.setFio(fio);
        shopOrder.setAddress(address);
        shopOrder.setCreationDate(new Date());
    }


//    @Interceptors(Logger.class)
//    public String saveShopOrder() {
//
//
/////*        //shopOrder.setId(currentSession.getId());
////        //shopOrder.setProductsInOrder(list);
////        shopOrder.setName(name);
////        shopOrder.setFio(fio);
////        shopOrder.setAddress(address);
////        shopOrder.setCreationDate(new Date());
////        shopOrderDAO.merge(shopOrder);
////
////        return "cart-list";*/
//    }


    @Interceptors(Logger.class)
    public void addProductToOrder(Product product) {
        list.add(product);
        shopOrder.setProductsInOrder(list);
        shopOrderDAO.merge(shopOrder);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

}
