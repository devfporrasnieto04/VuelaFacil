/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Service.Implement;

import com.misiontic.vuelafacil.Dao.VueloDao;
import com.misiontic.vuelafacil.Service.VueloService;
import com.misiontic.vuelafacil.Vuelo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franciscoporrasnieto
 */
@Service
public class VueloServiceImpl implements VueloService {
    @Autowired
    private VueloDao vueloDao;
    @Override
    @Transactional
    public Vuelo save(Vuelo vuelo) {    
        return vueloDao.save(vuelo);
    }
    @Override
    @Transactional
    public void delete(Integer id) {
        vueloDao.deleteById(id);
    }
    @Override
    @Transactional
    public Vuelo findById(Integer id) {
        return vueloDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Vuelo> findAll() {
        return (List<Vuelo>) vueloDao.findAll();
    }
    
}
