/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Socio;
import com.tendencias.app.Usuarios.service.SocioServiceImpl;
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
@RequestMapping("/socio")
public class SocioController {
    
 @Autowired
    SocioServiceImpl socioService;

    @Operation(summary = "Se obtiene la lista de socio")
    @GetMapping("/listar")
    public ResponseEntity<List<Socio>> listaSocio() {
        return new ResponseEntity<>(socioService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del socio")
    @PostMapping("/crear")
    public ResponseEntity<Socio> crearSocio(@RequestBody Socio u) {
        return new ResponseEntity<>(socioService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Socio> actualizarSocio(@PathVariable Integer id, @RequestBody Socio u) {
        Socio socio = socioService.findById(id);
        if (socio != null) {
            try {
                socio.setNombre_socio(u.getNombre_socio());
                socio.setApellido_socio(u.getApellido_socio());
                socio.setCedula_socio(u.getCedula_socio());
                socio.setDireccion_socio(u.getDireccion_socio());
                socio.setNumero_de_telefono_socio(u.getNumero_de_telefono_socio());
                socio.setEmail_socio(u.getEmail_socio());
                socio.setContraseña_socio(u.getContraseña_socio());
                return new ResponseEntity<>(socioService.save(socio), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Socio> elimiarSocio(@PathVariable Integer id) {
        socioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


 }

