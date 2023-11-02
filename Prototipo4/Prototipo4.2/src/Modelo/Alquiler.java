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
    private Usuario usuario = null;
    private Videojuego videojuego = null;
    private String fechaAlquiler ="";
    private String fechaDevolucion = "";

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
    
    
    
    
    
}
