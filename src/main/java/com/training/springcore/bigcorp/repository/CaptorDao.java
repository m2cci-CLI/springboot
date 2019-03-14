package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Captor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaptorDao extends JpaRepository<Captor, String> {
    List<Captor> findBySiteId(String siteId);
    void deleteById(String Id);

}
