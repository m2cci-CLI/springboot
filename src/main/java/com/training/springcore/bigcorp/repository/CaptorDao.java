package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Captor;
import com.training.springcore.bigcorp.model.Site;

import java.util.List;

public interface CaptorDao extends CrudDao<Captor, String> {
    List<Captor> findBySiteId(String siteId);
}
