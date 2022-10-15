package com.fredypuentes.Ciclo3G11.repository;

import com.fredypuentes.Ciclo3G11.model.Category;
import com.fredypuentes.Ciclo3G11.repository.CRUD.RepositoryCrudCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryCategory {
    @Autowired
    private RepositoryCrudCategory rc;

    public List<Category> getAll() { return (List<Category>) rc.findAll(); }
    public Optional<Category> getCategory(int id) { return rc.findById(id); }

    public Category save(Category cat) {
        if (cat.getId() == null) {
            return rc.save(cat);
        } else {
            Optional<Category> e = rc.findById(cat.getId());
            if (e == null) {
                return rc.save(cat);
            } else {
                return cat;
            }
        }
    }

    public Category update(Category cat) {
        Optional<Category> e = rc.findById(cat.getId());
        if (!e.isEmpty()) {
            if (cat.getName() != null)
            {
                e.get().setName(cat.getName());
            }
            if (cat.getDescription() != null)
            {
                e.get().setDescription(cat.getDescription());
            }
            if (cat.getMotorbikes() != null)
            {
                e.get().setMotorbikes(cat.getMotorbikes());
            }
            rc.save(e.get());
            return e.get();
        } else {
            return cat;
        }
    }

    public void delete(Category cat) { rc.delete(cat); }

    public boolean deleteCategory(int id) {
        boolean aBoolean = getCategory(id).map(category -> {
            rc.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
