package PruebaPuntuable;

public class ValidadorDNI {

    public static boolean esDNIValido(String dni) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
                'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        final int RESTO = 23;

        if (dni.length() != 9) return false;

        String numeroStr = dni.substring(0, 8);
        char letra = Character.toUpperCase(dni.charAt(8));

        try {
            int numero = Integer.parseInt(numeroStr);
            return letras[numero % RESTO] == letra;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}