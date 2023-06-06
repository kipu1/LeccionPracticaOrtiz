/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Productos;
import com.tendencias.app.Usuarios.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS ROG
 */
@Service
public class ProductoServiceImpl extends GenericServiceImpl<Productos, Integer> implements GenericService<Productos, Integer> {

    @Autowired
    ProductoRepository ProductoRepository;

    @Override
    public CrudRepository<Productos, Integer> getDao() {
        return ProductoRepository;
    }

    
    
}
