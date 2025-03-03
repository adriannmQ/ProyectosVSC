package Proyecto2EV;

import java.util.ArrayList;
import java.util.Scanner;

public class gestionUsuarios {

	public static void gestion(ArrayList <usuarios> arrayUsuarios) {
		final  String admin = "admin";
		boolean encontrado = false;
		Scanner sc = new Scanner(System.in);
		do {
			menus.UserMenu();
			int opcionMenuUsuario = sc.nextInt();
			switch (opcionMenuUsuario) {
				case 1:
					crearUsuario(sc, arrayUsuarios);
					break;
				case 2:
					crearUsuarioAdmin(sc, arrayUsuarios, admin);
					break;
				case 3:
					encontrado = inicioSesion(sc, arrayUsuarios);
					break;
				case 4:
					eliminarUsuario(sc, arrayUsuarios);
					break;
				default:
					System.out.println("La opcion que has marcado no es valida");
					break;
			}
		} while (!encontrado);
	}

    public static void crearUsuario(Scanner sc, ArrayList<usuarios> arrayUsuarios) {
		// Esto es para crear y guardar usuarios en la base de datos
		System.out.println("Ingresa el nombre de usuario que quieras usar");
		String usuario = sc.next();
		if (buscarUsuarioDuplicado(usuario, arrayUsuarios)) {
			// Esta linea es para distinguir si el usuario ya está creado, para no dejarle crear otro con el mismo nombre
			System.out.println("El usuario que intenta agregar ya existe");
		} else {
			System.out.println("Ingresa la contraseña");
			String contraseña = sc.next();
			usuarios user = new usuarios(usuario, contraseña, false);
				arrayUsuarios.add(user);
			System.out.println("El usuario ha sido añadido con exito");
		}
	}

	public static void crearUsuarioAdmin(Scanner sc, ArrayList<usuarios> arrayUsuarios, final String admin) {
		// Esto es para crear y guardar usuarios en la base de datos
		System.out.println("Ingresa el nombre de usuario que quieras usar");
		String usuario = sc.next();
		if (buscarUsuarioDuplicado(usuario, arrayUsuarios)) {
			// Esta linea es para distinguir si el usuario ya está creado, para no dejarle crear otro con el mismo nombre
			System.out.println("El usuario que intenta agregar ya existe");
		} else {
			System.out.println("Ingresa la contraseña");
			String contraseña = sc.next();
			System.out.println("Ingresa el codigo secreto para ser administrador");
			String codigo = sc.next();
			if (!codigo.equals(admin)) {
				System.out.println("El codigo secreto no es correcto");
			} else {
				usuarios user = new usuarioAdmin(usuario, contraseña, true);
				arrayUsuarios.add(user);
				System.out.println("El usuario con permisos de administrador ha sido añadido con exito");
			}
		}
	}

    public static boolean inicioSesion(Scanner sc, ArrayList <usuarios> arrayUsuarios) {
		// Esto es para iniciar sesion
		System.out.println("Ingresa tu nombre de usuario");
		String usuario = sc.next();
		System.out.println("Ingresa tu contraseña");
		String contraseña = sc.next();
		boolean encontrado = false;
		for (usuarios user : arrayUsuarios) {
			if (user.getUsuario().equals(usuario) && user.getContraseña().equals(contraseña)) {
				System.out.println("Bienvenido " + usuario);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Usuario o contraseña incorrectos");
		}
		return encontrado;
	}

    public static boolean buscarUsuarioDuplicado(String usuario, ArrayList<usuarios> arrayUsuarios) {
        // Esto es para buscar si el usuario ya está creado
        boolean encontrado = false;
        for (usuarios user : arrayUsuarios) {
            if (user.getUsuario().equals(usuario)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public static void eliminarUsuario(Scanner sc, ArrayList<usuarios> arrayUsuarios) {
        // Esto es para eliminar usuarios
        System.out.println("Ingresa el nombre de usuario que quieras eliminar");
        String usuario = sc.next();
		if (!buscarUsuarioDuplicado(usuario, arrayUsuarios)) {
			System.out.println("El usuario que intenta eliminar no existe");
		}else{
        	for (usuarios user : arrayUsuarios) {
				System.out.println("Dime la contraseña del usuario que quieres eliminar");
				String contraseña = sc.next();
				if (user.getContraseña().equals(contraseña)) {
						arrayUsuarios.remove(user);
						System.out.println("El usuario ha sido eliminado con exito");
						break;
				}else{
						System.out.println("La contraseña no es correcta");
						break;
				}
			}
		}
    }


}


    
    

