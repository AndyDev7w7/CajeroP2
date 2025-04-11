package nucleo;

import controllers.CajeroController;
import java.util.Scanner;
import models.Cuenta;
import models.Usuario;
import services.BolsilloService;
import services.ConsultaService;
import services.HistorialService;
import services.HistorialViewerService;
import services.PinService;
import services.TransaccionesService;
import views.MenuView;

public class CajeroApp {

    private Scanner scanner = new Scanner(System.in);
    private Cuenta cuenta;
    private Usuario usuario;
    private CajeroController cajero;
    private HistorialService historial;

    public void iniciar() {
        cuenta = new Cuenta("123456", 50000.0, "1234", 0);
        usuario = new Usuario("Rubencito", cuenta);
        cajero = new CajeroController(cuenta);
        historial = new HistorialService();

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║  Bienvenido al CAJERO LEGENDARIO de YO™      ║");
        System.out.println("║      Aquí manejas dinero... con estilo 😎     ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        if (!autenticar()) return;

        int opcion;
        do {
            MenuView.mostrarMenu(usuario.getNombre());
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpieza de buffer
            manejarOpcion(opcion);
        } while (opcion != 6);

        scanner.close();
    }

    private boolean autenticar() {
        while (!cajero.cuentaBloqueada()) {
            System.out.print("Introduce tu PIN, máquina: ");
            String pin = scanner.nextLine();

            if (cajero.validarPIN(pin)) {
                System.out.println("¡Bienvenido, " + usuario.getNombre() + "!");
                return true;
            } else {
                System.out.println("PIN incorrecto, crack.");
            }

            if (cajero.cuentaBloqueada()) {
                System.out.println("Demasiados intentos. Cuenta bloqueada, genio.");
                return false;
            }
        }
        return false;
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> ConsultaService.mostrarSaldo(cajero);
            case 2 -> TransaccionesService.retirarDinero(scanner, cajero, historial);
            case 3 -> TransaccionesService.depositarDinero(scanner, cajero, historial);
            case 4 -> HistorialViewerService.mostrarHistorial(historial);
            case 5 -> BolsilloService.gestionarBolsillo(scanner, cuenta, cajero, historial);
            case 6 -> System.out.println("Te vas como todo un ninja. ¡Hasta la próxima!");
            case 7 -> PinService.cambiarPIN(cuenta, scanner, historial);
            default -> System.out.println("¿Qué te crees, un mago? Esa opción no existe, bro.");
        }
    }
}
