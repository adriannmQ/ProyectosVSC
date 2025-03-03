package Proyecto2EV.logica;
import java.util.ArrayList;
import java.util.Scanner;

import Proyecto2EV.entidades.libros;
import Proyecto2EV.entidades.menus;
import Proyecto2EV.interfaces.mainOptions;
import Proyecto2EV.interfaces.validadoresLibros;

public class mainOptionsImp implements mainOptions {
    
    @Override
    public void insertarLibro(ArrayList <libros> arrayLibros, Scanner sc) {
        System.out.println("Introduce el ISBN del libro");
        String isbn = sc.next();
        validadoresLibros validadoresLibros = new validadoresLibrosImp();
        if (validadoresLibros.validarISBN(isbn)) {
            if (!validadoresLibros.buscarLibro(isbn, arrayLibros)) {
                System.out.println("Introduce el titulo del libro");
                    String nombre = sc.next();
                System.out.println("Introduce el autor del libro");
                    String autor = sc.next();
                System.out.println("Introduce el genero del libro");
                    String genero = sc.next();
                System.out.println("Introduce el numero de copias del libro");
                    int cantidad = sc.nextInt();
                    if (cantidad < 0) {
                        System.out.println("El numero de copias no puede ser negativo");
                        return;
                    }
                    int prestado = 0;
                    libros libro = new libros(isbn, nombre, autor, genero, prestado, cantidad);
                    arrayLibros.add(libro);
                    System.out.println("El libro ha sido añadido con exito");
            } else {
                System.out.println("El libro ya esta en la base de datos");
            }
        } else {
            System.out.println("El ISBN no es valido");
        }
    }

    @Override
    public void Modificarlibro(ArrayList <libros> arrayLibros, Scanner sc) {
        System.out.println("Introduce el ISBN del libro que quieres modificar");
        String isbn = sc.next();
        validadoresLibros validadoresLibros = new validadoresLibrosImp();
        if (validadoresLibros.validarISBN(isbn)) {
            if (validadoresLibros.buscarLibro(isbn, arrayLibros)) {
                for (libros libro : arrayLibros) {
                    if (libro.getIsbn().equals(isbn)) {
                        menus.modificarMenu();
                        int opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Introduce el titulo del libro");
                                libro.setNombre(sc.next());
                                System.out.println("El libro ha sido modificado con exito");
                                break;
                            case 2:
                                System.out.println("Introduce el autor del libro");
                                libro.setAutor(sc.next());
                                System.out.println("El libro ha sido modificado con exito");
                                break;
                            case 3:
                                System.out.println("Introduce el numero de copias del libro");
                                libro.setCantidad(sc.nextInt());
                                System.out.println("El libro ha sido modificado con exito");
                                break;
                            case 4:
                                System.out.println("Introduce el genero del libro");
                                libro.setGenero(sc.next());
                                System.out.println("El libro ha sido modificado con exito");
                                break;
                            case 5:
                                System.out.println("Saliendo del menu de modificacion");
                                break;
                            default:
                                System.out.println("La opcion que has marcado no es valida");
                                break;
                        }
                    }
                }
            } else {
                System.out.println("El libro no esta en la base de datos");
            }
        } else {
            System.out.println("El ISBN no es valido");
        }
    }

    @Override
    public void eliminarLibro( ArrayList <libros> arrayLibros, Scanner sc) {
        System.out.println("Introduce el ISBN del libro que quieres eliminar");
        String isbn = sc.next();
        validadoresLibros validadoresLibros = new validadoresLibrosImp();
        if (validadoresLibros.validarISBN(isbn)) {
            if (validadoresLibros.buscarLibro(isbn, arrayLibros)) {
                for (libros libro : arrayLibros) {
                    if (libro.getIsbn().equals(isbn)) {
                        arrayLibros.remove(libro);
                        System.out.println("El libro ha sido eliminado con exito");
                        break;
                    }
                }
            } else {
                System.out.println("El libro no esta en la base de datos");
            }
        } else {    
            System.out.println("El ISBN no es valido");
        }
    }

    @Override
    public void mostrarInformacionLibro(ArrayList <libros> arrayLibros, Scanner sc) {
        System.out.println("Introduce el ISBN del libro que quieres ver");
        String isbn = sc.next();
        validadoresLibros validadoresLibros = new validadoresLibrosImp();
        if (validadoresLibros.validarISBN(isbn)) {
            if (validadoresLibros.buscarLibro(isbn, arrayLibros)) {
                for (libros libro : arrayLibros) {
                    if (libro.getIsbn().equals(isbn)) {
                        System.out.println("ISBN: " + libro.getIsbn());
                        System.out.println("Nombre: " + libro.getNombre());
                        System.out.println("Autor: " + libro.getAutor());
                        System.out.println("Genero: " + libro.getGenero());
                        System.out.println("Copias totales: " + libro.getCantidad());
                        System.out.println("Copias prestadas: " + libro.getPrestado());
                        break;
                    }
                }
            } else {
                System.out.println("El libro no esta en la base de datos");
            }
        } else {
            System.out.println("El ISBN no es valido");
        }
    }

    @Override
    public void mostrarLibros(ArrayList <libros> arrayLibros, Scanner sc) {
        for (libros libro : arrayLibros) {
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Nombre: " + libro.getNombre());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Genero: " + libro.getGenero());
            System.out.println("Copias totales: " + libro.getCantidad());
            System.out.println("Copias prestadas: " + libro.getPrestado());
            System.out.println("\n\n");
        }
        return;
    }

}
