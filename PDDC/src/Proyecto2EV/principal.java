package Proyecto2EV;

import java.util.ArrayList;
public class principal {
    public static void main(String[] args) {
		ArrayList <libros> arrayLibros = new ArrayList <libros> ();
		ArrayList <usuarios> arrayUsuarios = new ArrayList <usuarios> ();
		usuarios admin = new usuarioAdmin("admin", "admin", true);
		arrayUsuarios.add(admin);
		libros libro1 = new libros("9780765311788", "El Quijote", "Cervantes", "Novela", 0, 5);
		arrayLibros.add(libro1);
		libros libro2 = new libros("9788499890957", "El nombre del viento", "Patrick Rothfuss", "Fantasia", 0, 3);
		arrayLibros.add(libro2);
		gestionUsuarios.gestion(arrayUsuarios);
		mainMenu.paginaPrincipal(arrayLibros);
		//Preguntas kuro
		//Como hacer el bucle para buscar todos los libros
		//Como meter las interfaces
	}

}


