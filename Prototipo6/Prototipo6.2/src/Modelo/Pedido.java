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
    
    // Constantes
    private final String SALTO = "\n";
    private final String VACIO = "";
    
    //Variables
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
        this.contadorVideojuegos = 0;
    }
    
    /*
     * Devuelve el número del pedido de un usuario
     */
    public int getNumeroPedido() {
        return numeroPedido;
    }

    /*
     * Devuelve todos los videojuegos de un pedido
     */
    public Map<Integer, Alquiler> getVideojuegosAlquiler() {
        return videojuegosAlquiler;
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
        contadorVideojuegos--;
    }
    
    /*
     * Dado un código de videojuego y una fecha de devolución valida,
     * amplia la fecha de devolución
     */
    public void ampliarFechaAmpliacion(int codigoVideojuego, String fechaAmpliacion){
        videojuegosAlquiler.get(codigoVideojuego).ampliarFechaDevolucion(fechaAmpliacion);
    }
    
    /*
     * Muestra cierta la informacion sobre el pedido
     */
    public String mostrarPedidoUsuario(){
        String cadena = VACIO; 
        for (Map.Entry entry : videojuegosAlquiler.entrySet()) {
            Alquiler alquiler = (Alquiler)entry.getValue();
            Videojuego videojuego = alquiler.getVideojuego();
            cadena += videojuego.listarBreveInformacion() + SALTO;
    }
        return cadena;
    }
    
    /*
     * Muestra toda la informacion sobre el pedido
     */
    public String mostrarPedidoAdministrador(){
        String cadena = VACIO; 
        for (Map.Entry entry : videojuegosAlquiler.entrySet()) {
            Alquiler alquiler = (Alquiler)entry.getValue();
            Videojuego videojuego = alquiler.getVideojuego();
            cadena += videojuego.listarExtensaInformacion() + SALTO;
    }
        return cadena;
    }
}
