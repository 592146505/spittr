package com.roamer.spittr.dao;

import com.roamer.spittr.pojo.Spitter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/31
 */
public class SpitteRepositoryImpl implements SpitterSweeper {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Spitter findByLastName(String lastName) {
        StringBuffer hql = new StringBuffer();
        hql.append("SELECT * FROM TBL_SPITTER s ");
        hql.append("WHERE s.lastName = :lastName ");
        return manager.createQuery(hql.toString(), Spitter.class).setParameter("lastName", lastName).getSingleResult();
    }
}
