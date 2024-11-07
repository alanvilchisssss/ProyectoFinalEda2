package ArbolAritmetico.PuntoDeEntradaAritmetico;

import java.util.Scanner;

public class menu {
    public static void MenuDeAccionesAritmetico(Scanner scanner){
        int opcion=0;
        String expresion="";
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
                    if(expresion.equals("")){
                    expresion=utilerias.ingresoDeExpresion(scanner);
                    }else  if(!expresion.equals(null)){
                        System.out.println("Desea reescribir la expresión ["+expresion+"]?(0/si, 1/no)");
                        int Reescribir=scanner.nextInt();
                        scanner.nextLine();
                        switch(Reescribir){
                            case 0->{
                                expresion=utilerias.ingresoDeExpresion(scanner);
                            }case 1->{
                                System.out.println("Saliendo");
                            }default->{
                                System.out.println("Error");
                            }
                        } 
                    }
                }
                case 2->{
                    if(!expresion.equals("")){

                    }else{
                        System.out.println("Ingresa primero la expresión");
                    }
                }
                case 3->{
                    if(!expresion.equals("")){

                    }else{
                        System.out.println("Ingresa primero la expresión.");
                    }
                }
                case 4->{
                    System.out.println("Saliendo al menú principal.");
                }default->System.out.println("Error");
            }
        }while(opcion!=4);
    }
}
