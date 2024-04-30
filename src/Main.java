import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsultaConversion objCC = new ConsultaConversion();
        Moneda objM = new Moneda();
        int opc;


        do {
            System.out.println(objCC.menuConversion());
            opc = scan.nextInt();
            double amount;
            Object info;

            if(opc == 8){
                break;
            }

            switch (opc) {

                case 1:

                    amount = objCC.DineroAconvertir();

                    objCC.CreateLink("USD", "ARS", amount);
                    info = objCC.CreateLink("USD", "ARS", amount);

                    //Muestra lo de la API pero necesita solo mosotrar el conversion rate y el result por separado
//                    System.out.println("La cantidad de " + amount + " [USD]" + " equivale a:  " + objM.getConversionResult() + " [ARS]");
                    System.out.println("La cantidad de " + amount + " [USD]" + " equivale a:  " + info + " [ARS]");
                    System.out.println("La tasa de conversión utilizada fue: " + objM.getConversionRate() );

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }


        } while (opc != 9);


    }
}

