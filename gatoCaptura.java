import java.util.Scanner;

public class gatoCaptura {

    public static void main(String[] args) {
        
        //STRING Y TODO ESO 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la cadena de nueve caracteres: ");
        String cadena = scanner.nextLine();
        String linea = "|";
        String lh = "-----";


        //IF PARA LIMITAR LA CANTIDAD DE CARACTERES
        if (cadena.length() != 9) {
            System.out.println("La cadena debe tener exactamente nueve caracteres.");
        } else {
            System.out.println("La cadena ingresada es: " + cadena);
        }

        System.out.println("\n"+cadena);


        // CAPTURA DE LOS DATOS
        char[][] tablero = {
            {cadena.charAt(0), cadena.charAt(1), cadena.charAt(2)},
            {cadena.charAt(3), cadena.charAt(4), cadena.charAt(5)},
            {cadena.charAt(6), cadena.charAt(7), cadena.charAt(8)}
        };

        //IMPRESO
        System.out.println("\n"+lh);
        System.out.println(linea + tablero[0][0] + tablero[0][1] + tablero[0][2] + linea);
        System.out.println(linea + tablero[1][0] + tablero[1][1] + tablero[1][2] + linea);
        System.out.println(linea + tablero[2][0] + tablero[2][1] + tablero[2][2] + linea);
        System.out.println(lh);
    }
}