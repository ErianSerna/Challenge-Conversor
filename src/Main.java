import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsultaConversion objCC = new ConsultaConversion();

        int opc;

        do {
            System.out.println(objCC.menuConversion());
            opc = scan.nextInt();

            if(opc == 8){
                break;
            }

            switch (opc) {

                case 1:

                    objCC.CreateLink("USD", "ARS", objCC.DineroAconvertir());
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

