/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo0;
import java.util.Map;

/**
 *
 * @author Alvaro
 */
public class Videojuego {
    private int codigo ;
    private String nombre = "";
    private int precio;
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
    public Videojuego(String nombre, int precio, TipoGenero genero,
           TipoPlataforma plataforma, int puntuacion, int stock,
           int diasAlquilerPorDefecto, String foto){
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
