/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alvaro
 */
public class Carrito {
    Usuario usuarioCarrito;
    private Map <Integer, Videojuego> videojuegosCarrito;
    
    /*
     * Crea un carrito asociado a un usuario
     */
    public Carrito(Usuario usuarioCarrito){
        this.usuarioCarrito = usuarioCarrito;
        videojuegosCarrito  = new HashMap<Integer, Videojuego>();
    };
    
    /*
     * Añade un juego a nuestro carrito. 
     * Devuelve true si se realiza correctamente
     */ 
    public boolean anyadirVideojuego(int codigoJuego, Videojuego Videojuego){
        return true;
    }
    
     /*
     * Elimina un juego de nuestro carrito. 
     * Devuelve true si se realiza correctamente
     */ 
    public boolean eliminarVideojuego(int codigoJuego){
        return true;
    }
    
}
