/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alvar
 */
public class Alquiler {
    
    //Constantes
    private final String VACIO ="";
    
    //Variables
    private Usuario usuario = null;
    private Videojuego videojuego = null;
    private String fechaAlquiler = VACIO;
    private String fechaDevolucion = VACIO;

    //Instancia los atributos de la clase alquiler
    public Alquiler(Usuario usuario, Videojuego videojuego, String fechaAlquiler,
                    String fechaDevolucion) {
        this.usuario = usuario;
        this.videojuego = videojuego;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    /*
     * Devuelve un usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /*
     * Devuelve el codigo de un videojuego
     */
    public int getVideojuegoCodigo() {
        return videojuego.getCodigo();
    }
    
    /*
     * Devuelve un videojuego
     */
    public Videojuego getVideojuego(){
        return videojuego;
    }
    
    /*
     * Devuelve la fecha donde se alquiló un videojuego
     */
    public String getFechaAlquiler() {
        return fechaAlquiler;
    }
    
    /*
     * Devuelve la fecha donde se devolvió un videojuego
     */
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    /*
     * Dada una fecha de devolución valida, amplia la fecha de devolución
     */
    public void ampliarFechaDevolucion(String fechaAmpliacion){
        this.fechaDevolucion = fechaAmpliacion;
    }
}
