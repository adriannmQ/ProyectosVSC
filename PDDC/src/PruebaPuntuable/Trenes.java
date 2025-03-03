package PruebaPuntuable;

public abstract class Trenes {
	protected String nombre;
	protected double precioBase;
	protected int velocidadMax;
	protected String confort;

	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPrecioBase() {
		return precioBase;
	}



	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}



	public int getVelocidadMax() {
		return velocidadMax;
	}



	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}



	public String getConfort() {
		return confort;
	}



	public void setConfort(String confort) {
		this.confort = confort;
	}



	public abstract double calcularPrecio(double distancia, boolean idaYVuelta);
}
