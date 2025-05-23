package Proyecto2EV.logica;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Proyecto2EV.entidades.libros;
import Proyecto2EV.interfaces.validadoresLibros;

public class validadoresLibrosImp implements validadoresLibros {


    public boolean buscarLibro(String isbn,  ArrayList <libros> arrayLibros) {
        boolean encontrado = false;
        for (libros libro : arrayLibros) {
            if (libro.getIsbn().equals(isbn)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }


    public boolean validarISBN(String isbn) {
        // Definimos un patrón para validar el ISBN-13 (13 dígitos numéricos)
        String regex = "^(978|979)\\d{10}$";//esto es para definir el formato isbn y guardarlo en regex
        Pattern pattern = Pattern.compile(regex);//esto es para declarar un patron y asignarselo a 
        Matcher matcher = pattern.matcher(isbn);//aqui compara el patron con el ISBN y define si esta bien (true) o no (false)
        return matcher.matches();//aqui devuelvo el valor
    }


}
