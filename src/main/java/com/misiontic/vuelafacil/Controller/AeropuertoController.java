/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Controller;

import com.misiontic.vuelafacil.Aeropuerto;
import com.misiontic.vuelafacil.Service.AeropuertoService;
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
@RequestMapping("/Aeropuerto")
public class AeropuertoController {
    @Autowired
    public AeropuertoService aeropuertoService;
    
    @PostMapping(value="/")
    public ResponseEntity<Aeropuerto> agregar(@RequestBody Aeropuerto aeropuerto){
        Aeropuerto arpt;
        arpt = aeropuertoService.save(aeropuerto);
        return new ResponseEntity<>(arpt,HttpStatus.OK);
    }
    
    @DeleteMapping (value="{id}")
    public ResponseEntity<Aeropuerto> borrar(@PathVariable Integer id){
        Aeropuerto arpt= aeropuertoService.findById(id);
        if (arpt!= null){
            aeropuertoService.delete(id);
        }else{
              // si no se encontró
            return new ResponseEntity<> (arpt,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(arpt, HttpStatus.OK);// finalizado correctamente

        }
    
    @PutMapping (value="/")
    public ResponseEntity<Aeropuerto> editar(@RequestBody Aeropuerto aeropuerto){
        Aeropuerto arpt= aeropuertoService.findById(aeropuerto.getIdAeropuerto());
        if (arpt!=null){
            arpt.setCiudad(aeropuerto.getCiudad());
            arpt.setIdAeropuerto(aeropuerto.getIdAeropuerto());
        } else{
             // si no se encontró
            return new ResponseEntity<> (arpt,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(arpt, HttpStatus.OK);// finalizado correctamente 
        }
    
    @GetMapping (value="/list")
    public List<Aeropuerto> listartodos(){
        return aeropuertoService.findAll();
    }

    @GetMapping (value="/list/{id}")
    public Aeropuerto obteneraeropuerto (@PathVariable Integer id){
        return aeropuertoService.findById(id);
    }
            
}
    
    


