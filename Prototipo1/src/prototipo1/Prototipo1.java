/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvar
 */
public class Prototipo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Agencia agencia;
        String ficheroVideojuegos = "videojuegos.txt";
        String direccion = "Unizar";
        int numeroTelefono = 640482085;
        try {
            agencia = new Agencia(ficheroVideojuegos,direccion,numeroTelefono);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agencia.class.getName()).
                             log(Level.SEVERE, null, ex);
        } 
    }
    
}
