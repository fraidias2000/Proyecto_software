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
    private static int numeroPedido;
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
     * Añade un videojuego al pedido
     */
    public void anyadirVideojuego(Usuario usuario,Videojuego nuevoVideojuego, 
                                  String fechaAlquiler, String fechaDevolucion){
        Alquiler alquilerAux = new Alquiler(usuario, nuevoVideojuego, 
                                            fechaAlquiler, fechaDevolucion);
        videojuegosAlquiler.put(contadorVideojuegos++, alquilerAux);
    }
    
    
}
