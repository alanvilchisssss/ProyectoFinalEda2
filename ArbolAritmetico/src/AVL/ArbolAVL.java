package AVL;

/**
 *
 * @author Luis
 */
public class ArbolAVL {
    private NodoAVL root;

    public void clearAll() {
        root = null;
    }

    public void insertar(int key) {
        root = insertarRecursivo(root, key);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, int key) {
        if (nodo == null) return new NodoAVL(key);

        if (key < nodo.key) {
            nodo.left = insertarRecursivo(nodo.left, key);
        } else if (key > nodo.key) {
            nodo.right = insertarRecursivo(nodo.right, key);
        } else {
            return nodo; // Clave duplicada
        }

        nodo.altura = 1 + Math.max(getAltura(nodo.left), getAltura(nodo.right));
        return balancear(nodo, key);
    }

    public void buscar(int elemento) {
        System.out.println(buscarRecursivo(root, elemento) ? "Existe" : "No Existe");
    }

    private boolean buscarRecursivo(NodoAVL nodo, int elemento) {
        if (nodo == null) return false;
        if (elemento == nodo.key) return true;
        return (elemento < nodo.key) ? buscarRecursivo(nodo.left, elemento) : buscarRecursivo(nodo.right, elemento);
    }

    public void eliminar(int key) {
        root = eliminarRecursivo(root, key);
    }

    private NodoAVL eliminarRecursivo(NodoAVL nodo, int key) {
        if (nodo == null) return null;

        if (key < nodo.key) {
            nodo.left = eliminarRecursivo(nodo.left, key);
        } else if (key > nodo.key) {
            nodo.right = eliminarRecursivo(nodo.right, key);
        } else {
            nodo = eliminarNodo(nodo);
        }

        if (nodo == null) return null;

        nodo.altura = 1 + Math.max(getAltura(nodo.left), getAltura(nodo.right));
        return balancearEliminacion(nodo);
    }

    private NodoAVL eliminarNodo(NodoAVL nodo) {
        if (nodo.left == null || nodo.right == null) {
            return (nodo.left != null) ? nodo.left : nodo.right;
        } else {
            NodoAVL temp = getNodoConValorMaximo(nodo.left);
            nodo.key = temp.key;
            nodo.left = eliminarRecursivo(nodo.left, temp.key);
        }
        return nodo;
    }

    private NodoAVL balancear(NodoAVL nodo, int key) {
        int fe = getFactorEquilibrio(nodo);

        if (fe > 1 && key < nodo.left.key) return rotacionDerecha(nodo);
        if (fe < -1 && key > nodo.right.key) return rotacionIzquierda(nodo);
        if (fe > 1 && key > nodo.left.key) {
            nodo.left = rotacionIzquierda(nodo.left);
            return rotacionDerecha(nodo);
        }
        if (fe < -1 && key < nodo.right.key) {
            nodo.right = rotacionDerecha(nodo.right);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL balancearEliminacion(NodoAVL nodo) {
        int fe = getFactorEquilibrio(nodo);

        if (fe > 1 && getFactorEquilibrio(nodo.left) >= 0) return rotacionDerecha(nodo);
        if (fe < -1 && getFactorEquilibrio(nodo.right) <= 0) return rotacionIzquierda(nodo);
        if (fe > 1 && getFactorEquilibrio(nodo.left) < 0) {
            nodo.left = rotacionIzquierda(nodo.left);
            return rotacionDerecha(nodo);
        }
        if (fe < -1 && getFactorEquilibrio(nodo.right) > 0) {
            nodo.right = rotacionDerecha(nodo.right);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL rotacionDerecha(NodoAVL nodo) {
        NodoAVL nuevaRaiz = nodo.left;
        nodo.left = nuevaRaiz.right;
        nuevaRaiz.right = nodo;

        nodo.altura = 1 + Math.max(getAltura(nodo.left), getAltura(nodo.right));
        nuevaRaiz.altura = 1 + Math.max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right));

        return nuevaRaiz;
    }

    private NodoAVL rotacionIzquierda(NodoAVL nodo) {
        NodoAVL nuevaRaiz = nodo.right;
        nodo.right = nuevaRaiz.left;
        nuevaRaiz.left = nodo;

        nodo.altura = 1 + Math.max(getAltura(nodo.left), getAltura(nodo.right));
        nuevaRaiz.altura = 1 + Math.max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right));

        return nuevaRaiz;
    }

    public void mostrarArbolAVL() {
        System.out.println("Arbol AVL:");
        mostrarArbol(root, 0);
    }

    private void mostrarArbol(NodoAVL nodo, int depth) {
        if (nodo != null) {
            mostrarArbol(nodo.right, depth + 1);
            System.out.println("    ".repeat(depth) + "(" + nodo.key + ")");
            mostrarArbol(nodo.left, depth + 1);
        }
    }

    private int getAltura(NodoAVL nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private int getFactorEquilibrio(NodoAVL nodo) {
        return (nodo == null) ? 0 : getAltura(nodo.left) - getAltura(nodo.right);
    }

    private NodoAVL getNodoConValorMaximo(NodoAVL nodo) {
        while (nodo.right != null) nodo = nodo.right;
        return nodo;
    }
}
