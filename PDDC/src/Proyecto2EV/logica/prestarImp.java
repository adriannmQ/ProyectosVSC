package Proyecto2EV.logica;

import java.util.ArrayList;
import java.util.Scanner;

import Proyecto2EV.entidades.libros;
import Proyecto2EV.entidades.menus;
import Proyecto2EV.interfaces.prestar;
import Proyecto2EV.interfaces.validadoresLibros;

public class prestarImp implements prestar {

    public void prestarMenu(ArrayList<libros> arrayLibros, Scanner sc) {
        int opcion;
        do {
            menus.menuPrestar();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    prestarLibro(arrayLibros, sc);
                    break;
                case 2:
                    devolverLibro(arrayLibros, sc);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 3);
    }

    public void prestarLibro(ArrayList <libros> arrayLibros, Scanner sc) {
        System.out.println("Introduce el ISBN del libro que quieres prestar");
        String isbn = sc.next();
        validadoresLibros validadoresLibros = new validadoresLibrosImp();
        if (validadoresLibros.validarISBN(isbn)) {
            if (validadoresLibros.buscarLibro(isbn, arrayLibros)) {
                for (libros libro : arrayLibros) {
                    if (libro.getIsbn().equals(isbn)) {
                        System.out.println("Introduce la cantidad de libros que quieres prestar");
                            int cantidad = sc.nextInt();
                            if (cantidad<=libro.getCantidad()) {
                                if(cantidad>0){
                                    if (+libro.getCantidad() - libro.getPrestado() - cantidad >= 0) {
                                        libro.setPrestado(libro.getPrestado() + cantidad);
                                        System.out.println("El libro/libros ha sido prestado con exito");
                                        break;
                                    }else{
                                        System.out.println("No se puede prestar mas libros de los que hay en la biblioteca");}
                                    }else{
                                        System.out.println("No se puede prestar libros negativos o 0");
                                    }
                            } else {
                                System.out.println("No se puede prestar mas libros de los que hay en la biblioteca");
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

    public void devolverLibro(ArrayList <libros> arrayLibros, Scanner sc) {
        System.out.println("Introduce el ISBN del libro que quieres devolver");
        String isbn = sc.next();
        validadoresLibros validadoresLibros = new validadoresLibrosImp();
        if (validadoresLibros.validarISBN(isbn)) {
            if (validadoresLibros.buscarLibro(isbn, arrayLibros)) {
                for (libros libro : arrayLibros) {
                    if (libro.getPrestado() > 0) {
                        if (libro.getIsbn().equals(isbn)) {
                            System.out.println("Introduce la cantidad de libros que quieres devolver");
                                int cantidad = sc.nextInt();
                                if (cantidad<=libro.getCantidad()) {
                                    if(cantidad>0){
                                        if ( libro.getPrestado()<=cantidad ) {
                                            libro.setPrestado(libro.getPrestado() - cantidad);
                                            System.out.println("El libro/libros ha sido devuelto con exito");
                                            break;
                                        }else{
                                            System.out.println("No se pueden devolver mas libros de los que hay prestaddos");}
                                        }else{
                                            System.out.println("No se puede devolver libros negativos o 0");
                                        }
                                } else {
                                    System.out.println("No se puede devolver mas libros de los que hay registrados en la biblioteca");
                                }
                        }
                    } else {
                        System.out.println("No hay libros prestados de con ese ISBN");
                        break;
                    }
                }
            } else {
                System.out.println("El libro no esta en la base de datos o no hay libros prestados");
            }
        } else {
            System.out.println("El ISBN no es valido");
        }
    }

}
