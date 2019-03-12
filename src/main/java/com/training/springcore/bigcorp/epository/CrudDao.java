package com.training.springcore.bigcorp.epository;

import java.util.List;

public interface CrudDao <T , ID> {
    // Create
    void create(T element);
    // Read
    T findById(ID id);
    List<T> findAll();
    // Update
    void update(T element);
    // Delete
    void deleteById(ID id);
}