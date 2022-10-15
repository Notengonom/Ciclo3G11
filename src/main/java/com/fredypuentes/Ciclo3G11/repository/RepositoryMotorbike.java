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
    public Optional<Motorbike> getBike(int id) { return rb.findById(id); }

    public Motorbike save(Motorbike bik) {
        if (bik.getId() == null) {
            return rb.save(bik);
        } else {
            Optional<Motorbike> e = rb.findById(bik.getId());
            if (e == null) {
                return rb.save(bik);
            } else {
                return bik;
            }
        }
    }

    public Motorbike update(Motorbike bik) {
        Optional<Motorbike> e = rb.findById(bik.getId());
        if (!e.isEmpty()) {
            if (bik.getName() != null)
            {
                e.get().setName(bik.getName());
            }
            if (bik.getBrand() != null)
            {
                e.get().setBrand(bik.getBrand());
            }
            if (bik.getDescription() != null)
            {
                e.get().setDescription(bik.getDescription());
            }
            if (bik.getCategory() != null)
            {
                e.get().setCategory(bik.getCategory());
            }
            if (bik.getYear() != null)
            {
                e.get().setYear(bik.getYear());
            }
            if (bik.getMessages() != null)
            {
                e.get().setMessages(bik.getMessages());
            }
            if (bik.getReservations() != null)
            {
                e.get().setReservations(bik.getReservations());
            }
            rb.save(e.get());
            return e.get();
        } else {
            return bik;
        }
    }

    public void delete(Motorbike bik) { rb.delete(bik); }

    public boolean deleteBike(int id) {
        boolean aBoolean = getBike(id).map(bike -> {
            rb.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
