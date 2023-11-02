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
public class Main {
     /*
      *Este prototipo permite dar de alta o de baja vidoejuegos de 
      * forma manual
      */
    public static void main(String[] args) {    
       
        Agencia agencia;
        String ficheroVideojuegos = "videojuegos.txt";
        String direccion = "Unizar";
        int numeroTelefono = 640482085;
        try {
            agencia = new Agencia(ficheroVideojuegos,direccion,numeroTelefono);
            
            //Prueba dar de alta un videojuego
            agencia.darDeAltaVideojuego(20, "PRO 21", 10, "deporte", "ps4", 
                                        10, 10, 10, direccion);
          
            //Prueba dar de baja un videojuego
            agencia.darDeBajaVideojuego(7);
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } 
    }
    
}
