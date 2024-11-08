package ArbolAritmetico.arbol;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ArbolAritmetico.Recorridos.*;
import ArbolAritmetico.Nodos.NodosArbolesAr;
public class arbolAritmetico{
    public NodosArbolesAr root;
    public arbolAritmetico(){
        root=null;
    }
    public arbolAritmetico(String expr){
        OrdenarArbol(expr);
    }
    public arbolAritmetico(NodosArbolesAr Expresion){
        this.root=Expresion;
    }
    public void OrdenarArbol(String expresion){
        char[] ExpresionSeparada=expresion.toCharArray();
        for(char letras_Por_Separado: ExpresionSeparada){
            System.out.println(Character.isDigit(letras_Por_Separado));
            if(!Character.isDigit(letras_Por_Separado)){
                boolean HijoActual=false;//si es falso el hijo ocupado es el izquierdo, si es verdadero el hijo es el derecho
                NodosArbolesAr nodo=new NodosArbolesAr(letras_Por_Separado);
                System.out.println("1");
                if(root==null){
                    add(nodo);
                }else{
                    NodosArbolesAr padre=getPadre(nodo);
                    if(HijoActual==true){
                        add(padre ,nodo,0);
                    }else if(HijoActual==false){
                        add(padre ,nodo,1);
                    }
                }
            }else if(Character.isDigit(letras_Por_Separado)){
            }
        }
    }
    public NodosArbolesAr getPadre(NodosArbolesAr root){
        NodosArbolesAr nodoAuxiliar=root;
        List<NodosArbolesAr> notacion=new ArrayList<>();
        Ejercicio2.Prefija(nodoAuxiliar, notacion);
        System.out.println(notacion.getLast());
        return notacion.getLast();
    }
    public void add(NodosArbolesAr padre, NodosArbolesAr hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    public void add(NodosArbolesAr padre){
        this.root=padre;
    }
    protected void visit(NodosArbolesAr n){
        System.out.println(n.dato+" ");
    }	
    
    public void breadthFrist(){
        NodosArbolesAr r = root;
	Queue<NodosArbolesAr> queue = new LinkedList();
        if(r!=null){
                queue.add(r);
                while(!queue.isEmpty()){
                    r = (NodosArbolesAr)queue.poll();
            visit(r);
            if(r.izq!=null)
                        queue.add(r.izq);
            if(r.der!=null)
            queue.add(r.der);
                }
        }
    }
}
