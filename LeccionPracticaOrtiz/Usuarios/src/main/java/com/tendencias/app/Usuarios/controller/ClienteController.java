/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Cliente;
import com.tendencias.app.Usuarios.service.ClienteServiceImpl;
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
@RequestMapping("/cliente")
public class ClienteController {
   @Autowired
    ClienteServiceImpl clienteService;

    @Operation(summary = "Se obtiene la lista de cliente")
    @GetMapping("/listar")
    public ResponseEntity<List< Cliente>> listaCliente() {
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del cliente")
    @PostMapping("/crear")
    public ResponseEntity< Cliente> crearCliente(@RequestBody  Cliente u) {
        return new ResponseEntity<>(clienteService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity< Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody  Cliente u) {
         Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            try {
                cliente.setNombre_cliente(u.getNombre_cliente());
                cliente.setApellido_cliente(u.getApellido_cliente());
                cliente.setCedula_cliente(u.getCedula_cliente());
                cliente.setDireccion_cliente(u.getDireccion_cliente());
                cliente.setNumero_de_telefono_cliente(u.getNumero_de_telefono_cliente());
                cliente.setEmail_cliente(u.getEmail_cliente());
                cliente.setContraseña_cliente(u.getContraseña_cliente());
                return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> elimiarCliente(@PathVariable Integer id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


