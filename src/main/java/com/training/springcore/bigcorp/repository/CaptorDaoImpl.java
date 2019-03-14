package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Captor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CaptorDaoImpl implements CaptorDao {

    @PersistenceContext
    private EntityManager em;
    @Override
    public void persist(Captor captor) {
        em.persist(captor);
    }
    @Override
    public Captor findById(String id) {
        return em.find(Captor.class, id);
    }
    @Override
    public List<Captor> findAll() {
        return em.createQuery("select c from Captor c",
                Captor.class)
                .getResultList();
    }

    @Override
    public void delete(Captor captor) {
        em.remove(captor);
    }

    @Override
    public List<Captor> findBySiteId(String siteId) {
        return null;
    }

    @Override
    public void deleteById(String id) {

        em.remove(findById("id"));

    }


}
