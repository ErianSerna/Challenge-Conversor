package Servicios;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;
import Record.Conversion;

public class ConsultaConversion {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    private String currency;
    private String currency2;
    private double amount;


    public ConsultaConversion() {
    }

    public void CreateLink(Object currency, Object currency2, Object amount) {
        Gson gson = new Gson();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e33f400523bede3de736ecc2/pair/" + currency + "/" + currency2 + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = new JsonObject();

            jsonParser.parse(body).getAsDouble();
            jsonObject.get(body);
            gson.fromJson(response.body(), JsonObject.class);

            double conversion_rate = jsonObject.get("conversion_rate").getAsJsonObject().get((String) currency).getAsDouble();

            System.out.println(body);
            System.out.println("Radio de conversión" + conversion_rate );

//                    gson.fromJson(response.body(), JsonObject.class);
//            double conversion_rate = jsonObject.get("conversion_rate").getAsJsonObject().get((String) currency).getAsDouble();
//            double conversion_result = jsonObject.get("conversion_result").getAsJsonObject().get((String) currency2).getAsDouble();
//            System.out.println(conversion_rate);
//            System.out.println(conversion_result);

//         return new Gson().fromJson(response.body(), Conversion.class);

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
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

    public double DineroAconvertir(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nIngrese cuanto dinero desea convertir\n");

        return scan.nextDouble();
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrency2() {
        return currency2;
    }

    public double getAmount() {
        return amount;
    }

}
