import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {

    public Conversion CreateLink(String currency, String curreny2) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e33f400523bede3de736ecc2/pair/"+currency+"/"+curreny2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa divisa.");
        }
    }

    public String menuConversion(){
        return """
               ***********************************************************
               
               Bienvenido/a al conversor de moneda =]
               
               1) Dólar =>> Peso Argentino
               2) Peso Argentino =>> Dólar
               3) Dólar =>> Real brasileño
               4) Real brasileño =>> Dólar
               5) Dólar =>> Peso Colombiano
               6) Peso Colombiano =>> Dólar
               7) Otras conversiones
               8) Salir
               
               Elija una opción válida:
               ***********************************************************
               """;
    }

}
