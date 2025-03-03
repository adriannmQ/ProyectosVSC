package Proyecto2EV;

import java.util.ArrayList;
import java.util.Scanner;

import Proyecto2EV.entidades.libros;
import Proyecto2EV.entidades.menus;
import Proyecto2EV.interfaces.mainOptions;
import Proyecto2EV.interfaces.prestar;
import Proyecto2EV.logica.mainOptionsImp;
import Proyecto2EV.logica.prestarImp;


public class mainMenu {

    public static void paginaPrincipal(ArrayList <libros> arrayLibros) {
        Scanner sc = new Scanner(System.in);
        mainOptions mainOptions = new mainOptionsImp();
        prestar prestar  = new prestarImp();
        int opcionMenu;
        do{
            menus.menuPrincipal();
           opcionMenu = sc.nextInt();
           switch (opcionMenu) {
            case 1: mainOptions.insertarLibro(arrayLibros, sc);
                break;
            case 2: mainOptions.Modificarlibro(arrayLibros, sc);
                break;
            case 3: mainOptions.eliminarLibro(arrayLibros, sc);
                break;
            case 4: prestar.prestarMenu(arrayLibros, sc);
                break;
            case 5: mainOptions.mostrarInformacionLibro(arrayLibros, sc);
                break;    
            case 6:
                mainOptions.mostrarLibros(arrayLibros, sc);
                break;    
            case 7:
                System.out.println("Un placer serte util");
                break;
            default:
                System.out.println("La opcion que has marcado no es valida");
                break;
            }
        }while(opcionMenu != 7);
        
    }
        
	

}
