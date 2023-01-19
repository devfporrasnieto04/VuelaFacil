/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Controller;

import com.misiontic.vuelafacil.Service.UsuarioService;
import com.misiontic.vuelafacil.Usuario;
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
 * RestController indica que esta clase implementa operaciones http: get, post, put, delete 
 * CrossOrigin se usa para este tipo de controlador
 * RecuestMapping completa la url desde donde se hacen las peticiones ej: (http://localhost8080/usuario)
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    public UsuarioService usuarioService;// llamada al service de usuario
    //operacion post para insertar en la tabla usuario de la BD
    @PostMapping (value="/")
    public ResponseEntity<Usuario> agregar (@RequestBody Usuario usuario ){
        // Este metodo inserta un nuevo usuario en la tabla correspondiente
        Usuario user; // nuevo objeto de tipo usuario
        user = usuarioService.save(usuario);//se guarda el usuario
        return new ResponseEntity<>(user, HttpStatus.OK);// se retorna el resultado http
        }

    //esta operacion efectua el borrado de un usuario
    //@PathVariable es porque la url es variable url/usuario/idusuario  
    @DeleteMapping (value="{id}")
    public ResponseEntity<Usuario> borrar (@PathVariable Integer id){
        Usuario user= usuarioService.findById(id);// Buscar el Usuario por el id
        if (user!=null){
            // si se encontró el usuario en la tabla 
            usuarioService.delete(id);
        } else {
            // si no se encontró
            return new ResponseEntity<> (user,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(user, HttpStatus.OK);// finalizado correctamente

    }
    
    // Poeracion de actualizar un usuario
    @PutMapping (value="/")
    public ResponseEntity<Usuario> editar (@RequestBody Usuario usuario){
        Usuario user= usuarioService.findById(usuario.getIdusuario());// Buscar el Usuario por el id
        if (user!=null){
        // si se encontró el usuario en la tabla se actualizan los valores
        user.setEdad(usuario.getEdad());
        user.setEmail(usuario.getEmail());
        user.setIdusuario(usuario.getIdusuario());
        user.setNacionalidad(usuario.getNacionalidad());
        user.setNombre(usuario.getNombre());
        user.setPassword(usuario.getPassword());
        user.setUsuario(usuario.getUsuario());
        usuarioService.save(user);// Se actualiza la tabla
        } else {
            // si no se encontró
            return new ResponseEntity<> (user,HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(user, HttpStatus.OK);// finalizado correctamente

        }
    //obtener una lista con todos los usuarios 
    //url de ejemplo seria asi: http://localhost:8080/usuario/list
    
    @GetMapping (value="/list")
    public List<Usuario> listartodos (){
        return usuarioService.findAll();
    }
    //Obtener un solo usuario
    //url de ejemplo seria asi: http://localhost:8080/usuario/list/30
    @GetMapping (value="/list/{id}")
    public Usuario obtenerusuario(@PathVariable Integer id){
        return usuarioService.findById(id);
    }
 }
