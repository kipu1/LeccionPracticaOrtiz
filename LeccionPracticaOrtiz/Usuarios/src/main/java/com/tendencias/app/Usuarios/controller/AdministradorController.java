/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Administrador;
import com.tendencias.app.Usuarios.service.AdministradorServiceImpl;

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
@RequestMapping("/administrador")
public class AdministradorController {
 @Autowired
    AdministradorServiceImpl administradorService;

    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Administrador>> listaAdministrador() {
        return new ResponseEntity<>(administradorService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Usuario")
    @PostMapping("/crear")
    public ResponseEntity<Administrador> crearAdministrador(@RequestBody Administrador u) {
        return new ResponseEntity<>(administradorService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Administrador> actualizarAdministrador(@PathVariable Integer id, @RequestBody Administrador u) {
        Administrador administrador = administradorService.findById(id);
        if (administrador != null) {
            try {
                administrador.setNombre_admin(u.getNombre_admin());
                administrador.setApellido_admin(u.getApellido_admin());
                administrador.setCedula_admin(u.getCedula_admin());
                administrador.setDireccion_admin(u.getDireccion_admin());
                administrador.setNumero_de_telefono_admin(u.getNumero_de_telefono_admin());
                administrador.setEmail_admin(u.getEmail_admin());
                administrador.setContraseña_admin(u.getContraseña_admin());
                return new ResponseEntity<>(administradorService.save(administrador), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Administrador> elimiarAdministrador(@PathVariable Integer id) {
        administradorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

