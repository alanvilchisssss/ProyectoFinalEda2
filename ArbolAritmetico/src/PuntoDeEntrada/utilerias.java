package PuntoDeEntrada;
import java.util.Scanner;
import AVL.*;
import Heap.*;
import ArbolAritmetico.PuntoDeEntradaAritmetico.*;
public class utilerias {
    public static void menu(Scanner scanner){
        int opcion=0; 
        do{
            System.out.println("¿Qué desea realizar?");
            System.out.println("1.- árbol AVL");
            System.out.println("2.- Heap");
            System.out.println("3.- Arbol de expresión aritmética");
            System.out.println("4.- Salir");
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1->{
                    PuntoDeEntrada.MENU(scanner);
                }
                case 2->{
                    Heap.utilerias.menu();
                }
                case 3->{
                    menu.MenuDeAccionesAritmetico(scanner);
                }
                case 4->{
                    System.out.println("...Saliendo");
                }default->System.out.println("Error");
            }
        }while(opcion!=4);
    }
}
