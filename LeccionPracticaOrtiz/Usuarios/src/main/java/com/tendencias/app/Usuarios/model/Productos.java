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
public class Productos {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El Producto no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    
     @NotBlank(message = "El precio_empredendor no puede estar en blanco")
    @Column(name = "precio_empredendor")
    private String precio_empredendor;
    
 

    @NotBlank(message = "Debe ingresar una imagen de correo válida")
    @Column(name = "imagen")
    private String imagen;
    
    
    @NotBlank(message = "Debe ingresar una talla de correo válida")
    @Column(name = "talla")
    private String talla;
 
    
    @NotBlank(message = "Debe ingresar una color de correo válida")
    @Column(name = "color")
    private String color;
}
