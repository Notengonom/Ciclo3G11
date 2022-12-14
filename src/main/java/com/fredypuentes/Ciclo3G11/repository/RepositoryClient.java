package com.fredypuentes.Ciclo3G11.repository;

import com.fredypuentes.Ciclo3G11.model.Client;
import com.fredypuentes.Ciclo3G11.repository.CRUD.RepositoryCrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryClient {
    @Autowired
    private RepositoryCrudClient rc;

    public List<Client> getAll() { return (List<Client>) rc.findAll(); }
    public Optional<Client> getClient(int id) { return rc.findById(id); }

    public Client save(Client client){
        return rc.save(client);
    }

    public void delete(Client cli) { rc.delete(cli); }

    public boolean deleteClient(int id) {
        boolean aBoolean = getClient(id).map(client -> {
            rc.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
