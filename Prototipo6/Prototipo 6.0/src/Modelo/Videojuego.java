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
public class Videojuego {
    
    //Constantes
    private final String SEPARACION = " ";
    
    //Variables
    private int codigo ;
    private String nombre = "";
    private double precio;
    private TipoGenero tipoGenero;
    private TipoPlataforma tipoPlataforma;
    private int puntuacion ;
    private int stock;
    private boolean disponible = true;
    private int diasAlquiler;
    private String foto;
    private Map <Integer, Comentario> comentarios;
    private int contadorComentarios = 0;
    
    /*
     * Se les da valor a todos los atributos de videojuego. El atributo código
     * que es el que identifica al videojuego, se incrementa positivamente.
     */
    public Videojuego(int codigo, String nombre, double precio, TipoGenero genero,
            TipoPlataforma plataforma, int puntuacion, int stock, 
            int diasAlquilerPorDefecto, String foto){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoGenero = genero;
        this.tipoPlataforma = plataforma;
        this.puntuacion = puntuacion;
        this.stock = stock;
        this.diasAlquiler = diasAlquilerPorDefecto;
        this.foto = foto;
        this.disponible = true;
        comentarios = new HashMap<Integer, Comentario>();
        
    }

    //Devuelve el codigo del videojuego
    public int getCodigo() {
        return codigo;
    }
    
    /*
     * Devuelve el stock de un videojuego
     */
    public int getStock(){
        return stock;
    }

    /*
     * Devuelve el nombre de un videojuego
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Devuelve el precio de un videojuego
     */
    public double getPrecio() {
        return precio;
    }

    /*
     * Devuelve el tipo de genero de un videojuego
     */
    public TipoGenero getTipoGenero() {
        return tipoGenero;
    }

    /*
     * Devuelve el tipo de plataforma de un videojuego
     */
    public TipoPlataforma getTipoPlataforma() {
        return tipoPlataforma;
    }
    
    /*
     * Devuelve la puntuación de un videojuego
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /*
     * Devuelve los dias de alquiler de un videojuego
     */
    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public String getFoto() {
        return foto;
    }

    public Map<Integer, Comentario> getComentarios() {
        return comentarios;
    }
    
    
    
    /*
     * Devuelve si un videojuego está disponible
     */
    public boolean isDisponible(){
        return disponible;
    }
    
    
    /*
     * Dado un codigo válido, se alquila el videojuego si queda stock
     */
    public boolean alquilarVideojuego(int codigo){
        if((this.codigo == codigo) && (stock > 0)){
            stock--;
            return true;
        }
        return false;
    }
    
    /*
     * Dado un codigo válido, se devuelve el videojuego
     */
    public boolean devolverVideojuego(int codigo){
        if(this.codigo == codigo){
            stock++;
            return true;
        }
        return false;
    }
    
    /*
     * Añade un comentario a un juego en concreto
     */
    public void anyadirComentario(String texto){
        Comentario comentario = new Comentario(contadorComentarios,texto);      
        comentarios.put(contadorComentarios,comentario);
        contadorComentarios++;
    }
    
    /*
     * Elimina un comentario en un juego en concreto
     */
    public boolean eliminarComentario(int codigo){
        return true;
    }
    
     /*
     * Lista una breve información de un videojuego (nivel Usuario)
     */
    public String listarBreveInformacion(){
        return codigo + SEPARACION + nombre + SEPARACION + precio + SEPARACION
                + tipoGenero + SEPARACION + tipoPlataforma + SEPARACION 
                + puntuacion;
     
    }
    
    /*
     * Lista una extensa información de un videojuego (nivel Administrador)
     */
    public String listarExtensaInformacion(){
        return codigo + SEPARACION + nombre + SEPARACION + precio + SEPARACION
                + tipoGenero + SEPARACION + tipoPlataforma + SEPARACION 
                + puntuacion + SEPARACION + stock +SEPARACION + 
                diasAlquiler + SEPARACION + foto + SEPARACION + 
                disponible;
    }  
}
