package Proyecto2EV.interfaces;

import java.util.ArrayList;

import Proyecto2EV.entidades.libros;

public interface validadoresLibros {
    //aquí se declaran los métodos que se van a implementar en la clase que implemente esta interfaz
    public boolean buscarLibro(String isbn,  ArrayList <libros> arrayLibros);
    public boolean validarISBN(String isbn);
}

