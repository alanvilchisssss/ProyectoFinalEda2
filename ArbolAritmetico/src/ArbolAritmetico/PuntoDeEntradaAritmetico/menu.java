package ArbolAritmetico.PuntoDeEntradaAritmetico;
import java.util.LinkedList;
import java.util.Scanner;
import ArbolAritmetico.arbol.arbolAritmetico;

public class menu {
    public static void MenuDeAccionesAritmetico(Scanner scanner){
        int opcion=0;
        LinkedList<String> expresion=new LinkedList<>();
        arbolAritmetico arbol=new arbolAritmetico();
        do{
            System.out.println("¿Qué desea hacer?");
            System.out.println("1.- Ingresar expresión");
            System.out.println("2.- Mostrar el árbol con la expresión actual.");
            System.out.println("3.- Resolver");
            System.out.println("4.- Salir");
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1->{
                    caso1(scanner, expresion);
                }
                case 2->{
                    if(!expresion.isEmpty()){
                        arbolAritmetico.OrdenarArbol(expresion,arbol);
                        //arbol.breadthFrist();
                    }else{
                        System.out.println("Ingresa primero la expresión");
                    }
                }
                case 3->{
                    if(!expresion.isEmpty()){

                    }else{
                        System.out.println("Ingresa primero la expresión.");
                    }
                }
                case 4->{
                    System.out.println("Saliendo al menú principal.");
                }
                default->System.out.println("Error");
            }
        }while(opcion!=4);
    }
    public static void caso1(Scanner scanner,LinkedList<String> expresion){
        if(expresion.isEmpty()){
            utilerias.ingresoDeExpresion(scanner, expresion);
            }else  if(!expresion.isEmpty()){
                System.out.println("Desea reescribir la expresión ["+RegresoDeLaExpresion(expresion)+"]?(0/si, 1/no)");
                int Reescribir=scanner.nextInt();
                scanner.nextLine();
                switch(Reescribir){
                    case 0->{
                        expresion.clear();
                        utilerias.ingresoDeExpresion(scanner, expresion);
                    }case 1->{
                        System.out.println("Saliendo");
                    }default->{
                        System.out.println("Error");
                    }
                } 
            }
    }
    public static String RegresoDeLaExpresion(LinkedList<String> expresion){
        String ExpresionConcatenada=new String();
        for(String Expresion: expresion){
            ExpresionConcatenada=ExpresionConcatenada+Expresion+",";
        }
        return ExpresionConcatenada;
    }
}
