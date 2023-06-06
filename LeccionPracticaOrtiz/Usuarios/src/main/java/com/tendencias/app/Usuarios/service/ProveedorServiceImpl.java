/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Proveedor;
import com.tendencias.app.Usuarios.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS ROG
 */
@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor, Integer> implements GenericService<Proveedor, Integer> {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public CrudRepository<Proveedor, Integer> getDao() {
        return proveedorRepository;
    }

   
    
}
