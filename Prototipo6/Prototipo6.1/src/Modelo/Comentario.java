/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alvaro
 */
public class Comentario {
    
    //Constantes
    private final String VACIO = "";
    
    //Variables
    private int codigo;
    private String texto;
    
    /*
     * Instancia el comentario con un identificador incremental y con el texto
     */
    public Comentario(int codigo, String texto){
        this.codigo = codigo;
        this.texto = texto;
    }
    
    /*
     * Dado un codigo, modifica el texto y devuelve el resultado
     */
    public String modificarComentario(int codigo, String texto){
        return VACIO;
    }
    
    /*
     * Dado un codigo, elimina el texto
     */
    public boolean borrarComentario (int codigo){
        return true;
    }
    
    /*
     * Devuelve el comentario
     */
    public String mostrarComentario(int codigo){
        if(this.codigo == codigo){
            return texto;
        }
        return VACIO;
        
    }
}
