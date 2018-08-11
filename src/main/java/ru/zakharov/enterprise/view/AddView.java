package ru.zakharov.enterprise.view;

import com.sun.faces.application.ApplicationAssociate;
import org.primefaces.event.RowEditEvent;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.service.ProductService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@ManagedBean(name="dtAddRowView")
@ApplicationScoped
public class AddView implements Serializable {

    private Collection<Product> products1;

    @ManagedProperty("#{productService}")
    private ProductService service;

    @PostConstruct
    public void init() {
        products1 = service.getProducts();
    }

    public Collection<Product> getProducts1() {
        return products1;
    }

    public List<String> getProductsNames() {
        return service.getProductsNames();
    }

    public List<String> getProductsShortDesc() {
        return service.getProductsShortDesc();
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public void onRowEdit(RowEditEvent event) {

        Product editedProduct = (Product) event.getObject();
        service.mergeProduct(editedProduct.getId(), editedProduct);

        FacesMessage msg = new FacesMessage("Product Edited", editedProduct.getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        Product editedProduct = (Product) event.getObject();
        FacesMessage msg = new FacesMessage("Edit Cancelled", editedProduct.getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new car to the table:
        Product productToAdd = service.createProduct();

        products1.add(productToAdd);
        service.addProduct(productToAdd);

        FacesMessage msg = new FacesMessage("New Product added", productToAdd.getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
