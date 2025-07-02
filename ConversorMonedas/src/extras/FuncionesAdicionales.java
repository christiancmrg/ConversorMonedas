package extras;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversion.Conversor;
import modelos.RegistroHistorial;
import registro.HistorialConversiones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FuncionesAdicionales {
    private Scanner eleccionUsuario;
    private Conversor conversor;
    private HistorialConversiones historialConversiones;

    private List<RegistroHistorial> historial = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public FuncionesAdicionales(Scanner eleccionUsuario, Conversor conversor) {
        this.eleccionUsuario = eleccionUsuario;
        this.conversor = conversor;
        this.historialConversiones = new HistorialConversiones();
    }

    public void mostrarHistorial() {
        List<RegistroHistorial> historial = historialConversiones.leerHistorial();

        if (historial.isEmpty()) {
            System.out.println("No hay registros en el historial.\n");
            return;
        }

        System.out.println("\n📜 Historial de conversiones:");

        for (RegistroHistorial registro : historial) {
            System.out.printf("- [%s] %s: %.2f → %.2f%n",
                    registro.tipo(),
                    registro.mensaje(),
                    registro.monto(),
                    registro.resultado()
            );
        }
    }

    public void mostrarMenuExtras(){
        int opcion=0;

        String menuExtras = """
        -- Menú de funciones extra --
        1 - Ver historial de conversiones
        2 - Conversión personalizada
        3 - Conversion Multiple
        4 - Volver al menú principal
        5 - Finalizar conversor
        """;

        while (opcion != 5){
            System.out.println("\n" + menuExtras);
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(eleccionUsuario.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Ingresa un número del menú. ⚠");
                continue;
            }

            switch (opcion){

                case 1 :
                    mostrarHistorial();
                    break;
                case 2:
                    conversionPersonalizada();
                    break;
                case 3:
                    conversionMultiple();
                    break;
                case 4 : System.out.println("Regresando al menú principal \n");
                return;
                case 5:  System.out.println("Gracias por utilizar mi conversor! \uD83D\uDC4B");
                    System.exit(0);
                default:
                    System.out.println("⚠ Ingresa un número del menú. ⚠");
            }
        }
    }

    public void conversionPersonalizada(){
        System.out.println("Ingresa la moneda base: ");
        String base = eleccionUsuario.nextLine().toUpperCase();

        System.out.println("Ingresa la moneda destino: ");
        String destino = eleccionUsuario.nextLine().toUpperCase();

        double resultado= conversor.convertirMoneda(base, destino);

        if(resultado != -1){
            RegistroHistorial registro = new RegistroHistorial(
                    "Conversión Personalizada",
                    base + " → " + destino,
                    conversor.getUltimoMonto(),
                    resultado
            );
            historialConversiones.guardarConversion(registro);
        }
    }

    public void conversionMultiple() {
        double monto = 0;

        System.out.println("Ingresa la moneda base [MXN, USD, BRL, COP]: ");
        String base = eleccionUsuario.nextLine().toUpperCase();

        System.out.println("Ingresa el monto a convertir de " + base + ":");
        try {
            monto = Double.parseDouble(eleccionUsuario.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Monto inválido. Intenta de nuevo.");
            return;
        }

        System.out.println("Ingrese las monedas destino separadas por coma [MXN, USD, BRL, COP]: ");
        String[] destinos = eleccionUsuario.nextLine().toUpperCase().replace(" ", "").split(",");

        Map<String, Double> tasas = conversor.obtenerTasaMultiple(base, destinos);
        if (tasas.isEmpty()) {
            System.out.println("❌ No se encontraron tasas para las monedas indicadas.");
            return;
        }

        System.out.println("\n✅ Conversión Múltiple:");
        for (Map.Entry<String, Double> entrada : tasas.entrySet()) {
            String moneda = entrada.getKey();
            double tasa = entrada.getValue();
            double resultado = monto * tasa;

            System.out.printf("%.2f %s = %.2f %s (Tasa de conversión: %.4f)%n", monto, base, resultado, moneda, tasa);

            RegistroHistorial registro = new RegistroHistorial(
                    "Conversión Múltiple",
                    base + " → " + moneda,
                    monto,
                    resultado
            );
            historialConversiones.guardarConversion(registro);
        }
    }
}
