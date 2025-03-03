package Proyecto2EV.entidades;

public class usuarioAdmin extends usuarios {
    //aqui pongo una herencia de la clase de usuarios para indicar que es un usuario admin y ponerle el valor de admin a true 

    public usuarioAdmin(String usuario, String contrasena, boolean admin) {
        super(usuario, contrasena, admin);  
        this.admin = true;
    }



}
