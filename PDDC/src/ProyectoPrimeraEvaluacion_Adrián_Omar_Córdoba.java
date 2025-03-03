import java.util.Scanner;
import java.util.regex.*;

public class ProyectoPrimeraEvaluacion_Adrián_Omar_Córdoba {
        Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            boolean encontrado = false;
            final int LIBROS = 100;
            final int COLUMNAS = 5;
            String arrayLibros [][] = new String [LIBROS][COLUMNAS];
            String arrayUsuarios [][] = new String [1000][2];
            arrayUsuarios [0][0] = "admin" ;
            arrayUsuarios [0][1] = "admin" ;
            int opcionMenuGeneral;
            int opcionMenuUsuario;
            do { UserMenu();
                opcionMenuUsuario = sc.nextInt();
                switch (opcionMenuUsuario) {
                    case 1: crearUsuario(sc, arrayUsuarios);
                        break;
                    case 2: encontrado = inicioSesion(sc, arrayUsuarios);
                        break;
                    case 3: eliminarUsuario(sc, arrayUsuarios);
                        break;
                    default:
                        System.out.println("La opcion que has marcado no es valida"); 
                        break;  
            }
            } while (!encontrado);// aqui hago un bucle para iniciar sesion con un usuario, que hasta que no se inicie sesion con un usuario existente no sale de el bucle
            do{
            PrimaryMenu();
            opcionMenuGeneral = sc.nextInt();
            switch (opcionMenuGeneral) {
                case 1: insertarLibro(sc, arrayLibros);
                    break;
                case 2: Modificarlibro(sc, arrayLibros);
                    break;
                case 3: eliminarLibro(sc, arrayLibros);
                    break;
                case 4: prestarMenu(sc, arrayLibros);
                    break;
                case 5: mostrarInformacionLibro(sc, arrayLibros);
                    break;    
                case 6:
                    System.out.println("Un placer serte util");
                    break;
                default:
                    System.out.println("La opcion que has marcado no es valida");
                    break;
        }
    }while (opcionMenuGeneral != 6);// aqui una vez iniciada la sesion hago el bucle de forma que no salga hasta que el numero sea 6 (que el usuario le haya dado a salir)
}

    public static void PrimaryMenu() {
        System.out.println("Menu de opciones");
        System.out.println("1.- Insertar un nuevo libro");
        System.out.println("2.- Modificar datos de un libro existente");
        System.out.println("3.- Quitar un libro");
        System.out.println("4.- Realizar la prestacion o devolucion de un libro");
        System.out.println("5.- Ver el estado/informacion de un libro");
        System.out.println("6.- Salir");
    }

    public static void UserMenu() {
        System.out.println("Menu de opciones de usuario");
        System.out.println("1.- Crear usuario");
        System.out.println("2.- Iniciar sesion con un usuario existente");
        System.out.println("3.- Eliminar usuario");
    }

    public static void prestarMenu(Scanner sc, String arrayLibros[][]) {
        System.out.println("Menu de opciones de prestamiento de libros");
        System.out.println("1.- Prestar un libro");
        System.out.println("2.- Devolver un libro");
        System.out.println("3.- Salir");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1: prestarLibro(sc, arrayLibros);
                break;
            case 2: devolverLibro(sc, arrayLibros);
                break; 
            default:
                break;
        }
    }

    public static void crearUsuario(Scanner sc, String arrayUsuarios[][]) {//esto es para crear y guardar usuarios en la base de datos
        System.out.println("Ingresa el nombre de usuario que quieras usar");
        String usuario = sc.next();
        if(buscarDuplicado(usuario, arrayUsuarios)){//esta linea es para distinguir si el usuario ya está creado, para no dejarle crear otro con el mismo nombre
            System.out.println("El usuario que intenta agregar ya existe");
        }else{
            System.out.println("Ingresa la contraseña");
            String contraseña = sc.next();
           if( buscarEspacioLibreUsuario(arrayUsuarios, usuario, contraseña)>0){//en el caso de que el resultado de esa clase sea positivo significa que el usuario se ha creado y guardado
            System.out.println("El usuario ha sido añadido con exito");
           }else{
            System.out.println("No hay mas hueco en la base de datos para añadir usuarios");
           }
        }
    }          

    public static boolean inicioSesion(Scanner sc, String arrayUsuarios[][]) {// esta clase es para iniciar sesion co un usuario que ya esta registrado en la base de datos
        boolean encontrado = false;
        System.out.println("Ingresa el nombre de usuario ");
        String usuario = sc.next();
        System.out.println("Ingresa la contraseña");
        String contraseña = sc.next();
        for(int i=0;i<arrayUsuarios.length;i++){ {
            if(arrayUsuarios[i][0] != null){// recorro el array y en caso de que de que el usuario y la contraseña esten en la misma columna de el array se iniccia sesion

                if(arrayUsuarios[i][0].equals(usuario) & arrayUsuarios[i][1].equals(contraseña)) {
                encontrado = true;
                i=arrayUsuarios.length;
             }
          }
         }
        }
        if(encontrado) {
            System.out.println("Has iniciado sesion correctamente");
        }else{
            System.out.println("El usuario o la contraseña son incorrectos");
        }
        return encontrado;
    }

    public static void eliminarUsuario(Scanner sc, String arrayUsuarios [][]) {//esta clase es para eliminar un usuario previamente creado
        System.out.println("Dime el nombre de el usuario que quires eliminar");
        String usuario = sc.next();
        if(!buscarDuplicado(usuario, arrayUsuarios)){// en caso de que no existe el usuario no lo puedes borrar, dado que no existe 
            System.out.println("El usuario que intenta eliminar no existe");
        }else
            System.out.println("Ingresa la contraseña");
            String contraseña = sc.next();
            for(int i=0;i<arrayUsuarios.length;i++) {
                if(arrayUsuarios[i][0]!=null) {// aqui si el usuario y la contraseña coinciden elimino el usuario y la contraseña
                    if( arrayUsuarios[i][0].equals(usuario) & arrayUsuarios[i][1].equals(contraseña)){
                        arrayUsuarios[i][0] = null;
                        arrayUsuarios[i][1] = null;
                        System.out.println("El usuario ha sido eliminado con exito");
                    }else{
                        System.out.println("La contraseña es incorrecta");
                    }
                }
            }
        }    

    public static void insertarLibro(Scanner sc, String arrayLibros [][]) {// esta clase es para añadir un libro a la base de datos de libros
        int posicion;
        System.out.println("Dime el ISBN de el libro que quieres ingresar ");
        String ISBN = sc.next();
        if (validarISBN(ISBN)){// aqui valido que lo que me esta poniendo sea un ISBN y no un numero cualquiera
        if(buscarDuplicado(ISBN, arrayLibros)) {// aqui valido que no puedas meter un libro es cual ya estaba añadido previamente
          System.out.println("El ISBN de el libro que has ingresado ya esta metido en la base de datos.");
        }
        else {
            posicion = buscarEspacioLibreLibro(arrayLibros);
            if(posicion<0) {//aqui si la posicion es negativas significa que no hay espacio para meter un usuario nuevo
         System.out.println("No hay espacio");
        }
            else {// aqui le digo al usuario que guarde todos los datos relevantes a el libro
            arrayLibros[posicion][0] = ISBN;
          System.out.println("Dime como se llama el libro que vas a ingresar ");
            arrayLibros[posicion][1]=sc.next();
          System.out.println("Dime quien es el autor del libro que vas a ingresar ");
            arrayLibros[posicion][2]=sc.next();
          System.out.println("Dime en que fecha se publico este libro (dd/mm/yyyy)");
            arrayLibros[posicion][3]=sc.next();
          System.out.println("El libro ha sido guardado correctamente ");
            arrayLibros[posicion][4] = "sinprestar";
                }
            }
        }else{
            System.out.println("Este ISBN no es válido");
        }
    }

     public static void Modificarlibro(Scanner sc, String arrayLibros [][]){//esta clase es para modificar un libro que ya hayas metido en la base de datos
        int posicion;
        System.out.print("Dime el ISBN de el libro que quieres modificar ");
        String ISBN = sc.next();
        if (validarISBN(ISBN)){// aqui valido que lo que me esta poniendo sea un ISBN y no un numero cualquiera
        posicion = buscarPosicionISBN(ISBN, arrayLibros);
            if(!buscarDuplicado(ISBN, arrayLibros)) {//aqui me aseguro que el libro ya estuviese guardado en la base de datos
                 System.out.println("El ISBN de el libro que has ingresado no está registrado en la base de datos.");
            }
            else {
                 if(posicion<0) {//esto es para asegurarme de que haya espacio en la base de datos
                     System.out.println("No hay espacio");
                     }
                else {System.out.println("Que es lo que quieres modificar?");
                     System.out.println("1.- El nombre de el libro ("+arrayLibros[posicion][1]+")");
                     System.out.println("2.-  El autor de el libro ("+arrayLibros[posicion][2]+")");
                     System.out.println("3.- La fecha de salida de el libro ("+arrayLibros[posicion][3]+")");
                     System.out.println("4.- Salir");
                     int opcion = sc.nextInt();//aqui le dejo elegir que dato es el que quiere modificar
                     switch (opcion) {
                        case 1:
                            System.out.println("Que nombre le quieres poner? ");
                            arrayLibros[posicion][1] = sc.next();
                            System.out.println("Nombre cambiado correctamente ");
                            break;
                        case 2:
                            System.out.println("Cual es el nombre de el autor correcto? ");
                            arrayLibros[posicion][2] = sc.next();
                            System.out.println("Nombre cambiado correctamente ");
                            break;
                        case 3:
                            System.out.println("Cual es la fecha de salido correcta de el libro? ");
                            arrayLibros[posicion][3] = sc.next();
                            System.out.println("Fecha cambiada correctamente ");
                            break;
                        default:

                        }
                    }
                }
            }else{
                System.out.println("Este ISBN no es válido");
            }       
        }

        public static void eliminarLibro(Scanner sc, String arrayLibros [][]) {//esta clase es para eliminar un libro
            String afirmativo = "si";
            System.out.println("Dime el ISBN de el libro que quires eliminar");
            String ISBN = sc.next();
            if (validarISBN(ISBN)){// aqui valido que lo que me esta poniendo sea un ISBN y no un numero cualquiera
            if(!buscarDuplicado(ISBN, arrayLibros)){//aqui miro que el libro este puestto en la base de datos
                System.out.println("El libro que intenta eliminar no esta en nuestra base de datos");
            }else{
                for(int i=0;i<arrayLibros.length;i++) {
                    if (arrayLibros[i][0] != null ) {
                    if( arrayLibros[i][0].equals(ISBN)){//en el caso de que todo este bien le pido confirmacion al usuario
                        System.out.println("Seguro que quieres eliminar el libro con el ISBN que acabas de ingresar (si/no)");
                        String respuesta = sc.next();
                        if(respuesta.equals(afirmativo)){//si la respuesta es positiva procedo a eliminar el libro
                        arrayLibros[i][0] = null;
                        arrayLibros[i][1] = null;
                        arrayLibros[i][2] = null;
                        arrayLibros[i][3] = null;
                        arrayLibros[i][4] = null;
                    System.out.println("El libro ha sido eliminado con exito");
                        }else{
                            System.out.println("Has vuelto al menu de inicio");
                            }
                        }
                    }
                }
            }
            }else{
                System.out.println("Este ISBN no es válido");
            }               
        }

        public static void mostrarInformacionLibro(Scanner sc , String arrayLibros [][]) {//esta clase es para imprimir por pantalla todos los datos que tenemos de un libro en cuestion
            int posicion;
            System.out.println("Dime el ISBN de el libro");
            String ISBN = sc.next();
            if (validarISBN(ISBN)){// aqui valido que lo que me esta poniendo sea un ISBN y no un numero cualquiera
            posicion = buscarPosicionISBN(ISBN, arrayLibros);
            if(!buscarDuplicado(ISBN, arrayLibros)){//aqui miro que el libro este metido en la base de datos
                System.out.println("El libro que intenta acceder no esta en nuestra base de datos");}
            else{//si todo esta bien procedo a mostrar los datos que tengo de ese libro en concreto 
                System.out.println("Estos son los datos que tenemos sobre el libro que has puesto");
                     System.out.println("1.- El nombre de el libro ("+arrayLibros[posicion][1]+")");
                     System.out.println("2.- El autor de el libro ("+arrayLibros[posicion][2]+")");
                     System.out.println("3.- La fecha de salida de el libro ("+arrayLibros[posicion][3]+")");
                     System.out.println("4.- El estado de el libro es ("+arrayLibros[posicion][4]+")");
                }
            }else{
                System.out.println("Este ISBN no es válido");
            }  
        }   

        public static void prestarLibro(Scanner sc , String arrayLibros [][]) {//esta clase es para marcar un libro como prestado
            String afirmativo = "si";
            System.out.println("Escribe el ISBN de el libro que quieres prestar ");
            String ISBN = sc.next();
            if (validarISBN(ISBN)){// aqui valido que lo que me esta poniendo sea un ISBN y no un numero cualquiera
            if (!buscarDuplicado(ISBN, arrayLibros)){
                System.out.println("El ISBN que has puesto no está en la base de datos");
            }else{
                if(buscarPrestado(arrayLibros)){//aqui valido que el libro no estuvise prestado ya
                    System.out.println("El libro que has puesto ya esta prestado");
                }else{
                System.out.println("Estás seguro que quieres marcar este libro como prestado?(responder si/no)");
                String respuesta = sc.next();//aqui le pido confirmacion al usuario
                if(respuesta.equals(afirmativo)){//si la respuesta es positiva continuo
                    for(int i=0;i<arrayLibros.length;i++) {//aqui cambio la columna de no prestado con la de prestado
                        if (arrayLibros[i][0] != null ) {
                            if( arrayLibros[i][0].equals(ISBN)){
                                arrayLibros[i][4] = "prestado" ;
                                System.out.println("El libro ha sido marcado como prestado con exito");
                                i = arrayLibros.length;
                            }
                        }
                    }
                }else{
                    System.out.println("Volveras al menu de opciones");
                }
            }
            }
            }else{
                System.out.println("Este ISBN no es válido");
            }  
        }

        public static void devolverLibro(Scanner sc , String arrayLibros [][]) {
            String afirmativo = "si";
            System.out.println("Escribe el ISBN de el libro que quieres marcar como devuelto ");
            String ISBN = sc.next();
            if (validarISBN(ISBN)){//aqui valida si el ISBN es valido
            if (!buscarDuplicado(ISBN, arrayLibros)){//aqui valida si ya esta puesto el ISBN en la base de datos
                System.out.println("El ISBN que has puesto no está en la base de datos");
            }else{
                if(buscarSinPrestar(arrayLibros)){//aqui no dejo marcar que esta prestado si no esta marcado como prestado, ya que de normal está marcado como no prestado
                    System.out.println("El libro no esta marcado como prestado");
                }else{
                System.out.println("Estás seguro que quieres marcar este libro como devuelto?(responder si/no)");
                String respuesta = sc.next();
                if(respuesta.equals(afirmativo)){
                    for(int i=0;i<arrayLibros.length;i++) {//aqui marco como devuelto el libro
                        if (arrayLibros[i][0] != null ) {
                            if( arrayLibros[i][0].equals(ISBN)){
                                arrayLibros[i][4] = "sinprestar";
                                System.out.println("El libro ha sido marcado como devuelto con exito");
                                i = arrayLibros.length;
                            }
                        }
                    }
                }else{
                    System.out.println("Volveras al menu de opciones");
                    }
                }
            }
            }else{
            System.out.println("Este ISBN no es válido");
            }
        }    

        public static boolean buscarSinPrestar(String arrayA [][]){//esto sirve para buscar en el array si el libro esta prestado o no
            boolean encontrado = false;                            //en el caso de encontrar esta prestado devuelve false, mientras si no esta prestado devuelve true
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i][4] == "sinprestar"){
                    encontrado = true;
                    i = arrayA.length;
                }
            }

            return encontrado;
        }

        public static boolean buscarPrestado(String arrayA[][]){//esto sirve para buscar en el array si el libro esta prestado o no
            boolean encontrado = false;                         //en el caso de encontrar esta prestado devuelve true, mientras si no esta prestado devuelve false
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i][4] == "prestado"){
                    encontrado = true;
                    i = arrayA.length;
                }
            }

            return encontrado;
        }

        public static boolean buscarDuplicado(String busqueda, String arrayA [][]) {//esto sirve para buscar cualquier cosa que este duplicada en la clave permanente de un array
            boolean encontrado = false;                                             //en el caso de no encontrar nada duplicado en el array devuelve false, mientras si la encuentra devuelve true
             for(int i=0;i<arrayA.length;i++) {
                if(arrayA[i][0]!=null) {
                    if(arrayA[i][0].equals(busqueda)) {
                    encontrado = true;
                    i=arrayA.length;
                 }
                 }
            }
            return encontrado;
        }
    
        public static int buscarEspacioLibreUsuario(String arrayUsuarios [][], String usuario, String contraseña) {//Esto es para buscar y guardar si hay un espacio libre en la base de datos
            int encontrado = -1;                                                                                    // busco la posicion, y si la encuentra guarda el usuario y la contraseña.
             for(int i=0;i<arrayUsuarios.length;i++) {                                                              // si no la encuentra devuelve un numero negativo
                if(arrayUsuarios[i][0]==null) {
                    arrayUsuarios[i][0] = usuario;
                    arrayUsuarios[i][1] = contraseña;
                    encontrado = 2;
                    i=arrayUsuarios.length;
                 }
                 }
            return encontrado;
        }


    public static int buscarEspacioLibreLibro(String arrayLibros [][]) {// Esto es para buscar si hay un espacio libre en la base de datos, y si lo hay en que posicion esta
        int posicion = -1;                                              //si es un numero negativo significa que no hay espacio en el array y si es positivo es la posicion en la que se encuentra el hueco
         for(int i=0;i<arrayLibros.length;i++) {
             if(arrayLibros[i][0]==null) {
                 posicion = i;
                 i=arrayLibros.length;
                }
            }
        return posicion;
    }

    public static int buscarPosicionISBN(String ISBN, String arrayLibros [][]) {//esto es para buscar la posicion en el array de libros de un libro en cconcreto
        int posicion = -1;                                                      //busco en todo el array para encontrar el isbn correcto y en que posiccion está
         for(int i=0;i<arrayLibros.length;i++) {                                //si es un numero negativo significa que no esta en el array y si es positivo es la posicion en la que se encuentra en el array
            if(arrayLibros[i][0]!=null) {
                if(arrayLibros[i][0].equals(ISBN)) {
                posicion = i;
                i=arrayLibros.length;
             }
             }
        }
        return posicion;
    }

    // Método para validar el formato del ISBN (en este caso, un ISBN-13)
    public static boolean validarISBN(String isbn) {
        // Definimos un patrón para validar el ISBN-13 (13 dígitos numéricos)
        String regex = "^(978|979)\\d{10}$";//esto es para definir el formato isbn y guardarlo en regex
        Pattern pattern = Pattern.compile(regex);//esto es para declarar un patron y asignarselo a 
        Matcher matcher = pattern.matcher(isbn);//aqui compara el patron con el ISBN y define si esta bien (true) o no (false)
        return matcher.matches();//aqui devuelvo el valor
    }

}