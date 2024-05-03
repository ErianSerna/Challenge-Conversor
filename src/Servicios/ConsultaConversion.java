package Servicios;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaConversion {

    public ConsultaConversion() {
    }

    public void CreateLink(Object currency, Object currency2, Object amount) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e33f400523bede3de736ecc2/pair/" + currency + "/" + currency2 + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();
            JsonParser jsonParser = new JsonParser();

            JsonObject jsonObject = jsonParser.parse(body).getAsJsonObject();

            double conversion_rate = jsonObject.get("conversion_rate").getAsDouble();
            double conversion_result = jsonObject.get("conversion_result").getAsDouble();

            System.out.println("La cantidad de " + amount + " [" + currency +  "]" + " equivale a: " + String.format("%.2f", conversion_result) + " [" + currency2 +  "]");

            if (conversion_rate < 1 ){
                System.out.println("La tasa de conversión utilizada para esta conversión fue: " + String.format("%.5f", conversion_rate) + "["+currency2+"]");
            } else{
                System.out.println("La tasa de conversión utilizada para esta conversión fue: " + conversion_rate + "["+currency2+"]");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }

    public String menuConversion() {
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

    public double DineroAconvertir() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nIngrese cuanto dinero desea convertir\n");

        return scan.nextDouble();
    }

}