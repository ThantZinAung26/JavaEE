package ru.zakharov.enterprise.dao;

import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.entity.ShopOrder;


import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CategoryDAO extends AbstractDAO {

    public Category merge(Category category) {
        return entityManager.merge(category);
    }

    public List<String> getCategoriesNames() {
        Query query = entityManager.createQuery("SELECT c.name FROM Category c");
        List<String> list = query.getResultList();
        return list;
    }

    public List<String> getCategoriesIds() {
        Query query = entityManager.createQuery("SELECT c.id FROM Category c");
        List<String> list = query.getResultList();
        return list;
    }

    public Category getCategoryById(String categoryId) {
        Category category = entityManager.find(Category.class, categoryId);
        return category;
    }

    public List<Category> getCategories() {
        Query query = entityManager.createQuery("SELECT c FROM Category c",Category.class);
        List<Category> list = query.getResultList();
        return list;
    }

    public void removeCategoryById(String categoryId) {
        Category category = entityManager.find(Category.class, categoryId);
        entityManager.remove(category);
    }
}
