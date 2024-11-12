package Heap;

import java.util.Scanner;
public class utilerias {
    public static void menu(){
        int opcion;
        Scanner sc=new Scanner(System.in);
        Heap heap=new Heap();
        do{
        System.out.println("--Menu Heap--");
        System.out.println("1.- Insertar clave");
        System.out.println("2.- Eliminar clave");
        System.out.println("3.- Imprimir arbol");
        System.out.println("4.- Salir");
        opcion=sc.nextInt();
        sc.nextLine();
        switch(opcion){
            case 1->{
                    System.out.println("Ingrese la clave:");
                    int valor=sc.nextInt();
                    heap.insercion(valor);
            }
            case 2->{
                if(heap.getRaiz()==null){
                    System.out.println("Debe asignar primero una raiz");
                    break;
                }else{
                    System.out.println("Ingrese el valor de la clave a eliminar:");
                    int eliminar=sc.nextInt();
                    heap.eliminar(eliminar);
                }
            }
            case 3->{
                System.out.println("Arbol por niveles:");
                heap.imprimirNiveles();
            }
            case 4->{
                System.out.println("Hasta Luego!");
            }
        }
        }while(opcion!=4);
    }
}
