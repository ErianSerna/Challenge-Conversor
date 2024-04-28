import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsultaConversion c = new ConsultaConversion();
        int opc;

        do{
             System.out.println(c.menuConversion());
             opc = scan.nextInt();

        switch (opc){
// Me falta pedir el valor que desean cambiar, cambiar la forma en que se muestra el valor de la conversión
            case 1:
                System.out.println("La conversión de USD a ARS es: \n"+ c.CreateLink("USD", "ARS"));
                break;
            case 2:
                System.out.println("2");
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
            case 8:
                break;
            default:
                System.out.println("Opción invalida");
                break; // No se sale
        }


        }while(opc != 8);








//
//        for (int i = 0; i < 1; i++) {
//            System.out.println("Ingrese que monedas desea hacer la conversión");
//            int currency =


        //}
    }


}