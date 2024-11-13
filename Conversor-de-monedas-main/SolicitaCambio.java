import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SolicitaCambio {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/6a9033046ec447239cf7cbda/pair/";

    public double getConvertidor(String monedaOrigen, String monedaDestino) {
        try {
            URL url = new URL(API_URL + monedaOrigen + "/" + monedaDestino);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int respuesta = conn.getResponseCode();
            if (respuesta == 200) {
                BufferedReader instancia = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder contentedor = new StringBuilder();
                String entrada;

                while ((entrada = instancia.readLine()) != null) {
                    contentedor.append(entrada);
                }

                instancia.close();

                JsonObject json = JsonParser.parseString(contentedor.toString()).getAsJsonObject();
                return json.get("conversion_rate").getAsDouble();
            } else {
                System.out.println("Error de conexión: " + respuesta);
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return -1;
        }
    }
}

