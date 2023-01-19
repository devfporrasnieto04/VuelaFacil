/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.vuelafacil.Service;

import com.misiontic.vuelafacil.Ticket;
import java.util.List;

/**
 *
 * @author franciscoporrasnieto
 */
public interface TicketService {
   public Ticket save(Ticket ticket);
    public void delete (Integer id);
    public Ticket findById (Integer id);
    public List <Ticket> findAll(); 
}
