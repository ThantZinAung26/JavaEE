package ru.zakharov.enterprise.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class AbstractDAO {

    public static final String PERSISTENCE = "MySqlDS";

    @PersistenceContext(unitName = PERSISTENCE)
    protected EntityManager entityManager;



}
