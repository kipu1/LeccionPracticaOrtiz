/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Proveedor;
import com.tendencias.app.Usuarios.service.ProveedorServiceImpl;
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
@RequestMapping("/proveedor")
public class ProveedorControler {
@Autowired
    ProveedorServiceImpl proveedorService;

    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Proveedor>> listaProveedor() {
        return new ResponseEntity<>(proveedorService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Usuario")
    @PostMapping("/crear")
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor u) {
        return new ResponseEntity<>(proveedorService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor u) {
        Proveedor proveedor = proveedorService.findById(id);
        if (proveedor != null) {
            try {
                proveedor.setNombre_proveedor(u.getNombre_proveedor());
                proveedor.setApellido_proveedor(u.getApellido_proveedor());
                proveedor.setCedula_proveedor(u.getCedula_proveedor());
                proveedor.setDireccion_proveedor(u.getDireccion_proveedor());
                proveedor.setNumero_de_telefono_proveedor(u.getNumero_de_telefono_proveedor());
                proveedor.setEmail_proveedor(u.getEmail_proveedor());
                proveedor.setContraseña_proveedor(u.getContraseña_proveedor());
                return new ResponseEntity<>(proveedorService.save(proveedor), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Proveedor> elimiarProveedor(@PathVariable Integer id) {
        proveedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


