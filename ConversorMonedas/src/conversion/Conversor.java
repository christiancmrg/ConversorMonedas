package conversion;

import java.util.Map;
import java.util.Scanner;

public class Conversor {
    private Scanner eleccionUsuario;
    private ExchangeAPI conexionApi;
    private double ultimoMonto;

    public Conversor(Scanner eleccionUsuario) {
        this.eleccionUsuario = eleccionUsuario;
        this.conexionApi = new ExchangeAPI();
    }

    public double convertirMoneda(String monedabase, String monedafinal){
        System.out.println("\nElige el monto a convertir de "+monedabase+ " a " +monedafinal+ ":");
        double monto;

        try {
            monto = Double.parseDouble(eleccionUsuario.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Monto invalido. Intentalo de nuevo \n");
            return -1;
        }

        double tasa = conexionApi.obtenerTasa(monedabase, monedafinal);
        double resultado = monto * tasa;
        this.ultimoMonto = monto;

        System.out.println("✅ Resultado: ");
        System.out.printf("%.2f %s = %.2f %s (Tasa de Cambio: %.4f)%n \n", monto, monedabase, resultado, monedafinal, tasa);

        return resultado;
    }

    public Map<String, Double> obtenerTasaMultiple(String base, String[] destinos){
        return conexionApi.obtenerTasaMultiple(base, destinos);
    }

    public double getUltimoMonto() {
        return ultimoMonto;
    }
}
