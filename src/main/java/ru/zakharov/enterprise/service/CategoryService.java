package ru.zakharov.enterprise.service;

import ru.zakharov.enterprise.dao.CategoryDAO;
import ru.zakharov.enterprise.dto.CategoryDTO;
import ru.zakharov.enterprise.dto.ProductDTO;
import ru.zakharov.enterprise.entity.Category;
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
@Path("/CategoryService")
public class CategoryService {

    @Inject
    private CategoryDAO categoryDAO;


    /**
     * Создаем новую категорию товара
     *
     * @param name имя новой категории
     */
    @GET
    @WebMethod(operationName = "createCategory")
    @Path(value = "/createCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDTO> createCategory(@WebParam(name = "name", partName = "name")
                                      @QueryParam(value = "name")
                                              String name) {

        categoryDAO.createCategory(new Category(name));

        List<CategoryDTO> dtoList = new ArrayList<>();
        List<Category> categoryList = categoryDAO.getCategoryByName(name);
        CategoryDTO categoryDTO;

        for (Category index : categoryList) {
            categoryDTO = new CategoryDTO(index);
            dtoList.add(categoryDTO);
        }

        return dtoList;
    }

}
