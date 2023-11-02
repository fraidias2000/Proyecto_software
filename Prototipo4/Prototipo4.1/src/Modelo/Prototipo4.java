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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Este prototipo implementa el alquiler de un videojuego
         */    
        Agencia agencia;
        String ficheroVideojuegos = "videojuegos.txt";
        int numeroTelefono = 640482085;
        
//-----------Usuario 1-------------
        String direccion = "prueba1";
        String nombre = "nombrePrueba1";
        String DNI = "71230692Z";
        String apellidosprueba1 = "apellido1Prueba1";
        String contrasenia = "contraseniaPrueba1";
        String correoElectronico = "correoPrueba1";
        int tarjeta = 423476987;
        
        //-----------Usuario 2-------------
        String direccion2 = "prueba2";
        String nombre2 = "nombrePrueba2";
        String DNI2 = "847209e";
        String apellidosprueba2 = "apellido1Prueba2";
        String contrasenia2 = "contraseniaPrueba2";
        String correoElectronico2 = "correoPrueba2";
        int tarjeta2 = 423476987;
        try {
            agencia = new Agencia(ficheroVideojuegos,direccion,numeroTelefono);
            
            //Prueba1: dar de alta un usuario y alqular un videojuego
            agencia.registrarUsuario(nombre, DNI, apellidosprueba1, contrasenia, correoElectronico, direccion, tarjeta);   
            agencia.alquilarVideojuego(DNI, 3, "FECHA ALQULER 1", "FECHA DEVOLUCION 1");
            
            //Prueba2: dar de alta un usuario y alqular un videojuego
            agencia.registrarUsuario(nombre2, DNI2, apellidosprueba2, contrasenia2, correoElectronico2, direccion2, tarjeta2);   
            agencia.alquilarVideojuego(DNI2, 4, "FECHA ALQULER 2", "FECHA DEVOLUCION 2");
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } 
    }
    
}
