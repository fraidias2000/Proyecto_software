package Modelo;
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
    private Map <String, Usuario> misUsuarios ;
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
    
    //Variables necesarias para instanciar/eliminar videojuegos
    private int codigo = 0;
    private String nombreVideojuego = "";
    private double precio = 0;
    private TipoGenero tipoGenero = null;
    private TipoPlataforma tipoPlataforma = null;
    private int stock = 0;
    private String imagenCaratula = "";
    
    /*
     * Inicializa la agencia con los videojuegos, direccion y telefono 
     * almacenado en la BD
     */
    public Agencia(String ficheroVideojuegos, String direccion, 
                   long telefono) throws IOException{
        Scanner scanerVideojuegos = new Scanner(new File(ficheroVideojuegos)); 
        misUsuarios = new HashMap<String, Usuario>();
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
             
            codigo = Integer.parseInt(partes[0]);
            nombreVideojuego = partes[1];
            precio =  Double.parseDouble(partes[2]);
            stock =  Integer.parseInt(partes[5]);
            imagenCaratula = partes[6];
             
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
            if(partes[4].equals(WINDOW)){
                tipoPlataforma = TipoPlataforma.WINDOWS;
             }else if(partes[4].equals(PS4)){
                tipoPlataforma = TipoPlataforma.PS4;
            }else if(partes[4].equals(XBOX)){
                tipoPlataforma = TipoPlataforma.XBOX;
            }
            
            Videojuego videojuego = new Videojuego(codigo, nombreVideojuego, 
                                                   precio, tipoGenero, 
                                                   tipoPlataforma, 
                                                   PUNTUACION_POR_DEFECTO, 
                                                   stock, 
                                                   DIAS_ALQUILER_POR_DEFECTO, 
                                                   imagenCaratula);
            misVideojuegos.put(videojuego.getCodigo(), videojuego);
        }        
        ficheroVideojuegos.close();
    
    }   
    
    /*
     * Dados los datos necesarios, se da de alta un nuevo videojuego en el 
     * sistema
     */
    public void darDeAltaVideojuego(int codigo, String nombreVideojuego,
                                    int precio, String tipoGenero, 
                                    String tipoPlataforma, int puntuacion, 
                                    int stock, int diasAlquilerPorDefecto, 
                                    String imagenCaratula){
    }
    
    /*
     * Dado el código identificador, se elimina el videojuego del sistema
     */
    public void darDeBajaVideojuego(int codigo){
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
    
    /*
     *Registrar un usuario en el sistema
     */
    public void registrarUsuario(String nombre,String DNI, String apellidos,
                                 String contrasenia, 
                                 String correoElectronico, String direccion,
                                 int tarjeta){
        Usuario usuario = new Usuario(nombre,DNI, apellidos, contrasenia, 
                                      correoElectronico, direccion, tarjeta);
        misUsuarios.put(usuario.getDNI(),usuario);
        
    }
    /*
     *Eliminar un usuario en el sistema
     */
    public void eliminarUsuario(String DNI){
        misUsuarios.remove(DNI);
    }
    
    /*
     * Dado un usuario, muestra su información
     */
    public String mostrarInformacionUsuario(String DNI){
        return misUsuarios.get(DNI).listarInformacion();
    }
}
