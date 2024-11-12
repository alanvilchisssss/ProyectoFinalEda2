package Heap;

class Nodo {
    private int valor;
    private Nodo izquierdo, derecho, padre;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.padre=null;
    }
    public Nodo getPadre(){
        return padre;
    }
    public void setPadre(Nodo padre){
        this.padre=padre;
    }
    public Nodo getIzq(){
        return izquierdo;
    }
    public Nodo getDer(){
        return derecho;
    }
    public int getValor(){
        return valor;
    }
    public void setIzq(Nodo izq){
        this.izquierdo=izq;
        if (izquierdo != null){ 
        izquierdo.padre = this;
        }
    }
    public void setDer(Nodo der){
        this.derecho=der;
        if (derecho != null){ 
        derecho.padre = this;
        }
    }
    public void setval(int val){
        this.valor=val;
    }
}