/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.app.Usuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author ASUS ROG
 */
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id_cliente;

    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido_cliente")
    private String apellido_cliente;
    
     @NotBlank(message = "La cedeula no puede estar en blanco")
    @Column(name = "cedula_cliente")
    private String cedula_cliente;

    @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion_cliente")
    private String direccion_cliente;
    
     @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "numero_de_telefono_cliente")
    private String numero_de_telefono_cliente;

    @NotBlank(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "email_cliente")
    private String email_cliente;
    
    @NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "contraseña_cliente")
    private String contraseña_cliente;
}
