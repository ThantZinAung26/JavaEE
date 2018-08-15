package ru.zakharov.enterprise.dao;

import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.logger.Logger;


import javax.ejb.Stateless;

import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.persistence.EntityGraph;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class CategoryDAO extends AbstractDAO {


    @Interceptors(Logger.class)
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

        EntityGraph graph = this.entityManager.getEntityGraph("graph.Category.products");

        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);


        return entityManager.find(Category.class, categoryId, hints);
    }

    public List<Category> getCategories() {
        Query query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
        return (List<Category>) query.getResultList();
    }

    @Interceptors(Logger.class)
    public void removeCategoryById(String categoryId) {
        Category category = entityManager.find(Category.class, categoryId);
        entityManager.remove(category);
    }
}
