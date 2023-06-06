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
public class Proveedor {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private int id_proveedor;

    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "nombre_proveedor")
    private String nombre_proveedor;
    
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido_proveedor")
    private String apellido_proveedor;
    
     @NotBlank(message = "La cedeula no puede estar en blanco")
    @Column(name = "cedula_proveedor")
    private String cedula_proveedor;

    @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion_proveedor")
    private String direccion_proveedor;
    
     @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "numero_de_telefono_proveedor")
    private String numero_de_telefono_proveedor;

    @NotBlank(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "email_proveedor")
    private String email_proveedor;
    
    @NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "contraseña_proveedor")
    private String contraseña_proveedor; 
}
