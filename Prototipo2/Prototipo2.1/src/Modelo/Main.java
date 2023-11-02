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
    * Este prototipo permite listar la información de un usuario registrado 
    */
    public static void main(String[] args) {   
        Agencia agencia;
        String ficheroVideojuegos = "videojuegos.txt";
        String direccion = "prueba1";
        int numeroTelefono = 640482085;
        String nombre = "nombrePrueba";
        String DNI = "71230692Z";
        String apellidos = "apellidosPrueba";
        String contrasenia = "contraseniaPrueba";
        String correoElectronico = "correoPrueba";
        int tarjeta = 423476987;
        try {
            agencia = new Agencia(ficheroVideojuegos,direccion,numeroTelefono);
            
            //Prueba dar de alta un usuario y mostrar su información
            agencia.registrarUsuario(nombre, DNI, apellidos, contrasenia, 
                                     correoElectronico, direccion, tarjeta);   
            
            System.out.println(agencia.mostrarInformacionUsuario(DNI));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } 
    }
    
}
