package com.fredypuentes.Ciclo3G11.service;


import com.fredypuentes.Ciclo3G11.model.Motorbike;
import com.fredypuentes.Ciclo3G11.repository.RepositoryMotorbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMotorbike {
    @Autowired
    private RepositoryMotorbike rb;
    //comentario

    @Autowired
    public List<Motorbike> getAll(){ return rb.getAll(); }
    public Motorbike getBike(Integer id){
        return  rb.getBike(id).get();
    }
    public Motorbike save(Motorbike bik){
        return rb.save(bik);
    }
    public Motorbike update(Motorbike bik){
        return  rb.update(bik);
    }
    public void delete(Integer doc){ rb.deleteBike(doc); }
}
