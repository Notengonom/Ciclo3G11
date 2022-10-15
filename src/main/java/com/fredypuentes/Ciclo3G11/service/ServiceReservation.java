package com.fredypuentes.Ciclo3G11.service;


import com.fredypuentes.Ciclo3G11.model.Reservation;
import com.fredypuentes.Ciclo3G11.repository.RepositoryReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReservation {
    @Autowired
    private RepositoryReservation rr;

    public List<Reservation> getAll(){ return rr.getAll(); }
    public Reservation getReservation(Integer id){
        return  rr.getReservation(id).get();
    }
    public Reservation save(Reservation rsv){
        return rr.save(rsv);
    }
    public Reservation update(Reservation rsv){
        return  rr.update(rsv);
    }
    public void delete(Integer doc){ rr.deleteReservation(doc); }
    /*public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = formato.parse(dateA);
            b = formato.parse(dateB);
        }
        catch(ParseException exception){
            exception.printStackTrace();
        }
        //if (a.before(b)){
            //return  rr.getReservationPeriod(a,b);
        }
        else {
            return new ArrayList<>();
        }
    }*/

}
