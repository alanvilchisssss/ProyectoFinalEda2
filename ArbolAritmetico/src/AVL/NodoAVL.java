package AVL;

/**
 *
 * @author Luis
 */
public class NodoAVL {
    int key;
    int altura;
    NodoAVL right;
    NodoAVL left;
    NodoAVL(int d) {
        key = d;
        altura = 1;
    }
}