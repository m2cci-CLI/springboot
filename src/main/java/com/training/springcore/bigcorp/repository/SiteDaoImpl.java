package com.training.springcore.bigcorp.repository;




import com.training.springcore.bigcorp.model.Site;


import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class SiteDaoImpl implements SiteDao {


    @Override
    public void persist(Site element) {

    }

    @Override
    public Site findById(String s) {
        return null;
    }

    @Override
    public List<Site> findAll() {
        return null;
    }

    @Override
    public void delete(Site id) {

    }
}