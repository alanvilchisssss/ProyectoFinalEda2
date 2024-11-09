package ArbolAritmetico.arbol;
import java.util.LinkedList;
import java.util.Queue;

import ArbolAritmetico.Recorridos.*;
import ArbolAritmetico.Nodos.NodosArbolesAr;
public class arbolAritmetico{
    public NodosArbolesAr root;
    public LinkedList<arbolAritmetico> arbolesConexos=new LinkedList<>();

    public arbolAritmetico(){
        root=null;
    }
    public arbolAritmetico(NodosArbolesAr Expresion){
        this.root=Expresion;
    }
    public static void OrdenarArbol(LinkedList<String> expresion, arbolAritmetico arbol){
        LinkedList<arbolAritmetico> ListaDeArboles=new LinkedList<>();
        LinkedList<String> RutasArboles=new LinkedList<>();
        arbolAritmetico arbolfinal=new arbolAritmetico();
        LinkedList<NodosArbolesAr> nodos=new LinkedList<>();
        SepararArboles(expresion, arbol, ListaDeArboles, RutasArboles);
        ListaDeArboles=ListaDeArboles.reversed();
        arbolfinal.add(ListaDeArboles.get(0).getRoot());
        arbolfinal=UnirArboles(ListaDeArboles);
        //Ejercicio2.Postfija(arbolfinal.getArbol(),nodos);

        /*for(NodosArbolesAr nodoss: nodos){
            System.out.println(nodoss.getData());
        }*/
        for(arbolAritmetico arboles: arbolfinal.getArbol()){
            arboles.breadthFrist();
        }
        //arbolfinal.breadthFrist();
        //ImprimirBonitoArbol(arbolfinal,expresion);
    }
    public static void ImprimirBonitoArbol(arbolAritmetico arbolfinal,LinkedList<String> expresion){
        System.out.println("Arbol construído:");
        System.out.println("\t\t\t\t\t\t"+arbolfinal.getRoot().getData());
        for(int i=0; i<expresion.size()-1; i++){
        }
    }
    public static arbolAritmetico UnirArboles(LinkedList<arbolAritmetico> ListaDeArboles){
        arbolAritmetico arbol=new arbolAritmetico();
        for(arbolAritmetico arbolesVecinos: ListaDeArboles){
            arbol.AddArbol(arbolesVecinos);
        }
        return arbol;
    }

    public static void SepararArboles(LinkedList<String> expresion, arbolAritmetico arbol,LinkedList<arbolAritmetico> ListaDeArboles,LinkedList<String> RutasArboles){
        LinkedList<String> listaDeValores=new LinkedList<>();
        for(String secciones: expresion){
            if(secciones.equals("*")||secciones.equals("+")||secciones.equals("-")||secciones.equals("/")){
                if(listaDeValores.isEmpty()){
                    NodosArbolesAr nodo=new NodosArbolesAr(secciones);
                    arbolAritmetico arbolaux=new arbolAritmetico(nodo);
                    ListaDeArboles.add(arbolaux);
                }else{
                    NodosArbolesAr nodoHijo1=new NodosArbolesAr(listaDeValores.get(0));
                    NodosArbolesAr nodoHijo2=new NodosArbolesAr(listaDeValores.get(1));
                    NodosArbolesAr nuevoNodo=new NodosArbolesAr(secciones,nodoHijo1,nodoHijo2);
                    nodoHijo1.setPadre(nuevoNodo);
                    nodoHijo2.setPadre(nuevoNodo);
                    arbolAritmetico auxiliar=new arbolAritmetico(nuevoNodo);
                    ListaDeArboles.add(auxiliar);
                    RutasArboles.add(auxiliar.getRoot().getData());
                    listaDeValores.clear();
                }
            }
            else{
                listaDeValores.add(secciones);
            }
        }
    }
    public void add(NodosArbolesAr padre, NodosArbolesAr hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    public void add(NodosArbolesAr padre, NodosArbolesAr hijo, NodosArbolesAr hijo2){
        padre.setIzq(hijo);
        padre.setDer(hijo2);
    }
    public void add(NodosArbolesAr padre, NodosArbolesAr hijo){
        padre.setIzq(hijo);
    }
    public void add(NodosArbolesAr padre){
        this.root=padre;
    }
    public void AñadirAutomatico(NodosArbolesAr nodo){
        if(this.root==null){
            this.root=nodo;
        }else if(root.getIzq()==null){
            root.setIzq(nodo);
        }else if(root.getDer()==null){
            root.setDer(nodo);
        }else{
            AñadirAutomatico(nodo);
        }
    }
    protected void visit(NodosArbolesAr n){
        System.out.println(n.getData()+" ");
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
    public NodosArbolesAr getRoot(){
        return root;
    }
    public void AddArbol(arbolAritmetico a){
        arbolesConexos.add(a);
    }
    public LinkedList<arbolAritmetico> getArbol(){
        return arbolesConexos;
    }
}
/*public static void PasarDeStringsANodos(LinkedList<String> RutasArboles,LinkedList<NodosArbolesAr> nodos){
        int contador_posiciones=0;
        RutasArboles=RutasArboles.reversed();
        do{
            NodosArbolesAr nodo=new NodosArbolesAr();
            nodo.setData(RutasArboles.get(contador_posiciones));
            nodo.setposicion(contador_posiciones);
            nodos.add(nodo);
            contador_posiciones++;
        }while(contador_posiciones<=RutasArboles.size()-1);
    }*/
    /*public NodosArbolesAr getPadre(NodosArbolesAr root){
        NodosArbolesAr nodoAuxiliar=root;
        List<NodosArbolesAr> notacion=new ArrayList<>();
        Ejercicio2.Prefija(nodoAuxiliar, notacion);
        System.out.println(notacion.getLast());
        return notacion.getLast();
    }*/