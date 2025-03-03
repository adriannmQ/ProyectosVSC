package Proyecto2EV.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import Proyecto2EV.entidades.usuarios;

public interface gestionUsuarios {
    //aquí se declaran los métodos que se van a implementar en la clase que implemente esta interfaz
    public void gestion(ArrayList <usuarios> arrayUsuarios);
    public void crearUsuario(Scanner sc, ArrayList<usuarios> arrayUsuarios);
    public void crearUsuarioAdmin(Scanner sc, ArrayList<usuarios> arrayUsuarios, final String admin);
    public boolean buscarUsuarioDuplicado(String usuario, ArrayList<usuarios> arrayUsuarios);
    public boolean inicioSesion(Scanner sc, ArrayList<usuarios> arrayUsuarios);
    public void eliminarUsuario(Scanner sc, ArrayList<usuarios> arrayUsuarios);
}
