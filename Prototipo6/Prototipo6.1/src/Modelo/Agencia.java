package Modelo;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Agencia {
    private Map <String, Usuario> usuariosRegistrados ;
    private Map <Integer, Videojuego> videojuegosRegistrados;
    private String direccion = "";
    private long telefono = 0;
    
    //Constantes por defecto
    private final int DIAS_ALQUILER_POR_DEFECTO = 5;
    private final int PUNTUACION_POR_DEFECTO = 0;
    private final int TELEFONO_POR_DEFECTO = 000000000;
    private final String DIRECCION_POR_DEFECTO = "";
    
    public static int numeroPedidos = 0;
    
    //Constantes tipo de genero
    private final String ACCION = "accion";
    private final String DEPORTES = "deporte";
    private final String TERROR = "terror";
    private final String LUCHA = "lucha";
    
    //Constantes tipo de plataforma
    private final String WINDOW = "window";
    private final String PS4 = "ps4";
    private final String XBOX = "xbox";
    
    private final String SEPARACION = "/";
    
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
    public Agencia(String ficheroVideojuegos, String direccion, long telefono) throws IOException{
        Scanner scanerVideojuegos = new Scanner(new File(ficheroVideojuegos)); 
        usuariosRegistrados = new HashMap<String, Usuario>();
        videojuegosRegistrados = new HashMap<Integer, Videojuego>();
        this.direccion = direccion;
        this.telefono = telefono;
        leerColeccionVideojuegos(scanerVideojuegos);
    }
    
    /*
     * Constructor de Agencia sin parametros
     */
    public Agencia(){ 
        usuariosRegistrados = new HashMap<String, Usuario>();
        videojuegosRegistrados = new HashMap<Integer, Videojuego>();
        this.direccion = DIRECCION_POR_DEFECTO;
        this.telefono = TELEFONO_POR_DEFECTO;
    }
    
    /*
     * Dado un DNI válido devuelve un usuario si está registrado en el sistema
     */
    public Usuario obtenerUsuario(String DNI){
        return usuariosRegistrados.get(DNI);
    }
    
    /*
     * Dado el DNI de un usuario devuelve su pedido
     */
    public Pedido obtenerPedidoUsuario(String DNI){
        return usuariosRegistrados.get(DNI).getPedido();
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
            
            Videojuego videojuego = new Videojuego(codigo, nombreVideojuego, precio, 
                    tipoGenero, tipoPlataforma, PUNTUACION_POR_DEFECTO, stock, 
                    DIAS_ALQUILER_POR_DEFECTO, imagenCaratula);
            videojuegosRegistrados.put(videojuego.getCodigo(), videojuego);
        }        
        ficheroVideojuegos.close();  
    }   
    
    /*
     * Dados los datos necesarios, se da de alta un nuevo videojuego en el 
     * sistema
     */
    public void darDeAltaVideojuego(int codigo, String nombreVideojuego, double precio, 
                    String tipoGenero, String tipoPlataforma, int puntuacion, int stock, 
                    int diasAlquilerPorDefecto, String imagenCaratula){
        //Decidimos el tipo de genero
            if(tipoGenero.equals(ACCION)){
                this.tipoGenero = TipoGenero.ACCION;
            }else if(tipoGenero.equals(TERROR)){
                this.tipoGenero = TipoGenero.TERROR;
            }else if(tipoGenero.equals(DEPORTES)){
                this.tipoGenero = TipoGenero.DEPORTES;
            }else if(tipoGenero.equals(LUCHA)){
                this.tipoGenero = TipoGenero.LUCHA;
            }
             
            //Decidimos el tipo de plataforma
            if(tipoPlataforma.equals(WINDOW)){
                this.tipoPlataforma = TipoPlataforma.WINDOWS;
             }else if(tipoPlataforma.equals(PS4)){
                this.tipoPlataforma = TipoPlataforma.PS4;
            }else if(tipoPlataforma.equals(XBOX)){
                this.tipoPlataforma = TipoPlataforma.XBOX;
            }
        
        Videojuego videojuego = new Videojuego(codigo, nombreVideojuego, precio, 
                    this.tipoGenero, this.tipoPlataforma, puntuacion, stock, 
                    diasAlquilerPorDefecto, imagenCaratula);
        
        videojuegosRegistrados.put(videojuego.getCodigo(), videojuego);
    }
    
    /*
     * Dado el código identificador, se elimina el videojuego del sistema
     */
    public void darDeBajaVideojuego(int codigo){
        videojuegosRegistrados.remove(codigo);
    }
    
    /*
     * Devuelve verdad si dado un DNI y un código válido, el videojuego está
     * disponible y se ha podido alquilar.
     */
    public boolean alquilarVideojuego(String DNI, int codigoVideojuego){
        int anio = 0;  
        int mes = 0;  
        int dia = 0;
        String fechaAlquiler = "";
        String fechaDevolucion = "";
        Videojuego videojuegoAux = videojuegosRegistrados.get(codigoVideojuego);
        if((usuariosRegistrados.get(DNI)!= null) && (videojuegoAux != null)){
            if(videojuegosRegistrados.get(codigoVideojuego).alquilarVideojuego(codigoVideojuego)){ //Se tiene que comprobar que hay suficiente stock antes de alquilar, en caso contrario no se alquilará
               Calendar fecha = Calendar.getInstance();
               anio = fecha.get(Calendar.YEAR);  
               mes = fecha.get(Calendar.MONTH) + 1;  
               dia = fecha.get(Calendar.DAY_OF_MONTH); 
               fechaAlquiler = dia + SEPARACION + mes + SEPARACION + anio; 
               dia += videojuegosRegistrados.get(codigoVideojuego).getDiasAlquiler();
               //Comparamos para pasar al siguiente mes
               if ((dia > 31) && (mes == 1)){ //Enero
                   mes++;
                   dia = 31 - dia;
               }else if((dia > 28) && (mes == 2)){ //Febrero
                   mes++;
                   dia = 28 - dia;
               }else if((dia > 31) && (mes == 3)){ //Marzo
                   mes++;
                   dia = 31 - dia;
               }else if((dia > 30) && (mes == 4)){ //Abril
                   mes++;
                   dia = 30 - dia;
               }else if((dia > 31) && (mes == 5)){ //Mayo
                   mes++;
                   dia = 31 - dia;
               }else if((dia > 30) && (mes == 6)){ //Junio
                   mes++;
                   dia = 30 - dia;
               }else if((dia > 31) && (mes == 7)){ //Julio
                   mes++;
                   dia = 31 - dia;
               }else if((dia > 31) && (mes == 8)){ //Agosto
                   mes++;
                   dia = 31 - dia;
               }else if((dia > 30) && (mes == 9)){ //Septiembre
                   mes++;
                   dia = 30 - dia;
               }else if((dia > 31) && (mes == 10)){ //Octubre
                   mes++;
                   dia = 31 - dia;
               }else if((dia > 30) && (mes == 11)){ //Noviembre
                   mes++;
                   dia = 30 - dia;
               }else if((dia > 31) && (mes == 12)){ //Diciembre
                   mes++;
                   dia = 31 - dia;
               }
               fechaDevolucion = dia + SEPARACION + mes + SEPARACION + anio;
               usuariosRegistrados.get(DNI).anyadirVideojuegoAlPedido(usuariosRegistrados.get(DNI), videojuegoAux, fechaAlquiler, fechaDevolucion);    
               return true;
            }
            return false;
        }else{
            return false;
        }
    }
    
    /*
     * Dado un videojuego, un DNI y una fecha valida, se amplia la fecha de devolución.
     */
    public boolean ampliarFechaDevolucion(String DNI, int codigoVideojuego,String fechaDevolucion){
        Videojuego videojuegoAux = videojuegosRegistrados.get(codigoVideojuego);
        if((usuariosRegistrados.get(DNI)!= null) && (videojuegoAux != null)){
            usuariosRegistrados.get(DNI).ampliarFechaDevolucion(codigoVideojuego, fechaDevolucion);
            return true;
        }
        return false;
    }    
    
    /*
     * Devuelve verdad si dado un DNI y un código válido, el videojuego está
     * ocupado y se ha podido devolver.
     */
    public boolean devolverVideojuego(String DNI, int codigoVideojuego){
        Videojuego videojuegoAux = videojuegosRegistrados.get(codigoVideojuego);
        if((usuariosRegistrados.get(DNI)!= null) && (videojuegoAux != null)){
            if(videojuegosRegistrados.get(codigoVideojuego).devolverVideojuego(codigoVideojuego)){ //Se tiene que comprobar que se ha podido eliminar de la BD               
                usuariosRegistrados.get(DNI).eliminarVideojuegoDelPedido(videojuegoAux.getCodigo());    
                return true;
            }
            return false;
        }else{
            return false;
        }
    }
    
    /*
     * Devuelve una lista con cierta la informacion de los videojuegos alquilados
     */
    public String mostrarJuegosAlquilados(){
        String juegoAlquilados = "";
        for (Map.Entry entry : usuariosRegistrados.entrySet()) {
            Usuario usuario = (Usuario)entry.getValue();
            juegoAlquilados += usuario.mostrarInformacionPedidoUsuario();           
        }
        return juegoAlquilados;
    }
    
    /*
     * Devuelve una lista con toda la informacion de los videojuegos alquilados
     */
    public String mostrarJuegosAlquiladosNivelAdministrador(){
        String juegoAlquilados = "";
        for (Map.Entry entry : usuariosRegistrados.entrySet()) {
            Usuario usuario = (Usuario)entry.getValue();
            juegoAlquilados += usuario.mostrarInformacionPedidoAdministrador();           
        }
        return juegoAlquilados;
    }
    
    /*
     * Devuelve una lista con cierta la informacion de los videojuegos disponibles
     */
    public String mostrarJuegosDisponibles(){
        String juegosDisponibles = "";
        for (Map.Entry entry : videojuegosRegistrados.entrySet()) {
            Videojuego videojuego = (Videojuego)entry.getValue();
                     if(videojuego.isDisponible()){
                         juegosDisponibles+= videojuego.listarBreveInformacion();
                     }
        }
        return juegosDisponibles;
    }
    
    /*
     * Devuelve una lista con toda la informacion de los videojuegos disponibles 
     */
    public String mostrarJuegosDisponiblesNivelAdministrador(){
        String juegosDisponibles = "";
        for (Map.Entry entry : videojuegosRegistrados.entrySet()) {
            Videojuego videojuego = (Videojuego)entry.getValue();
                     if(videojuego.isDisponible()){
                         juegosDisponibles+= videojuego.listarExtensaInformacion();
                     }
        }
        return juegosDisponibles;
    }
    
    /*
     * Devuelve los videojuegos alquilados por un usuario en concreto a nivel usuario
     */
    public String mostrarVideojuegosDeUnUsuario(String DNI){
        return usuariosRegistrados.get(DNI).mostrarInformacionPedidoUsuario();
    }
    
    /*
     * Devuelve la información de un videojuego en concreto
     */
    public String mostrarVideojuegoConcreto (int codigoVideojuego){
        return videojuegosRegistrados.get(codigoVideojuego).listarBreveInformacion();
    }
    
    
    /*
     * Devuelve los videojuegos alquilados por un usuario en concreto a nivel administrador
     */
    public String mostrarVideojuegosDeUnUsuarioNivelAdministrador(String DNI){
        return usuariosRegistrados.get(DNI).mostrarInformacionPedidoAdministrador();
    }
    
    /*
     *Registrar un usuario en el sistema
     */
    public void registrarUsuario(String nombre,String DNI, String apellidos, String contrasenia, 
                   String correoElectronico, String direccion,
                   int tarjeta){
        Usuario usuario = new Usuario(nombre,DNI, apellidos,
                                      contrasenia, correoElectronico, 
                                      direccion, tarjeta);
        usuariosRegistrados.put(usuario.getDNI(),usuario);
        
    }
    /*
     *Eliminar un usuario en el sistema
     */
    public void eliminarUsuario(String DNI){
        usuariosRegistrados.remove(DNI);
    }
    
    /*
     * Dado un usuario, muestra su información
     */
    public String mostrarInformacionUsuario(String DNI){
        return usuariosRegistrados.get(DNI).listarInformacion();
    }
    
    /*
     * Dado un comentario y un código de videojuego válido
     */
    public void ponerComentarioVideojuego(int codigoVideojuego, String comentario){
        videojuegosRegistrados.get(codigoVideojuego).anyadirComentario(comentario);
    }
    
    /*
     * Dado un codigo válido elimina un comentario concreto.
     */
    public void eliminarComentarioVideojuego(int codigoVideojuego, int codigoComentario){
        videojuegosRegistrados.get(codigoVideojuego).eliminarComentario(codigoComentario);
    }
}
