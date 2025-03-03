package paquete1;

public class padre {
    protected String nombre;
    protected String dni;

    protected padre(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = "47554952Z";
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getDni() {
        return dni;
    }

    protected void setDni(String dni) {
        this.dni = dni;
    }
}
