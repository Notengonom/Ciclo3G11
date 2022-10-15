package com.fredypuentes.Ciclo3G11.controller;


import com.fredypuentes.Ciclo3G11.model.Motorbike;
import com.fredypuentes.Ciclo3G11.service.ServiceMotorbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Motorbike")
public class ControllerMotorbike {
    @Autowired
    private ServiceMotorbike sb;

    @GetMapping("/all")
    public List<Motorbike> getMotorbikeAll(){ return sb.getAll(); }

    @GetMapping("/{doc}")
    public Motorbike findMotorbikeById(@PathVariable("doc")int doc){
        return sb.getMotorbike(doc);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike cat) { return sb.save(cat); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike cat){
        return sb.update(cat);
    }

    @DeleteMapping("/{doc}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMotorbikeById(@PathVariable("doc") int doc){
        sb.delete(doc);
    }
}
