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
public class Administrador {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private int id_administrador;

    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "nombre_admin")
    private String nombre_admin;
    
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido_admin")
    private String apellido_admin;
    
     @NotBlank(message = "La cedeula no puede estar en blanco")
    @Column(name = "cedula_admin")
    private String cedula_admin;

    @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion_admin")
    private String direccion_admin;
    
     @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "numero_de_telefono_admin")
    private String numero_de_telefono_admin;

    @NotBlank(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "email_admin")
    private String email_admin;
    
    @NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "contraseña_admin")
    private String contraseña_admin;
    
    
}
