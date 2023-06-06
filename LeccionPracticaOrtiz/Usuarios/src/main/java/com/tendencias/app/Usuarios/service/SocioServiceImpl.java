/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Socio;
import com.tendencias.app.Usuarios.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS ROG
 */
@Service
public class SocioServiceImpl extends GenericServiceImpl<Socio, Integer> implements GenericService<Socio, Integer> {

    @Autowired
    SocioRepository socioRepository;

   @Override
    public CrudRepository<Socio, Integer> getDao() {
        return socioRepository;
    }

    
    
}
