import java.util.Scanner;

public class Convertidor {
    private SolicitaCambio cambio = new SolicitaCambio();

    public void convertir(String monedaOrigen, String monedaDestino, Scanner scanner) {
        System.out.println("Ingrese la cantidad en " + monedaOrigen + " que desea convertir a " + monedaDestino + ": ");
        double cantidad = scanner.nextDouble();

        double tasa = cambio.getConvertidor(monedaOrigen, monedaDestino);

        if (tasa > 0) {
            double cantidadConvertida = cantidad * tasa;
            System.out.printf(cantidad + " USD equivalen a: %.2f %s\n", cantidadConvertida, monedaDestino);
        } else {
            System.out.println("No se pudo obtener la tasa de cambio. Inténtelo de nuevo más tarde.");
        }
    }
}

