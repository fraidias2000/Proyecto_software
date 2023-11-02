/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo0;

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
    private Carrito miCarrito;

    
    /*
     * Inicializa los atributos del usuario
     */
    public Usuario(String nombre, String apellido1, 
                   String apellido2, String contrasenia, 
                   String correoElectronico, String direccion,
                   int tarjeta) {
    }
    
    /*
     * Se inserta el número de la tarjeta de crédito en caso
     * de no haberla puesto al crear el usario.
     */
    public void introducirMetodoPago(int tarjeta){}
    
    /*
     * Cambia la contrasenia actual por la dada en los parametros
     */
    public void cambiarContrasenia(int nuevaContrasenia){};
    
    /*
     * Cambia el correo electronico actual por el dado en los parametros
     */
    public void cambiarCorreoElectronico(String nuevoCorreo){};
    
    /*
     * Cambia el nombre completo actual por el dado en los parametros
     */
    public void cambiarnombreApellidos(String nuevoNombre, String nuevoApellido1,
                                       String nuevoApellido2){};
    /*
     * Cambia la direccion actual por la dada en los parametros
     */
    public void cambiarDireccion(String nuevaDireccion){}
}
