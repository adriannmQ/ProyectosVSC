package PruebaPuntuable;

public class AVANT extends Trenes {
	public AVANT() {
        this.nombre = "AVANT";
        this.precioBase = 70;
        this.confort = "Alta";
    }

    @Override
    public double calcularPrecio(double distancia, boolean idaYVuelta) {
        double precio = distancia * 0.25 + precioBase;
        if (idaYVuelta) {
            precio = precio * 1.75;
        }
        return precio;
    }
}
