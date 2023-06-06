/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.repository;

import com.tendencias.app.Usuarios.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ASUS ROG
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
        @Query(value = "Select * from proveedor u where u.nombre = :nombre", nativeQuery = true)
    public Proveedor buscarProveedor(String nombre);
}

