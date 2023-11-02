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
public class Usuario {
    private String DNI = ""; //SE USARÁ COMO NOMBRE USUARIO
    private String nombre = "";
    private String apellidos = "";
    private String contrasenia = "";
    private String correoElectronico = "";
    private String direccion = "";
    private int tarjeta = 0;
    private Pedido miPedido;
    
    /*
     * Inicializa los atributos del usuario
     */
    public Usuario(String nombre, String DNI, String apellidos, String contrasenia, 
                   String correoElectronico, String direccion,
                   int tarjeta) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        miPedido = new Pedido();
    }

    /*
     * Devuelve el DNI del usuario
     */
    public String getDNI() {
        return DNI;
    }
    /*
     * Devuelve el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }
    
    /*
     * Devuelve los apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /*
     * Devuelve el correo electronico del usuario
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /*
     * Devuelve la direccion del usuario
     */
    public String getDireccion() {
        return direccion;
    }

    /*
     * Devuelve la tarjeta del usuario
     */
    public int getTarjeta() {
        return tarjeta;
    }
    
    /*
     * Se inserta el número de la tarjeta de crédito en caso
     * de no haberla puesto al crear el usario.
     */
    public void introducirMetodoPago(int tarjeta){
        this.tarjeta = tarjeta;
    }
    
    /*
     * Cambia la contrasenia actual por la dada en los parametros
     */
    public void cambiarContrasenia(String nuevaContrasenia){
        this.contrasenia = nuevaContrasenia;
    };
    
    /*
     * Cambia el correo electronico actual por el dado en los parametros
     */
    public void cambiarCorreoElectronico(String nuevoCorreo){
        this.correoElectronico = nuevoCorreo;
    };
    
    /*
     * Cambia el nombre completo actual por el dado en los parametros
     */
    public void cambiarnombreApellidos(String nuevoNombre, String nuevoApellidos){
        this.nombre = nuevoNombre;
        this.apellidos = nuevoApellidos;
    
    };
    /*
     * Cambia la direccion actual por la dada en los parametros
     */
    public void cambiarDireccion(String nuevaDireccion){
        this.direccion = nuevaDireccion;
    }
    
    /*
     * Cambia toda la información del usuario
     */
    public void cambiarTodaInformacion(String nuevaContrasenia, String nuevoCorreo, String nuevoNombre, String nuevoApellidos,String nuevaDireccion ){
        this.contrasenia = nuevaContrasenia;
        this.correoElectronico = nuevoCorreo;
        this.nombre = nuevoNombre;
        this.apellidos = nuevoApellidos;
        this.direccion = nuevaDireccion;
    }
    
    /*
     * Añade un videojuego al pedido de un usuario
     */
    public void anyadirVideojuegoAlPedido(Usuario usuario,
                                          Videojuego nuevoVideojuego, 
                                          String fechaAlquiler, 
                                          String fechaDevolucion){
        miPedido.anyadirVideojuego(usuario, nuevoVideojuego, 
                                   fechaAlquiler, fechaDevolucion);
    
    }
    
    /*
     * Lista toda la informacion de un usuario
     */
    public String listarInformacion(){
        return "DNI: " + DNI + "\n" + 
               "Nombre: " + nombre + "\n" + 
               "Apellidos : " + apellidos + "\n" + 
               "Contraseña: " + contrasenia + "\n" + 
                "Correo electronico: " + correoElectronico + "\n" + 
                "Direccion: " + direccion + "\n" + 
                "Tarjeta: " + tarjeta;
                
    }
}
