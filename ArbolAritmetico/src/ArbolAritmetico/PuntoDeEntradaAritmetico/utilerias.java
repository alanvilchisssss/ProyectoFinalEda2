package ArbolAritmetico.PuntoDeEntradaAritmetico;
import java.util.LinkedList;
import java.util.Scanner;
public class utilerias {
    public static Boolean banderita=false;
    public static void ingresoDeExpresion(Scanner scanner,LinkedList<String> expresion){
        System.out.println("Ingrese la expresión que requiere:");
        String Operacion=new String();
        do{
            String[] valores=new String[2];

            System.out.println("Ingrese que operación va a realizar:(suma, resta, multiplicacion, division, o salir)");
            Operacion=scanner.nextLine().toLowerCase();
            scanner.nextLine();
            if(expresion.isEmpty()){
                Switch(scanner, expresion, Operacion, valores);
            }else{
                System.out.println("operación actual: "+menu.RegresoDeLaExpresion(expresion));
                Switch(scanner, expresion, Operacion, valores);
                if(banderita==false){
                String operacionSiguiente=PreguntarLaSiguienteOperación(scanner);
                expresion.add(operacionSiguiente);
                }
            }
        }while(!Operacion.equals("salir"));
    }
    public static void PreguntaPorLosValores(Scanner scanner, String[] valor){
        System.out.println("Ingrese el primer número:");
        String Valor1_Agregado_Al_arbol=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingrese el segundo valor:");
        String Valor2_Agregado_Al_arbol=scanner.nextLine();
        scanner.nextLine();
        valor[0]=Valor1_Agregado_Al_arbol;
        valor[1]=Valor2_Agregado_Al_arbol;
    }
    public static void Switch(Scanner scanner,LinkedList<String> expresion, String Operacion, String[] valores){
        switch(Operacion){
            case "suma"->{
                PreguntaPorLosValores(scanner, valores);
                expresion.add(valores[0]);
                expresion.add(valores[1]);
                expresion.add("+");

            }
            case "resta"->{
                PreguntaPorLosValores(scanner, valores);
                expresion.add(valores[0]);
                expresion.add(valores[1]);
                expresion.add("-");

            }
            case "multiplicacion"->{
                PreguntaPorLosValores(scanner, valores);
                expresion.add(valores[0]);
                expresion.add(valores[1]);
                expresion.add("*");
            }
            case "division"->{
                PreguntaPorLosValores(scanner, valores);
                expresion.add(valores[0]);
                expresion.add(valores[1]);
                expresion.add("/");

            }
            case "salir"->{
                banderita=true;
                System.out.println("...saliendo.");
            }
            default->System.out.println("Error");
        }
    }
    public static String PreguntarLaSiguienteOperación(Scanner scanner){
        System.out.println("Dado que ya ingresó una operación, ingrese que operación va a efectuar con la que acaba de ingresar:(suma, resta, multiplicacion, division, o salir)");
        String Operacion=scanner.nextLine();
        scanner.nextLine();
        String signo=new String();
        switch(Operacion){
            case "suma"->{
                signo="+";
            }
            case "resta"->{
                signo="-";
            }
            case "multiplicacion"->{
                signo="*";
            }
            case "division"->{
                signo="/";
            }
            case "salir"->{
                banderita=true;
                System.out.println("...saliendo.");
            } 
            default->{
                System.out.println("Error");
                return PreguntarLaSiguienteOperación(scanner);
            }
        }
        return signo;
    }
}
