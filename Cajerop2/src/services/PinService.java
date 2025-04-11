package services;

import java.util.Scanner;
import models.Cuenta;

public class PinService {
    public static void cambiarPIN(Cuenta cuenta, Scanner scanner, HistorialService historial) {
        System.out.print("Introduce tu PIN actual, hacker de pacotilla: ");
        String actual = scanner.nextLine();

        if (!cuenta.getPin().equals(actual)) {
            System.out.println("Ese no es tu PIN, infiltrado. Casi te pillamos.");
            return;
        }

        System.out.print("Nuevo PIN: ");
        String nuevo = scanner.nextLine();

        System.out.print("Confirma el nuevo PIN: ");
        String confirmar = scanner.nextLine();

        if (!nuevo.equals(confirmar)) {
            System.out.println("Las claves no coinciden, mi estimado cerebrito.");
            return;
        }

        if (nuevo.length() < 3 || nuevo.length() > 8) {
            System.out.println("Ese PIN está medio raro. Usa entre 3 y 8 caracteres.");
            return;
        }

        cuenta.setPin(nuevo);
        historial.registrar("PIN cambiado exitosamente.");
        System.out.println("PIN actualizado con éxito. ¡Ahora estás más protegido que la NASA!");
    }
}
