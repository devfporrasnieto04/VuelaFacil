/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil.Service.Implement;

import com.misiontic.vuelafacil.Dao.UsuarioDao;
import com.misiontic.vuelafacil.Service.UsuarioService;
import com.misiontic.vuelafacil.Usuario;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franciscoporrasnieto
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
   @Autowired 
   private UsuarioDao usuarioDao;
   @Override
   @Transactional
   public Usuario save (Usuario usuario){
       return usuarioDao.save(usuario);
    }
   
   @Override
   @Transactional
   public void delete (Integer id){
        usuarioDao.deleteById(id);
   }
   
   @Override
   @Transactional 
   public Usuario findById (Integer id){
       
       return usuarioDao.findById(id).orElse(null);
   }
   
   @Override
   @Transactional 
   public List <Usuario> findAll(){
       
       return (List <Usuario>) usuarioDao.findAll();
       
   }
}

