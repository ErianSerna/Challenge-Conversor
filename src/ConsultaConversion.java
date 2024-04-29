import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaConversion {



    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public void CreateLink(String currency, String currency2,double amount) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/your-api-key-here/pair/"+currency+"/"+currency2+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json + "\n");

            //El json funciona, la api funciona pero no me devuelve el conversion_result, ni el conversion_rate

            Conversion conv = gson.fromJson(json, Conversion.class);


            System.out.println("La cantidad de " + amount + " [" + currency + "]" + " equivale a:  " + conv.conversion_result() + " [" + currency2 + "]");

//            System.out.println("La tasa de conversión utilizada fue: " + objM.getConversionRate() );

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

    public double DineroAconvertir(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nIngrese cuanto dinero desea convertir\n");

        return scan.nextDouble();
    }

}
