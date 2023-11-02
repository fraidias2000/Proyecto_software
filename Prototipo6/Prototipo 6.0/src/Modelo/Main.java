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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*  
         * Este prototipo lista información sobre los videojuegos totales disponibles, videojuegos totales no disponibles y videojuegos de un pedido de un usuario en concreto a nivel de usuario
         * y de administrador
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
 
        String fechaDevolucion2 = "11/3/21";
        try {
            //PRUEBAS
            agencia = new Agencia(ficheroVideojuegos,direccion,numeroTelefono);
            
            //Prueba1: Creamos un comentario en el videojuego 2
            agencia.registrarUsuario(nombre, DNI, apellidosprueba1, contrasenia, correoElectronico, direccion, tarjeta);  
            agencia.ponerComentarioVideojuego(2, "Comentario de prueba");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } 
    }
    
}
