package Proyecto2EV;

public class usuarios {
    private String usuario;
    private String contraseña;
    protected boolean admin = false;

    // Constructor

    public usuarios (){

    }

    public usuarios(String usuario, String contraseña, boolean admin) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.admin = admin;
    }

    // Getters and setters (if needed)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmind(boolean admin) {
        this.admin = admin;
    }
}
