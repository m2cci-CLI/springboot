package com.training.springcore.bigcorp.repository;


import com.training.springcore.bigcorp.model.Measure;
import org.springframework.stereotype.Repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MeasureDaoImpl implements MeasureDao {

    @PersistenceContext
    private EntityManager em;


    public void persist(Measure measure) {
        em.persist(measure);
    }


    public Measure findById(Long id) {
        return em.find(Measure.class, id);
    }


    @Override
    public List<Measure> findAll() {
        return em.createQuery("select c from Measure c",Measure.class).getResultList();
    }


    public void delete(Measure measure) {
        em.remove(measure);
    }
}
