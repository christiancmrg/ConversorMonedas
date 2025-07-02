package registro;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelos.RegistroHistorial;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public void guardarConversion(RegistroHistorial registro) {
        List<RegistroHistorial> historial = leerHistorial();
        historial.add(registro);

        try {
            FileWriter escritura = new FileWriter("HistorialConversiones.json");
            escritura.write(gson.toJson(historial));
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<RegistroHistorial> leerHistorial() {
        try (FileReader reader = new FileReader("HistorialConversiones.json")) {
            Type tipoLista = new TypeToken<List<RegistroHistorial>>() {
            }.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return new ArrayList<>();
        }

    }
}
