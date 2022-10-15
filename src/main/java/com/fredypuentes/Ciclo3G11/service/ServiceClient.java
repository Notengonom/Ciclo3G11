package com.fredypuentes.Ciclo3G11.service;


import com.fredypuentes.Ciclo3G11.model.Client;
import com.fredypuentes.Ciclo3G11.repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClient {
    @Autowired
    private RepositoryClient rc;
    public List<Client> getAll(){ return rc.getAll(); }
    public Client getClient(Integer id){
        return  rc.getClient(id).get();
    }
    public Client save(Client motorbike){
        return rc.save(motorbike);
    }
    public Client update(Client motorbike){
        return  rc.update(motorbike);
    }
    public void delete(Integer doc){ rc.deleteClient(doc); }
}
