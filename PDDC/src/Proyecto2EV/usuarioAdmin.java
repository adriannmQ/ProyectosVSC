package Proyecto2EV;

public class usuarioAdmin extends usuarios {
    

    public usuarioAdmin(String usuario, String contrasena, boolean admin) {
        super(usuario, contrasena, admin);  
        this.admin = true;
    }



}
