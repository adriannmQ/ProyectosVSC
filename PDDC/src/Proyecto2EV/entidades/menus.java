package Proyecto2EV.entidades;
import java.util.Scanner;  
public class menus {
    static Scanner sc = new Scanner(System.in);
    //en esta clase se encuentran los menus que se van a mostrar en la aplicacion
    public static void menuPrincipal() {
        System.out.println("Menu de opciones");
        System.out.println("1.- Insertar un nuevo libro");
        System.out.println("2.- Modificar datos de un libro existente");
        System.out.println("3.- Quitar un libro");
        System.out.println("4.- Realizar la prestacion o devolucion de un libro");
        System.out.println("5.- Ver el estado/informacion de un libro");
        System.out.println("6.- Ver todos los libros");
        System.out.println("7.- Salir\n");
    }

    public static void UserMenu() {
        System.out.println("\nMenu de opciones de usuario");
        System.out.println("1.- Crear usuario");
        System.out.println("2.- Crear usuario con privilegios de administrador");
        System.out.println("3.- Iniciar sesion con un usuario existente");
        System.out.println("4.- Eliminar usuario\n");
    }
        
    public static void prestarMenu() {
        System.out.println("Menu de opciones de prestamiento de libros");
        System.out.println("1.- Prestar un libro");
        System.out.println("2.- Devolver un libro");
        System.out.println("3.- Salir\n");
    }

    public static void modificarMenu() {
        System.out.println("Que es lo que quieres modificar?");
        System.out.println("1.- El nombre de el libro ");
        System.out.println("2.- El autor de el libro ");
        System.out.println("3.- La cantidad de copias de el libro ");
        System.out.println("4.- El genero de el libro ");
        System.out.println("5.- Salir\n");
    }

    public static void menuPrestar() {
        System.out.println("Introduce una opcion: ");
        System.out.println("1. Prestar libro/libros");
        System.out.println("2. Devolver libro/libros");
        System.out.println("3. Salir\n");
    }

}
