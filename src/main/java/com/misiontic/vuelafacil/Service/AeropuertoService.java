/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.vuelafacil.Service;

import com.misiontic.vuelafacil.Aeropuerto;
import java.util.List;

/**
 *
 * @author franciscoporrasnieto
 */

public interface AeropuertoService {
    public Aeropuerto save(Aeropuerto aeropuerto);
    public void delete (Integer id);
    public Aeropuerto findById (Integer id);
    public List <Aeropuerto> findAll();
}
