/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Productos;
import com.tendencias.app.Usuarios.service.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author ASUS ROG
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoServiceImpl productoService;

    @Operation(summary = "Se obtiene la lista de Productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Productos>> listaProductos() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Productos")
    @PostMapping("/crear")
    public ResponseEntity<Productos> crearProductos(@RequestBody Productos u) {
        return new ResponseEntity<>(productoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Productos> actualizarProductos(@PathVariable Integer id, @RequestBody Productos u) {
        Productos productos = productoService.findById(id);
        if (productos != null) {
            try {
                productos.setNombre(u.getNombre());
                productos.setPrecio_empredendor(u.getPrecio_empredendor());
                productos.setImagen(u.getImagen());
                productos.setTalla(u.getTalla());
                productos.setColor(u.getColor());
                return new ResponseEntity<>(productoService.save(productos), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Productos> elimiarProductos(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

