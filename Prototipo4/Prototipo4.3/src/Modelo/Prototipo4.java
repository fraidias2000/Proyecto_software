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
        
        //-----------Usuario 2-------------
        String direccion2 = "prueba2";
        String nombre2 = "nombrePrueba2";
        String DNI2 = "847209e";
        String apellidosprueba2 = "apellido1Prueba2";
        String contrasenia2 = "contraseniaPrueba2";
        String correoElectronico2 = "correoPrueba2";
        int tarjeta2 = 423476987;
        try {
            
            //PRUEBAS
            agencia = new Agencia(ficheroVideojuegos,direccion,numeroTelefono);
            
            //Prueba1: dar de alta un usuario y alqular 2 videojuegos
            agencia.registrarUsuario(nombre, DNI, apellidosprueba1, contrasenia, correoElectronico, direccion, tarjeta);  
            agencia.registrarUsuario(nombre2, DNI2, apellidosprueba2, contrasenia2, correoElectronico2, direccion2, tarjeta2);  
            agencia.alquilarVideojuego(DNI, 3, "FECHA ALQULER 1", "FECHA DEVOLUCION 1");
            agencia.alquilarVideojuego(DNI, 4, "FECHA ALQULER 1", "FECHA DEVOLUCION 1");
            agencia.alquilarVideojuego(DNI, 5, "FECHA ALQULER 2", "FECHA DEVOLUCION 2");
            
            //Mostrar juegos disponibles
            System.out.println("VIDEOJUEGOS DISPONIBLES NIVEL ADMINISTRADOR");
            System.out.println(agencia.mostrarJuegosDisponiblesNivelAdministrador());          
            System.out.println("VIDEOJUEGOS DISPONIBLES NIVEL USUARIO");
            System.out.println(agencia.mostrarJuegosDisponibles());
            
            //Mostrar juegos alqulados
            System.out.println("\n VIDEOJUEGOS ALQUILADOS NIVEL ADMINISTRADOR");
            System.out.println(agencia.mostrarJuegosAlquiladosNivelAdministrador());
            System.out.println("\n VIDEOJUEGOS ALQUILADOS NIVEL USUARIO");
            System.out.println(agencia.mostrarJuegosAlquilados());
            
            //Mostrar Pedido
            System.out.println("\n VIDEOJUEGOS ALQUILADOS POR " + DNI + " NIVEL ADMINISTRADOR");
            System.out.println(agencia.mostrarVideojuegosDeUnUsuarioNivelAdministrador(DNI));
            System.out.println("\n VIDEOJUEGOS ALQUILADOS POR " + DNI + " NIVEL USUARIO");
            System.out.println(agencia.mostrarVideojuegosDeUnUsuario(DNI));
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } 
    }
    
}
