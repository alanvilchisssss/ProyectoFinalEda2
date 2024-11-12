package Heap;


import java.util.LinkedList;
import java.util.Queue;

class Heap {
    private Nodo raiz;

    public Heap() {
        this.raiz = null;
    }
    public Nodo getRaiz(){
        return raiz;
    }

    public void insercion(int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
        } else {
            Queue<Nodo> cola = new LinkedList<>();
            cola.add(raiz);

            while (!cola.isEmpty()) {
                Nodo actual = cola.poll();
                if (actual.getIzq() == null) {
                    actual.setIzq(new Nodo(valor));
                    heapify(actual.getIzq());
                    //heapify(actual, actual.getIzq());
                    break;
                } else {
                    cola.add(actual.getIzq());
                }

                if (actual.getDer() == null) {
                    actual.setDer(new Nodo(valor));
                    heapify(actual.getDer());
                    //heapify(actual, actual.getDer());
                    break;
                } else {
                    cola.add(actual.getDer());
                }
            }
        }
    }
    //private void heapify (Nodo padre, Nodo hijo) {
        //if (hijo.getValor() > padre.getValor()) {
            //int temp = hijo.getValor();
            //hijo.setval(padre.getValor());
            //padre.setval(temp);
        //}
    //}

    public void imprimirNiveles() {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        int nivel = 0;
        while (!cola.isEmpty()) {
            int tamañoNivel = cola.size();
            System.out.print("Nivel " + nivel + ": ");

            for (int i = 0; i < tamañoNivel; i++) {
                Nodo actual = cola.poll();
                System.out.print(actual.getValor() + " ");

                if (actual.getIzq() != null) {
                    cola.add(actual.getIzq());
                }
                if (actual.getDer() != null) {
                    cola.add(actual.getDer());
                }
            }
            System.out.println();
            nivel++;
        }
    }
    public void eliminar(int clave) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        Nodo nodoAEliminar = null;
        Nodo ultimoNodo = null;
        Nodo padreUltimoNodo = null;

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.getValor() == clave) {
                nodoAEliminar = actual;
            }
            if (actual.getIzq() != null) {
                padreUltimoNodo = actual;
                ultimoNodo = actual.getIzq();
                cola.add(actual.getIzq());
            }
            if (actual.getDer() != null) {
                padreUltimoNodo = actual;
                ultimoNodo = actual.getDer();
                cola.add(actual.getDer());
            }
        }
        if (nodoAEliminar == null) {
            System.out.println("La clave no existe");
            return;
        }
        if (ultimoNodo != null) {
            nodoAEliminar.setval(ultimoNodo.getValor());
            if (padreUltimoNodo.getIzq() == ultimoNodo) {
                padreUltimoNodo.getIzq().setval(0);
            } else {
                padreUltimoNodo.getDer().setval(0);
            }
            ajustarHeapDescendente(nodoAEliminar);
        }
    }
    private void ajustarHeapDescendente(Nodo nodo) {
        while (nodo != null) {
            Nodo mayorHijo = null;

            if (nodo.getIzq() != null && (nodo.getDer() == null || nodo.getIzq().getValor() > nodo.getDer().getValor())) {
                mayorHijo = nodo.getIzq();
            } else if (nodo.getDer() != null) {
                mayorHijo = nodo.getDer();
            }

            if (mayorHijo != null && mayorHijo.getValor() > nodo.getValor()) {
                int temp = nodo.getValor();
                nodo.setval(mayorHijo.getValor());
                mayorHijo.setval(temp);

                nodo = mayorHijo;
            } else {
                break;
            }
        }
    }
    private void heapify(Nodo nodo) {
        while (nodo.getPadre() != null && nodo.getValor() > nodo.getPadre().getValor()) {
            int temp = nodo.getPadre().getValor();
            nodo.getPadre().setval(nodo.getValor());
            nodo.setval(temp);
            nodo = nodo.getPadre();
        }
    }
}