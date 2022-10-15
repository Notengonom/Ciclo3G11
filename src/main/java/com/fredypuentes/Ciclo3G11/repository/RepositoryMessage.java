package com.fredypuentes.Ciclo3G11.repository;


import com.fredypuentes.Ciclo3G11.model.Message;
import com.fredypuentes.Ciclo3G11.repository.CRUD.RepositoryCrudMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryMessage {
    @Autowired
    private RepositoryCrudMessage rcm;

    public List<Message> getAll() { return (List<Message>) rcm.findAll(); }
    public Optional<Message> getMessage(int id) { return rcm.findById(id); }

    public Message save(Message msg) {
        if (msg.getIdMessage() == null) {
            return rcm.save(msg);
        } else {
            Optional<Message> e = rcm.findById(msg.getIdMessage());
            if (e == null) {
                return rcm.save(msg);
            } else {
                return msg;
            }
        }
    }

    public Message update(Message cat) {
        Optional<Message> e = rcm.findById(cat.getIdMessage());
        if (!e.isEmpty()) {
            if (cat.getMessageText() != null)
            {
                e.get().setMessageText(cat.getMessageText());
            }
            if (cat.getMotorbike() != null)
            {
                e.get().setMotorbike(cat.getMotorbike());
            }
            if (cat.getClient() != null)
            {
                e.get().setClient(cat.getClient());
            }
            rcm.save(e.get());
            return e.get();
        } else {
            return cat;
        }
    }

    public void delete(Message msg) { rcm.delete(msg); }

    public boolean deleteMessage(int id) {
        boolean aBoolean = getMessage(id).map(message -> {
            rcm.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
