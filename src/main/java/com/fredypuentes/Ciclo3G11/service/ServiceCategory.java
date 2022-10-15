package com.fredypuentes.Ciclo3G11.service;


import com.fredypuentes.Ciclo3G11.model.Category;
import com.fredypuentes.Ciclo3G11.repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategory {
    @Autowired
    private RepositoryCategory rc;
    public List<Category> getAll(){ return rc.getAll(); }
    public Category getCategory(Integer id){
        return  rc.getCategory(id).get();
    }
    public Category save(Category cat){
        return rc.save(cat);
    }
    public Category update(Category cat){
        return  rc.update(cat);
    }
    public void delete(Integer doc){ rc.deleteCategory(doc); }
}
