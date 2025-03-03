package Proyecto2EV.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import Proyecto2EV.entidades.libros;

public interface prestar {
    //aquí se declaran los métodos que se van a implementar en la clase que implemente esta interfaz
    public void prestarMenu(ArrayList<libros> arrayLibros, Scanner sc);
    public void prestarLibro(ArrayList <libros> arrayLibros, Scanner sc);
    public void devolverLibro(ArrayList <libros> arrayLibros, Scanner sc);

}
