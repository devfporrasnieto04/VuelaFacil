/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.vuelafacil.Service;

import com.misiontic.vuelafacil.Vuelo;
import java.util.List;

/**
 *
 * @author franciscoporrasnieto
 */
public interface VueloService {
    public Vuelo save(Vuelo vuelo);
    public void delete (Integer id);
    public Vuelo findById (Integer id);
    public List <Vuelo> findAll();
}
