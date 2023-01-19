/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Service.Implement;

import com.misiontic.vuelafacil.Dao.TicketDao;
import com.misiontic.vuelafacil.Service.TicketService;
import com.misiontic.vuelafacil.Ticket;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franciscoporrasnieto
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    public TicketDao ticketDao;
    @Override
    @Transactional
    public Ticket save(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ticketDao.deleteById(id);
    }

    @Override
    @Transactional
    public Ticket findById(Integer id) {
        return ticketDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Ticket> findAll() {
        return (List<Ticket>) ticketDao.findAll();
    }
    
}
