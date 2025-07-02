package principal;

import conversion.Conversor;
import extras.FuncionesAdicionales;
import modelos.RegistroHistorial;
import registro.HistorialConversiones;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Conversor conversor = new Conversor(lectura);
        FuncionesAdicionales funciones = new FuncionesAdicionales(lectura, conversor);
        HistorialConversiones historial = new HistorialConversiones();

        int opcion=0;
        double resultado;

        System.out.println("**********************************");
        System.out.println("Bienvenido/a a nuestro conversor de monedas\n");
        String menu = """
                -- Elija el par de divisas a convertir --\n
                1 - Dólar (USD) --->> Peso Mexicano (MXN)
                2 - Peso Mexicano (MXN) --->> Dólar (USD)
                3 - Dólar (USD) --->> Peso Colombiano (COP)
                4 - Peso Colombiano (COP) --->> Dólar (USD)
                5 - Dólar (USD) --->> Real Brasileño (BRL)
                6 - Real Brasileño (BRL) --->> Dólar (USD)
                7 - Extras
                8 - Salir
                """;



        while (opcion!=8){
            System.out.println(menu);
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(lectura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Ingresa un número del menú. ⚠ \n");
                continue;
            }
            switch (opcion){

                case 1 :
                    resultado = conversor.convertirMoneda("USD", "MXN");
                    if (resultado != -1)
                        historial.guardarConversion(new RegistroHistorial("Conversión Básica", "USD → MXN", conversor.getUltimoMonto(), resultado));
                    break;
                case 2:
                    resultado = conversor.convertirMoneda("MXN", "USD");
                    if (resultado != -1)
                        historial.guardarConversion(new RegistroHistorial("Conversión Básica", "MXN → USD", conversor.getUltimoMonto(), resultado));
                    break;
                case 3:
                    resultado = conversor.convertirMoneda("USD", "COP");
                    if (resultado != -1)
                        historial.guardarConversion(new RegistroHistorial("Conversión Básica", "USD → COP", conversor.getUltimoMonto(), resultado));
                    break;
                case 4:
                    resultado = conversor.convertirMoneda("COP", "USD");
                    if (resultado != -1)
                        historial.guardarConversion(new RegistroHistorial("Conversión Básica", "COP → USD", conversor.getUltimoMonto(), resultado));
                    break;
                case 5:
                    resultado = conversor.convertirMoneda("USD", "BRL");
                    if (resultado != -1)
                        historial.guardarConversion(new RegistroHistorial("Conversión Básica", "USD → BRL", conversor.getUltimoMonto(), resultado));
                    break;
                case 6:
                    resultado = conversor.convertirMoneda("BRL", "USD");
                    if (resultado != -1)
                        historial.guardarConversion(new RegistroHistorial("Conversión Básica", "BRL → USD", conversor.getUltimoMonto(), resultado));
                    break;
                case 7:
                    funciones.mostrarMenuExtras();
                    break;
                case 8:  System.out.println("Gracias por utilizar mi conversor! \uD83D\uDC4B");
                    break;
                default: System.out.println("⚠ Ingresa un número del menú. ⚠ \n");
            }
        }
    }
}
