package com.training.springcore.bigcorp.epository;

import com.training.springcore.bigcorp.model.Captor;
import com.training.springcore.bigcorp.model.Site;

import java.util.List;

public interface CaptorDao extends CrudDao<Site, String> {
    List<Captor> findBySiteId(String siteId);
}
