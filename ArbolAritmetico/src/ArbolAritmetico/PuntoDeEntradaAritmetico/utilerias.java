package ArbolAritmetico.PuntoDeEntradaAritmetico;
import java.util.Scanner;
public class utilerias {
    public static String ingresoDeExpresion(Scanner scanner){
        System.out.println("Ingrese la expresión que requiere:");
        String Expresion=scanner.nextLine();
        scanner.nextLine();
        return Expresion;
    }
}
