package PruebaPuntuable;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
//Instancio los arraylist y el scanner 
	protected static ArrayList<Trayecto> trayectos = new ArrayList<>();
	protected static ArrayList<Clientes> clientes = new ArrayList<>();
	protected static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Menu principal
		int opcion;
		do {
			System.out.println("--- Gestión de Billetes RENFE ---");
			System.out.println("1. Crear cliente");
			System.out.println("2. Añadir trayecto");
			System.out.println("3. Dar de baja trayecto");
			System.out.println("4. Reservar billete");
			System.out.println("5. Mostrar billetes de un cliente");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine();

			if (opcion == 1) {
				crearCliente();
			} else if (opcion == 2) {
				anadirTrayecto();
			} else if (opcion == 3) {
				darDeBajaTrayecto();
			} else if (opcion == 4) {
				reservarBillete();
			} else if (opcion == 5) {
				mostrarBilletesCliente();
			} else if (opcion == 6) {
				System.out.println("Saliendo...");
			} else {
				System.out.println("Opción inválida.");
			}
		} while (opcion != 6);
	}

//Metodo para crear cliente
	protected static void crearCliente() {
		String nombre, dni;
		do {
			System.out.print("Nombre y primer apellido: ");
			nombre = scanner.nextLine();
			// Uso el matches para que el nombre solo use letras
			if (!nombre.matches("[\\p{L} ]+")) {
				System.out.println("El nombre solo puede contener letras. Intenta de nuevo.");
			}
		} while (!nombre.matches("[\\p{L} ]+"));
		do {
			System.out.print("DNI: ");
			dni = scanner.nextLine();
//Llamo al validador del dni, como es un booleno, me returnea un true or false
			if (!ValidadorDNI.esDNIValido(dni)) {
				System.out.println("DNI inválido, volviendo al menú principal.");
				return;
				// Metodo static que tengo abajo para que si el dni esta registrado no deje
				// registrarse.
			} else if (dniYaRegistrado(dni)) {
				System.out.println("Este DNI ya está registrado, volviendo al menú principal.");
				return;
			}
		} while (!ValidadorDNI.esDNIValido(dni) || dniYaRegistrado(dni));
		clientes.add(new Clientes(nombre, dni));
		System.out.println("Cliente creado correctamente.");
	}

//Metodo para añadir un trayecto
	protected static void anadirTrayecto() {
		System.out.print("Origen: ");
		String origen = scanner.nextLine();
		System.out.print("Destino: ");
		String destino = scanner.nextLine();
		System.out.print("Distancia: ");
		double distancia = scanner.nextDouble();
		scanner.nextLine();
		trayectos.add(new Trayecto(origen, destino, distancia));
		System.out.println("Trayecto añadido correctamente.");
	}

//Metodo para dar de baja un trayecto
	protected static void darDeBajaTrayecto() {
		System.out.print("Ingrese origen del trayecto a eliminar: ");
		String origen = scanner.nextLine();
		System.out.print("Ingrese destino del trayecto a eliminar: ");
		String destino = scanner.nextLine();
//Busco mediante un for each que haya un trayecto en el que coincida el origen y el destino, si coincide, lo elimina
		for (Trayecto t : trayectos) {
			if (t.getOrigen().equalsIgnoreCase(origen) && t.getDestino().equalsIgnoreCase(destino)) {
				trayectos.remove(t);
				System.out.println("Trayecto eliminado correctamente.");
				return;
			}
		}
		System.out.println("Trayecto no encontrado.");
	}

//Metodo para reservar billete 
	protected static void reservarBillete() {
		System.out.print("DNI del cliente: ");
		String dni = scanner.nextLine();
		Clientes cliente = null;
		// Mediante for each asigno a cliente la informacion de c
		for (Clientes c : clientes) {
			if (c.getDni().equalsIgnoreCase(dni)) {
				cliente = c;
				break;
			}
		}
		if (cliente == null) {
			System.out.println("Cliente no encontrado.");
			return;
		}

		System.out.print("Origen del trayecto: ");
		String origen = scanner.nextLine();
		System.out.print("Destino del trayecto: ");
		String destino = scanner.nextLine();

		Trayecto trayecto = null;
		// Hago lo mismo con trayecto
		for (Trayecto t : trayectos) {
			if (t.getOrigen().equalsIgnoreCase(origen) && t.getDestino().equalsIgnoreCase(destino)) {
				trayecto = t;
				break;
			}
		}
		if (trayecto == null) {
			System.out.println("Trayecto no encontrado.");
			return;
		}

		System.out.println(
				"Seleccione tipo de tren(si selecciona otra opcion no señalada se le asignara AVE): 1.AVE 2.AVLO 3.AVANT");
		int tipo = scanner.nextInt();
		scanner.nextLine();
		Trenes tren;
		if (tipo == 1) {
			tren = new AVE();
		} else if (tipo == 2) {
			tren = new AVLO();
		} else if (tipo == 3) {
			tren = new AVANT();
		} else {
			tren = new AVE();
		}
		// Con este booleano si pone true es ida y vuelta, si no solo ida. Todo esto
		// está en un toString en la clase de billetes
		System.out.print("¿Ida y vuelta? (true/false): ");
		boolean idaYVuelta = scanner.nextBoolean();

		Billetes billete = new Billetes(cliente, tren, trayecto, idaYVuelta);
		cliente.agregarBillete(billete);
		System.out.println(billete);
	}

//Metodo para mostrar billetes de un cliente
	protected static void mostrarBilletesCliente() {
		System.out.print("Ingrese DNI del cliente: ");
		String dni = scanner.nextLine();
		// For each para buscar el cliente, si no tiene billetes le salta un mensaje,
		// ese metodo esta en la clase clientes
		for (Clientes c : clientes) {
			if (c.getDni().equalsIgnoreCase(dni)) {
				c.mostrarBilletes();
				return;
			}
		}
		System.out.println("Cliente no encontrado.");
	}

//Lo hago static porque si lo llamas sin crear una instancia de Cliente da error.
	protected static boolean dniYaRegistrado(String dni) {
		for (Clientes c : clientes) {
			if (c.getDni().equalsIgnoreCase(dni)) {
				return true;
			}
		}
		return false;
	}
}
