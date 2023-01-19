/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Service.Implement;

import com.misiontic.vuelafacil.Aeropuerto;
import com.misiontic.vuelafacil.Dao.AeropuertoDao;
import com.misiontic.vuelafacil.Service.AeropuertoService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franciscoporrasnieto
 */
@Service
public class AeropuertoServiceImpl implements AeropuertoService {
    @Autowired
    public AeropuertoDao aeropuertoDao;
    
    @Override
    @Transactional
    public Aeropuerto save(Aeropuerto aeropuerto) {
        return aeropuertoDao.save(aeropuerto);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        aeropuertoDao.deleteById(id);
    }

    @Override
    @Transactional
    public Aeropuerto findById(Integer id) {
        return aeropuertoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Aeropuerto> findAll() {
        return (List<Aeropuerto>) aeropuertoDao.findAll();
    }
    
}
