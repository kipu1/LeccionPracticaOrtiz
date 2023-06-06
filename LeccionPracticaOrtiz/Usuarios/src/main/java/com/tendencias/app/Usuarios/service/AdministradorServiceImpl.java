/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Administrador;
import com.tendencias.app.Usuarios.repository.AdministradorRepository;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS ROG
 */
@Service
public class AdministradorServiceImpl extends GenericServiceImpl<Administrador, Integer> implements GenericService<Administrador, Integer> {

     @Autowired
     AdministradorRepository administradorRepository;
    
    
    @Override
    public CrudRepository<Administrador, Integer> getDao() {
       return administradorRepository;
    }
    
}
