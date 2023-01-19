/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Controller;

import com.misiontic.vuelafacil.Service.TicketService;
import com.misiontic.vuelafacil.Ticket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franciscoporrasnieto
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    public TicketService ticketService;
    
    @PostMapping (value="/")
    public ResponseEntity<Ticket> agregar (@RequestBody Ticket ticket){
        Ticket tck;
        tck = ticketService.save(ticket);
        return new ResponseEntity<>(tck,HttpStatus.OK);
    }
    
    @DeleteMapping(value="{id}")
    public ResponseEntity<Ticket> borrar (@PathVariable Integer id){
        Ticket tck = ticketService.findById(id);
        if (tck!=null){
            ticketService.delete(id);
        }else{
            return new ResponseEntity<>(tck,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(tck,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
     public ResponseEntity<Ticket> editar (@RequestBody Ticket ticket){
         Ticket tck = ticketService.findById(ticket.getIdTicket());
         if (tck!=null){
             tck.setClase(ticket.getClase());
             tck.setEquipaje(ticket.getEquipaje());
             tck.setFechaVueloIda(ticket.getFechaVueloIda());
             tck.setFechaVueloRegreso(ticket.getFechaVueloRegreso());
             tck.setIdTicket(ticket.getIdTicket());
             tck.setNumAsiento(ticket.getNumAsiento());
             tck.setPrecio(ticket.getPrecio());
             tck.setUsuario_idUsuario(ticket.getUsuario_idUsuario());
             tck.setAeropuerto_idAeropuerto(ticket.getAeropuerto_idAeropuerto());
             tck.setVuelo_idVuelo(ticket.getVuelo_idVuelo());
             ticketService.save(ticket);//Actualiza el ticket
        } else {
             return new ResponseEntity<>(tck,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(tck,HttpStatus.OK);
        }
     @GetMapping (value="/list")
     public List<Ticket> listartodos(){
         return ticketService.findAll();
     }
     
     @GetMapping (value="/list/{id}")
     public Ticket obtenerticket(@PathVariable Integer id){
         return ticketService.findById(id);
     }
}
