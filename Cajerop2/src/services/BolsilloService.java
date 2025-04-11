package services;

import controllers.CajeroController;
import java.util.Scanner;
import models.Cuenta;

public class BolsilloService {
    public static void gestionarBolsillo(Scanner scanner, Cuenta cuenta, CajeroController cajero, HistorialService historial) {
        int opcionBolsillo;
        do {
            System.out.println("\n👛 GESTIÓN DE BOLSILLO 👛");
            System.out.println("1. Consultar bolsillo");
            System.out.println("2. Guardar dinero en bolsillo");
            System.out.println("3. Sacar dinero del bolsillo");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción, sabio financiero: ");
            opcionBolsillo = scanner.nextInt();

            switch (opcionBolsillo) {
                case 1:
                    System.out.println("Tienes $" + cuenta.getBolsillo() + " guardados como un verdadero estratega.");
                    break;

                case 2:
                    System.out.print("¿Cuánto vas a esconder del mundo en tu bolsillo?: ");
                    double montoGuardar = scanner.nextDouble();

                    if (montoGuardar <= 0) {
                        System.out.println("¿Guardar aire? No seas creativo, bro.");
                    } else if (montoGuardar > cajero.consultarSaldo()) {
                        System.out.println("¿Pero tú viste tu saldo? No tienes esa cantidad. No flipes.");
                    } else {
                        cuenta.guardarEnBolsillo(montoGuardar);
                        historial.registrar("Guardó $" + montoGuardar + " en el bolsillo secreto.");
                        System.out.println("Dinero guardado con éxito. 🧠 Tu saldo ahora es: $" + cajero.consultarSaldo());
                    }
                    break;

                case 3:
                    System.out.print("¿Cuánto vas a sacar de tu tesoro escondido?: ");
                    double montoSacar = scanner.nextDouble();

                    if (montoSacar <= 0) {
                        System.out.println("¿Sacar aire del bolsillo? Mira que el oxígeno no vale tanto todavía.");
                    } else if (montoSacar > cuenta.getBolsillo()) {
                        System.out.println("No tienes tanta magia en ese bolsillo, mi rey.");
                    } else {
                        cuenta.sacarDelBolsillo(montoSacar);
                        historial.registrar("Sacó $" + montoSacar + " del bolsillo legendario.");
                        System.out.println("Dinero liberado. Ahora tienes $" + cajero.consultarSaldo() + " para gastarlo como un crack.");
                    }
                    break;

                case 4:
                    System.out.println("Volviendo al menú principal... guarda bien ese bolsillo, que brilla.");
                    break;

                default:
                    System.out.println("Esa opción no existe, cerebro con Wi-Fi limitado.");
                    break;
            }
        } while (opcionBolsillo != 4);
    }
}
