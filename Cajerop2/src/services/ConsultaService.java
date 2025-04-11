package services;

import controllers.CajeroController;

public class ConsultaService {
    public static void mostrarSaldo(CajeroController cajero) {
        System.out.println("Tienes: $" + cajero.consultarSaldo());
    }
}
