package com.fredypuentes.Ciclo3G11.repository;


import com.fredypuentes.Ciclo3G11.model.Motorbike;
import com.fredypuentes.Ciclo3G11.repository.CRUD.RepositoryCrudBike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryMotorbike {
    @Autowired
    private RepositoryCrudBike rb;

    public List<Motorbike> getAll() { return (List<Motorbike>) rb.findAll(); }
    public Optional<Motorbike> getMotorbike(int id) { return rb.findById(id); }

    public Motorbike save(Motorbike motorbike) {
        if (motorbike.getId() == null) {
            return rb.save(motorbike);
        } else {
            Optional<Motorbike> e = rb.findById(motorbike.getId());
            if (e == null) {
                return rb.save(motorbike);
            } else {
                return motorbike;
            }
        }
    }

    public Motorbike update(Motorbike motorbike) {
        Optional<Motorbike> e = rb.findById(motorbike.getId());
        if (!e.isEmpty()) {
            if (motorbike.getName() != null)
            {
                e.get().setName(motorbike.getName());
            }
            if (motorbike.getBrand() != null)
            {
                e.get().setBrand(motorbike.getBrand());
            }
            if (motorbike.getDescription() != null)
            {
                e.get().setDescription(motorbike.getDescription());
            }
            if (motorbike.getCategory() != null)
            {
                e.get().setCategory(motorbike.getCategory());
            }
            if (motorbike.getYear() != null)
            {
                e.get().setYear(motorbike.getYear());
            }
            if (motorbike.getMessages() != null)
            {
                e.get().setMessages(motorbike.getMessages());
            }
            if (motorbike.getReservations() != null)
            {
                e.get().setReservations(motorbike.getReservations());
            }
            rb.save(e.get());
            return e.get();
        } else {
            return motorbike;
        }
    }

    public void delete(Motorbike motorbike) { rb.delete(motorbike); }

    public boolean deleteMotorbike(int id) {
        boolean aBoolean = getMotorbike(id).map(motorbike -> {
            rb.delete(motorbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
