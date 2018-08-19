package ru.zakharov.enterprise.service;

import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.dto.ProductDTO;
import ru.zakharov.enterprise.entity.Product;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@WebService
@Path("ProductService")
public class ProductService {

    @Inject
    private ProductDAO productDAO;

    /**
     * Добавить новый товар в БД
     */
    @GET
    @Path("/createProduct")
    @WebMethod(operationName = "createProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public void createProduct() {
        productDAO.createProduct();
    }

    /**
     * Получить товар по Id
     *
     * @param productId Идентификатор продукта в БД
     */
    @GET
    @Path("/getProductById")
    @WebMethod(operationName = "getProductById")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductById(@QueryParam(value = "id")
                                     @WebParam(name = "id", partName = "id")
                                             String productId) {

        Product product = productDAO.getProductById(productId);
        if (product == null) return null;

        return new ProductDTO(product);
    }

    /**
     * Удалить товар по Id
     *
     * @param productId Идентификатор продукта в БД
     */
    @GET
    @Path("/removeProductById")
    @WebMethod(operationName = "removeProductById")
    @Produces(MediaType.APPLICATION_JSON)
    public void removeProductById(@QueryParam(value = "id")
                                  @WebParam(name = "id", partName = "id")
                                          String productId) {
        productDAO.removeProductById(productId);

    }

    /**
     * Получить список продуктов по имени продукта
     *
     * @param productName имя продукта
     * @return список продуктов, соответствующих введенному имени
     */
    @GET
    @Path("/getProductByName")
    @WebMethod(operationName = "getProductByName")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getProductByName(@QueryParam(value = "name")
                                             @WebParam(name = "name", partName = "name")
                                                     String productName) {

        List<Product> productList = productDAO.getProductByName(productName);
        List<ProductDTO> dtoList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product index : productList) {
            productDTO = new ProductDTO(index);
            dtoList.add(productDTO);
        }

        return dtoList;
    }

    /**
     * Получить список продуктов по категории товара
     *
     * @param categoryId id категории продуктов
     * @return список продуктов
     */
    @GET
    @Path("/getListProductByCategoryId")
    @WebMethod(operationName = "getListProductByCategoryId")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getListProductByCategoryId(@QueryParam(value = "id")
                                                       @WebParam(name = "id", partName = "id")
                                                               String categoryId) {

        List<ProductDTO> dtoList = new ArrayList<>();
        List<Product> productList = productDAO.getListProductByCategoryId(categoryId);
        ProductDTO productDTO;

        for (Product index : productList) {
            productDTO = new ProductDTO(index);
            dtoList.add(productDTO);
        }

        return dtoList;
    }

    /**
     * Получить список всех продуктов в БД
     *
     * @return списик всех продуктов
     */
    @GET
    @Path("/getListProduct")
    @WebMethod(operationName = "getListProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getListProduct() {

        List<ProductDTO> dtoList = new ArrayList<>();
        List<Product> productList = productDAO.getAllProducts();
        ProductDTO productDTO;

        for (Product index : productList) {
            productDTO = new ProductDTO(index);
            dtoList.add(productDTO);
        }

        return dtoList;
    }

    @GET
    @Path("/setCategory")
    @WebMethod(operationName = "setCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO setCategory(@WebParam(name = "productId", partName = "productId")
                                  @QueryParam(value = "productId")
                                          String productId,
                                  @WebParam(name = "categoryId", partName = "categoryId")
                                  @QueryParam(value = "categoryId")
                                          String categoryId) {
        productDAO.setCategoryForProduct(productId, categoryId);
        Product product = productDAO.getProductById(productId);
        if (product == null) return null;
        return new ProductDTO(product);
    }

}
