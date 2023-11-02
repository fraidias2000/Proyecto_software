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
    private String apellido1 = "";
    private String apellido2 = "";
    private String contrasenia = "";
    private String correoElectronico = "";
    private String direccion = "";
    private int tarjeta = 0;
    private Pedido miPedido;
    
    /*
     * Inicializa los atributos del usuario
     */
    public Usuario(String nombre, String DNI, String apellido1, 
                   String apellido2, String contrasenia, 
                   String correoElectronico, String direccion,
                   int tarjeta) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
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
    public void cambiarnombreApellidos(String nuevoNombre, String nuevoApellido1,
                                       String nuevoApellido2){
        this.nombre = nuevoNombre;
        this.apellido1 = nuevoApellido1;
        this.apellido2 = nuevoApellido2;
    
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
    public void cambiarTodaInformacion(String nuevaContrasenia, String nuevoCorreo, String nuevoNombre, String nuevoApellido1,
                                       String nuevoApellido2,String nuevaDireccion ){
        this.contrasenia = nuevaContrasenia;
        this.correoElectronico = nuevoCorreo;
        this.nombre = nuevoNombre;
        this.apellido1 = nuevoApellido1;
        this.apellido2 = nuevoApellido2;
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
     * Elimina un videojuego del pedido de un usuario
     */
    public void eliminarVideojuegoDelPedido(int codigoVideojuego){
        miPedido.eliminarVideojuego(codigoVideojuego);
    
    }
    
    /*
     * Lista toda la informacion de un usuario
     */
    public String listarInformacion(){
        return "DNI: " + DNI + "\n" + 
               "Nombre: " + nombre + "\n" + 
               "Apellido 1: " + apellido1 + "\n" + 
               "Apellido 2:" + apellido2 + "\n" + 
               "Contraseña: " + contrasenia + "\n" + 
                "Correo electronico: " + correoElectronico + "\n" + 
                "Direccion: " + direccion + "\n" + 
                "Tarjeta: " + tarjeta;
                
    }
}
