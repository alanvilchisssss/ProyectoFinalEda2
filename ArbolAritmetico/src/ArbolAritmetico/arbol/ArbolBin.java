package ArbolAritmetico.arbol;

import java.util.LinkedList;
import java.util.Queue;
import ArbolAritmetico.Nodos.*;
public class ArbolBin {
    public Nodo root;
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }	
    
    public void breadthFrist(){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
        if(r!=null){
                queue.add(r);
                while(!queue.isEmpty()){
                    r = (Nodo)queue.poll();
            visit(r);
            if(r.izq!=null)
                        queue.add(r.izq);
            if(r.der!=null)
            queue.add(r.der);
                }
        }
    }
    public Nodo breadthFrist(int valor){
        Nodo r = root;
        Nodo aux=r;
	    Queue<Nodo> queue = new LinkedList();
        if(r!=null){
                queue.add(r);
                while(!queue.isEmpty()){
                    r = (Nodo)queue.poll();
                    if(r.getData()==valor){
                        aux=r;
                    }
                    //visit(r);
                    if(r.izq!=null)
                        queue.add(r.izq);
                    if(r.der!=null)
                        queue.add(r.der);
                }
        }
        return aux;
    }
    public boolean breadthFristBooleana(int valor){
        boolean Boolean=false;
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
        if(r!=null){
                queue.add(r);
                while(!queue.isEmpty()){
                    r = (Nodo)queue.poll();
                    if(r.getData()==valor){
                        Boolean=true;
                    }
                    visit(r);
                    if(r.izq!=null)
                        queue.add(r.izq);
                    if(r.der!=null)
                    queue.add(r.der);
                }
        }
        return Boolean;
    }

    public void eliminar(Nodo n){
        if(n.getIzq()!=null){
            n.setData(n.getIzq().getData());
                eliminar(n.getIzq());
        }else if(n.getDer()!=null){
            n.setData(n.getDer().getData());
                eliminar(n.getDer());
        }else{
            n.setData(0);
        }
    }

}

