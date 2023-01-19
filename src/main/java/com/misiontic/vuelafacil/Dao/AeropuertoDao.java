/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.vuelafacil.Dao;

import com.misiontic.vuelafacil.Aeropuerto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author franciscoporrasnieto
 */
@Repository
public interface AeropuertoDao extends CrudRepository <Aeropuerto ,Integer> {
    
}
