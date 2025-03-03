package PruebaPuntuable;

public class AVLO extends Trenes {
	public AVLO() {
        this.nombre = "AVLO";
        this.precioBase = 50;
    }

    @Override
    public double calcularPrecio(double distancia, boolean idaYVuelta) {
        double precio = distancia * 0.2 + precioBase;
        if (idaYVuelta) {
            precio = precio * 1.7;
        }
        return precio;
    }
}