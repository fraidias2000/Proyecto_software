package prototipo1;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
    private final int DIAS_ALQUILER_POR_DEFECTO = 5;
    private final int PUNTUACION_POR_DEFECTO = 0;
    
    //Constantes tipo de genero
    private final String ACCION = "accion";
    private final String DEPORTES = "deporte";
    private final String TERROR = "terror";
    private final String LUCHA = "lucha";
    
    //Constantes tipo de plataforma
    private final String WINDOW = "window";
    private final String PS4 = "ps4";
    private final String XBOX = "xbox";
    
    /*
     * Inicializa la agencia con los videojuegos, direccion y telefono 
     * almacenado en la BD
     */
    public Agencia(String ficheroVideojuegos, String direccion, long telefono) throws IOException{
        Scanner scanerVideojuegos = new Scanner(new File(ficheroVideojuegos)); 
        misUsuarios = new HashMap<Integer, Usuario>();
        misVideojuegos = new HashMap<Integer, Videojuego>();
        this.direccion = direccion;
        this.telefono = telefono;
        leerColeccionVideojuegos(scanerVideojuegos);
    }

    /*
     * Lee los videojuegos de un fichero y los añade al modelo
     */
    private void leerColeccionVideojuegos(Scanner ficheroVideojuegos){
        while(ficheroVideojuegos.hasNextLine()) {          
            String linea = ficheroVideojuegos.nextLine();
            String[] partes = linea.split(",");
             
            int codigo = Integer.parseInt(partes[0]);
            String nombreVideojuego = partes[1];
            int precio =  Integer.parseInt(partes[2]);
            TipoGenero tipoGenero = null;
            TipoPlataforma tipoPlataforma = null;
            int stock =  Integer.parseInt(partes[5]);
            String imagenCaratula = partes[6];
             
            //Decidimos el tipo de genero
            if(partes[3].equals(ACCION)){
                tipoGenero = TipoGenero.ACCION;
            }else if(partes[3].equals(TERROR)){
                tipoGenero = TipoGenero.TERROR;
            }else if(partes[3].equals(DEPORTES)){
                tipoGenero = TipoGenero.DEPORTES;
            }else if(partes[3].equals(LUCHA)){
                tipoGenero = TipoGenero.LUCHA;
            }
             
            //Decidimos el tipo de plataforma
            if(partes[3].equals(WINDOW)){
                tipoPlataforma = TipoPlataforma.WINDOWS;
             }else if(partes[3].equals(PS4)){
                tipoPlataforma = TipoPlataforma.PS4;
            }else if(partes[3].equals(XBOX)){
                tipoPlataforma = TipoPlataforma.XBOX;
            }
            
            Videojuego videojuego = new Videojuego(codigo, nombreVideojuego, precio, 
                    tipoGenero, tipoPlataforma, PUNTUACION_POR_DEFECTO, stock, 
                    DIAS_ALQUILER_POR_DEFECTO, imagenCaratula);
            misVideojuegos.put(videojuego.getCodigo(), videojuego);
        }        
        ficheroVideojuegos.close();
    
    }   
    
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
