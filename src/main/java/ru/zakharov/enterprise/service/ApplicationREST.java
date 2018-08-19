package ru.zakharov.enterprise.service;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ApplicationREST extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(SimpleServiceREST.class);
        set.add(CategoryService.class);
        set.add(ProductService.class);
        return set;
    }
}
