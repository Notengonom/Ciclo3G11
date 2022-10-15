package com.fredypuentes.Ciclo3G11.service;


import com.fredypuentes.Ciclo3G11.model.Category;
import com.fredypuentes.Ciclo3G11.repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategory {
    @Autowired
    private RepositoryCategory rc;
    public List<Category> getAll(){ return rc.getAll(); }
    public Category getCategory(Integer id){
        return  rc.getCategory(id).get();
    }
    public Category save(Category category) {
        if (category.getId() == null) {
            return rc.save(category);
        } else {
            Optional<Category> category1 = rc.getCategory(category.getId());
            if (category1.isEmpty()) {
                return rc.save(category);
            } else {
                return category;
            }
        }
    }
    public Category update(Category cat){
        return  rc.update(cat);
    }
    public void delete(Integer doc){ rc.deleteCategory(doc); }
}
