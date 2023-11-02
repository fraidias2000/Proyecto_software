package prototipo0;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Agencia {
    private Map <Integer, Usuario> misUsuarios ;
    private Map <Integer, Videojuego> misVideojuegos;
    private String direccion = "";
    private long telefono = 0;
    
    /*
     * Inicializa la agencia con los videojuegos, direccion y telefono 
     * almacenado en la BD
     */
    public Agencia(String videojuegos, String direccion, long telefono){
    }

    /*
     * Lee los videojuegos de un fichero y los añade al modelo
     */
    private void leerColeccionVideojuegos(Scanner ficheroVideojuegos){}   
    
    /*
     * Devuelve verdad si dado un DNI y un código válido, el videojuego está
     * disponible y se ha podido alquilar.
     */
    public boolean alquilarVideojuego(String DNI, int codigoVideojuego){
        return true;
    }
    
    
    /*
     * Devuelve verdad si dado un DNI y un código válido, el videojuego está
     * ocupado y se ha podido devolver.
     */
    public boolean devolverVideojuego(String DNI, int codigoVideojuego){
        return true;
    }
    
    /*
     * Devuelve una lista con toda la informacion de los videojuegos alquilados
     */
    public String verJuegosAlquilados(){
        return "";
    }
    
    /*
     * Devuelve una lista con toda la informacion de los videojuegos disponibles
     */
    public String verJuegosDisponibles(){
        return "";
    }
}
