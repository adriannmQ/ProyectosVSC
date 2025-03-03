package PruebaPuntuable;

public class AVE extends Trenes {
	public AVE() {
        this.nombre = "AVE";
        this.precioBase = 100;
        this.velocidadMax = 300;
    }

    @Override
    public double calcularPrecio(double distancia, boolean idaYVuelta) {
        double precio = distancia * 0.3 + precioBase;
        if (idaYVuelta) {
            precio = precio * 1.8;
        }
        return precio;
    }
}