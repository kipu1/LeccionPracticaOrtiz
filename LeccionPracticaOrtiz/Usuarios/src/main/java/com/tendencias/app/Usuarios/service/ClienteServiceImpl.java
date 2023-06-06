/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Cliente;
import com.tendencias.app.Usuarios.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS ROG
 */
@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements GenericService<Cliente, Integer> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public CrudRepository<Cliente, Integer> getDao() {
        return clienteRepository;

    
    }
    
}
