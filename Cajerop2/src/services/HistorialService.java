package services;
import java.util.ArrayList;
import java.util.List;

public class HistorialService {
    private List<String> historial;

    public HistorialService() {
        historial = new ArrayList<>();
    }

    public void registrar(String mensaje) {
        historial.add(mensaje);
    }

    public List<String> obtenerHistorial() {
        return historial;
    }
}