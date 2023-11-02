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
 * @author alvar
 */
public class Pedido {
    private Map <Integer, Alquiler> videojuegosAlquiler;
    private int precioTotal;
    private int numeroPedido = 0;
    private int contadorVideojuegos;

    /*
     * Instancia la clase Pedido
     */
    public Pedido() {
        this.numeroPedido = Agencia.numeroPedidos++;
        this.videojuegosAlquiler = new HashMap<Integer, Alquiler>();
        this.precioTotal = 0;
        this.contadorVideojuegos =0;
    }
    
    /*
     * Devuelve el número del pedido de un usuario
     */
    public int getNumeroPedido() {
        return numeroPedido;
    }
    
    
    /*
     * Añade un videojuego al pedido
     */
    public void anyadirVideojuego(Usuario usuario,Videojuego nuevoVideojuego, 
                                  String fechaAlquiler, String fechaDevolucion){
        Alquiler alquilerAux = new Alquiler(usuario, nuevoVideojuego, 
                                            fechaAlquiler, fechaDevolucion);
        videojuegosAlquiler.put(alquilerAux.getVideojuegoCodigo(), alquilerAux);
        contadorVideojuegos++;
    }
    
    /*
     * Elimina un videojuego del pedido
     */
    public void eliminarVideojuego(int codigoVideojuego){
        videojuegosAlquiler.remove(codigoVideojuego);
    }
    
    
}
