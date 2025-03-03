package PruebaPuntuable;

public class Billetes {
	protected Clientes cliente;
	protected Trenes tren;
	protected Trayecto trayecto;
	protected boolean idaYVuelta;
	protected double precio;

	public Billetes(Clientes cliente, Trenes tren, Trayecto trayecto, boolean idaYVuelta) {
		this.cliente = cliente;
		this.tren = tren;
		this.trayecto = trayecto;
		this.idaYVuelta = idaYVuelta;
		this.precio = tren.calcularPrecio(trayecto.getDistancia(), idaYVuelta);
	}

	public Clientes getCliente() {
		return cliente;
	}

	public Trenes getTren() {
		return tren;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public boolean isIdaYVuelta() {
		return idaYVuelta;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	 public String toString() {
        String tipoBillete = "No";
        if (idaYVuelta) {
            tipoBillete = "Sí";
        }
        return "Billete: Cliente=" + cliente.getNombre() +
               ", Tren=" + tren.getNombre() +
               ", Trayecto=" + trayecto.getOrigen() + "-" + trayecto.getDestino() +
               ", Ida y vuelta=" + tipoBillete +
               ", Precio=" + precio;
    }
}