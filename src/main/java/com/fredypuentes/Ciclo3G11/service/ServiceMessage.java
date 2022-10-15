package com.fredypuentes.Ciclo3G11.service;


import com.fredypuentes.Ciclo3G11.model.Message;
import com.fredypuentes.Ciclo3G11.repository.RepositoryMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMessage {
    @Autowired
    private RepositoryMessage rm;

    public List<Message> getAll(){ return rm.getAll(); }
    public Message getMessage(Integer id){
        return  rm.getMessage(id).get();
    }
    public Message save(Message msg){
        return rm.save(msg);
    }
    public Message update(Message msg){
        return  rm.update(msg);
    }
    public void delete(Integer doc){ rm.deleteMessage(doc); }
}
