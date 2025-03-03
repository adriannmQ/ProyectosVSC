package PruebaPuntuable;
import java.util.ArrayList;

public class Clientes {
	protected String nombre;
	protected String dni;
	protected ArrayList<Billetes> billetes;

    public Clientes(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.billetes = new ArrayList<>();
    }

    

    public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public ArrayList<Billetes> getBilletes() {
		return billetes;
	}



	public void setBilletes(ArrayList<Billetes> billetes) {
		this.billetes = billetes;
	}



	public void agregarBillete(Billetes billete) {
        billetes.add(billete);
    }

    public void mostrarBilletes() {
        if (billetes.isEmpty()) {
            System.out.println("No tiene billetes reservados.");
        } else {
            System.out.println("Billetes de " + nombre + ":");
            for (Billetes b : billetes) {
                System.out.println(b);
            }
        }
    }
}
	