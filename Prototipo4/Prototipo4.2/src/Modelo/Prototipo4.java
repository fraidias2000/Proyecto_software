/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvar
 */
public class Prototipo4 {
     /*
      * Este prototipo implementa la devolución de un videojuego.
      */
    public static void main(String[] args) {  
        Agencia agencia;
        String ficheroVideojuegos = "videojuegos.txt";
        int numeroTelefono = 640482085;
  
//-----------Usuario 1-------------
        String direccion = "prueba1";
        String nombre = "nombrePrueba1";
        String DNI = "71230692Z";
        String apellido1prueba1 = "apellido1Prueba1";
        String apellido2prueba1 = "apellido2Prueba1";
        String contrasenia = "contraseniaPrueba1";
        String correoElectronico = "correoPrueba1";
        int tarjeta = 423476987;
        
        //-----------Usuario 2-------------
        String direccion2 = "prueba2";
        String nombre2 = "nombrePrueba2";
        String DNI2 = "847209e";
        String apellido1prueba2 = "apellido1Prueba2";
        String apellido2prueba2 = "apellido2Prueba2";
        String contrasenia2 = "contraseniaPrueba2";
        String correoElectronico2 = "correoPrueba2";
        int tarjeta2 = 423476987;
        try {
            agencia = new Agencia(ficheroVideojuegos,direccion,numeroTelefono);
            
            //Prueba1: dar de alta un usuario y alqular 2 videojuegos
            agencia.registrarUsuario(nombre, DNI, apellido1prueba1, apellido2prueba1, contrasenia, 
                                     correoElectronico, direccion, tarjeta);   
            agencia.alquilarVideojuego(DNI, 3, "FECHA ALQULER 1", "FECHA DEVOLUCION 1");
            agencia.alquilarVideojuego(DNI, 4, "FECHA ALQULER 1", "FECHA DEVOLUCION 1");
            
            //Prueba3: Eliminar un videojuego del usuario 1
            agencia.devolverVideojuego(DNI, 3);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } 
    }
    
}
