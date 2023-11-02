/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo1;

/**
 *
 * @author Alvaro
 */
public class Comentario {
    int codigo;
    String texto;
    
    /*
     * Instancia el comentario con un identificador incremental y con el texto
     */
    public Comentario(int codigo, String texto){
        this.codigo = codigo;
        this.texto = texto;
    };
    
    /*
     * Dado un codigo, modifica el texto y devuelve el resultado
     */
    public String modificarComentario(int codigo, String texto){
        return "";
    };
    
    /*
     * Dado un codigo, elimina el texto
     */
    public boolean borrarComentario (int codigo){
        return true;
    };
}
