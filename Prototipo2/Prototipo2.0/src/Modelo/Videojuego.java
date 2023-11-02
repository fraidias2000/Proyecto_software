/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Map;

/**
 *
 * @author Alvaro
 */
public class Videojuego {
    private int codigo ;
    private String nombre = "";
    private double precio;
    private TipoGenero tipoGenero;
    private TipoPlataforma tipoPlataforma;
    private int puntuacion ;
    private int stock;
    private boolean disponible = true;
    private int diasAlquilerPorDefecto;
    private String foto;
    private Map <Integer, Comentario> comentarios;
    
    /*
     * Se les da valor a todos los atributos de videojuego. El atributo código
     * que es el que identifica al videojuego, se incrementa positivamente.
     */
    public Videojuego(int codigo, String nombre, double precio, 
                      TipoGenero genero, TipoPlataforma plataforma, 
                      int puntuacion, int stock, 
                      int diasAlquilerPorDefecto, String foto){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoGenero = genero;
        this.tipoPlataforma = plataforma;
        this.puntuacion = puntuacion;
        this.stock = stock;
        this.diasAlquilerPorDefecto = diasAlquilerPorDefecto;
        this.foto = foto;
        this.disponible = true;
    }

    //Devuelve el codigo del videojuego
    public int getCodigo() {
        return codigo;
    }
    
    
    /*
     * Dado un codigo válido, se alquila el videojuego si queda stock
     */
    public boolean alquilarVideojuego(int codigo){
        return true;
    };
    
    /*
     * Dado un codigo válido, se devuelve el videojuego
     */
    public boolean devolverVideojuego(int codigo){
        return true;
    };
    
    /*
     * Lista todos los videojuegos disponibles
     */
    public String listarVideojuegosDisponibles(){
        return "";
    };
    
    /*
     * Lista todos los videjuegos alquilados
     */
    public String listarVideojuegosAlquilados(){
        return "";
    };
    
    /*
     * Añade un comentario a un juego en concreto
     */
    public boolean anyadirComentario(String texto){
        return true;
    };
    
    /*
     * Elimina un comentario en un juego en concreto
     */
    public boolean eliminarComentario(int codigo){
        return true;
    };
    
    
}
