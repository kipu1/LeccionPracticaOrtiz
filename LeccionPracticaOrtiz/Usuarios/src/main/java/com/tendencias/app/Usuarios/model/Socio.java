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
public class Socio {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private int id_socio;

    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "nombre_socio")
    private String nombre_socio;
    
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido_socio")
    private String apellido_socio;
    
     @NotBlank(message = "La cedeula no puede estar en blanco")
    @Column(name = "cedula_socio")
    private String cedula_socio;

    @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion_socio")
    private String direccion_socio;
    
     @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "numero_de_telefono_socio")
    private String numero_de_telefono_socio;

    @NotBlank(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "email_socio")
    private String email_socio;
    
    @NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "contraseña_socio")
    private String contraseña_socio;
}
