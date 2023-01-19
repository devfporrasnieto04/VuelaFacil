/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Controller;

import com.misiontic.vuelafacil.Service.VueloService;
import com.misiontic.vuelafacil.Vuelo;
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
@RequestMapping("/Vuelo")
public class VueloControler {
    @Autowired
    public VueloService vueloService;
    @PostMapping(value="/")
    public ResponseEntity<Vuelo> agregar (@RequestBody Vuelo vuelo ){
        Vuelo fly;
        fly= vueloService.save(vuelo);
        return new ResponseEntity<>(fly, HttpStatus.OK);// se retorna el resultado http
    }
    @DeleteMapping (value="{id}")
    public ResponseEntity<Vuelo> borrar (@PathVariable Integer id){
        Vuelo fly= vueloService.findById(id);// Buscar el vuelo por el id
        if (fly!=null){
            // si se encontró el usuario en la tabla 
            vueloService.delete(id);
        } else {
            // si no se encontró
            return new ResponseEntity<> (fly,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(fly, HttpStatus.OK);// finalizado correctamente

    }
  @PutMapping (value="/")
    public ResponseEntity<Vuelo> editar (@RequestBody Vuelo vuelo){
        Vuelo fly= vueloService.findById(vuelo.getIdVuelo());
        if (fly!=null){
            fly.setIdVuelo(vuelo.getIdVuelo());
            fly.setLugarDestino(vuelo.getLugarDestino());
            fly.setLugarOrigen(vuelo.getLugarDestino());
        } else{
             // si no se encontró
            return new ResponseEntity<> (fly,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(fly, HttpStatus.OK);// finalizado correctamente
        }
    @GetMapping (value="/list")
    public List<Vuelo> listartodos(){
       return vueloService.findAll();
    }
        
    @GetMapping (value= "/list/{id}")
    public Vuelo obtenervuelo(@PathVariable Integer id){
        return vueloService.findById(id);
    }
}
