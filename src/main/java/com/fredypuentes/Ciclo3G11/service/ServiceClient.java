package com.fredypuentes.Ciclo3G11.service;


import com.fredypuentes.Ciclo3G11.model.Client;
import com.fredypuentes.Ciclo3G11.repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClient {
    @Autowired
    private RepositoryClient rc;
    public List<Client> getAll(){ return rc.getAll(); }
    public Client getClient(Integer id){
        return  rc.getClient(id).get();
    }
    public Client save(Client client){
        if(client.getIdClient()==null){
            return rc.save(client);
        }else{
            Optional<Client> e= rc.getClient(client.getIdClient());
            if(e.isEmpty()){
                return rc.save(client);
            }else{
                return client;
            }
        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= rc.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                rc.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public void delete(Integer doc){ rc.deleteClient(doc); }
}
