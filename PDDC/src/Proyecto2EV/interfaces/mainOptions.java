package Proyecto2EV.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import Proyecto2EV.entidades.libros;

public interface mainOptions {
        //aquí se declaran los métodos que se van a implementar en la clase que implemente esta interfaz
        public void insertarLibro(ArrayList <libros> arrayLibros, Scanner sc);
        public void Modificarlibro(ArrayList <libros> arrayLibros, Scanner sc);
        public void eliminarLibro(ArrayList <libros> arrayLibros, Scanner sc);
        public void mostrarInformacionLibro(ArrayList <libros> arrayLibros, Scanner sc);
        public void mostrarLibros(ArrayList <libros> arrayLibros, Scanner sc);
        

}
