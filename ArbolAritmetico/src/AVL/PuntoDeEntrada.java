package AVL;

/**
 *
 * @author Luis
 */

import java.util.Scanner;

public class PuntoDeEntrada {

    public static void MENU(Scanner scanner){
        ArbolAVL arbol = new ArbolAVL();
        int opcion;

        do {
            System.out.println("\nMenú de Árbol AVL:");
            System.out.println("1. Agregar clave");
            System.out.println("2. Buscar un valor");
            System.out.println("3. Eliminar clave");
            System.out.println("4. Mostrar árbol");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave a agregar: ");
                    int claveAgregar = scanner.nextInt();
                    arbol.insertar(claveAgregar);
                    System.out.println("Clave agregada.");
                    break;

                case 2:
                    System.out.print("Ingrese el valor a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    arbol.buscar(claveBuscar);
                    break;

                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    arbol.eliminar(claveEliminar);
                    System.out.println("Clave eliminada.");
                    break;

                case 4:
                    arbol.mostrarArbolAVL();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

    }
}
