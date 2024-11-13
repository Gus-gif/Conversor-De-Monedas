import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Convertidor convertidor = new Convertidor();
        boolean salir = false;

        while (!salir) {
            System.out.println("\nBIENVENIDOS AL CONVERSOR DE MONEDAS");
            System.out.println("-----------------------------------");
            System.out.println("por favor elija la opcion de su interes:");
            System.out.println("\n1. Dólar a Peso Colombiano");
            System.out.println("2. Dólar a Peso Argentino");
            System.out.println("3. Dólar a Peso Mexicano");
            System.out.println("4. Dólar a Euro");
            System.out.println("5. Dólar a Dirham");
            System.out.println("0. Salir");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertidor.convertir("USD", "COP", scanner);
                    break;
                case 2:
                    convertidor.convertir("USD", "ARS", scanner);
                    break;
                case 3:
                    convertidor.convertir("USD", "MXN", scanner);
                    break;
                case 4:
                    convertidor.convertir("USD", "EUR", scanner);
                    break;
                case 5:
                    convertidor.convertir("USD", "AED", scanner);
                    break;
                case 0:
                    salir = true;
                    System.out.println("Gracias por usar el conversor de moneda...");
                    break;
                default:
                    System.out.println("Opción no válida... Intente de nuevo...");
            }
        }

        scanner.close();
    }
}

