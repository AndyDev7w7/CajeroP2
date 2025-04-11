package services;

public class HistorialViewerService {
    public static void mostrarHistorial(HistorialService historial) {
        System.out.println("Historial de transacciones:");
        for (String transaccion : historial.obtenerHistorial()) {
            System.out.println("- " + transaccion);
        }
    }
}
