package ArbolAritmetico.Nodos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Nodo {
    
    public int valor;
    public Nodo izq = null;
    public Nodo der = null;
    
    public Nodo(){
        izq=der=null;
    }
    public Nodo(int data){
        this(data,null,null);
    }
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    }   
    
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }
    public Nodo getIzq(){
        return izq;
    }
    public Nodo getDer(){
        return der;
    }
    public int getData(){
        return valor;
    }
    public void setData(int valor){
        this.valor=valor;
    }

    
}
