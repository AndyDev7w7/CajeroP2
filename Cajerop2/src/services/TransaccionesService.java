package services;

import controllers.CajeroController;
import java.util.Scanner;

public class TransaccionesService {

    public static void retirarDinero(Scanner scanner, CajeroController cajero, HistorialService historial) {
        System.out.print("¿Cuánto quieres sacar?: ");
        double retiro = scanner.nextDouble();

        if (cajero.retirar(retiro)) {
            historial.registrar("Retiro de $" + retiro);
            System.out.println("Retiro exitoso. Saldo: $" + cajero.consultarSaldo());
        } else {
            System.out.println("No se pudo retirar. ¿Intentas sacar humo o qué?");
        }
    }

    public static void depositarDinero(Scanner scanner, CajeroController cajero, HistorialService historial) {
        System.out.print("¿Cuánto vas a meter?: ");
        double deposito = scanner.nextDouble();

        if (cajero.depositar(deposito)) {
            historial.registrar("Depósito de $" + deposito);
            System.out.println("Depósito exitoso. Saldo: $" + cajero.consultarSaldo());
        } else {
            System.out.println("Eso no tiene sentido, máquina.");
        }
    }
}
