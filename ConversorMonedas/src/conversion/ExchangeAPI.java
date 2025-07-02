package conversion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ExchangeAPI {
    String apikey = "a4a265f2aad00da9a53d0ab2";
    String direccion = "https://v6.exchangerate-api.com/v6/";


    public double obtenerTasa(String base, String destino){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create( direccion + apikey + "/pair/"+base+"/"+destino))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

           JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
           return json.get("conversion_rate").getAsDouble();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Double> obtenerTasaMultiple(String base, String[] destinos){
        Map<String, Double> tasasFiltro = new HashMap<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion + apikey + "/latest/"+base))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject tasasObtenidas = json.getAsJsonObject("conversion_rates");

            for (String moneda : destinos) {
                if (tasasObtenidas.has(moneda)) {
                    tasasFiltro.put(moneda, tasasObtenidas.get(moneda).getAsDouble());
                } else {
                    System.out.println("La moneda " + moneda + " no está disponible en la API.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return tasasFiltro;
    }
}
