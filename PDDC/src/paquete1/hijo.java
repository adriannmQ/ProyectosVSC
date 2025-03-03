package paquete1;

public class hijo extends padre{
protected double edad;
    
    protected hijo(String nombre, String dni, double edad) {
        super(nombre, dni); //Utiliza el constructor del padre
        this.edad = edad;
    }

    protected double getEdad() {
        return edad;
    }

    protected void setEdad(double edad) {
        this.edad = edad;
    }
}
