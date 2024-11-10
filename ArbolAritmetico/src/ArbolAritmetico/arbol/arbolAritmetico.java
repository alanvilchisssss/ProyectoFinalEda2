package ArbolAritmetico.arbol;
import java.util.LinkedList;
import java.util.Queue;
import ArbolAritmetico.Nodos.NodosArbolesAr;

public class arbolAritmetico{
    public NodosArbolesAr root;
    public static int totalDeCapas;
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
        SepararArboles(expresion, arbol, ListaDeArboles, RutasArboles);
        ImprimirBonitoArbol(arbol, expresion, RutasArboles,ListaDeArboles);
    }
    public static void ImprimirListaDeNodos(LinkedList<NodosArbolesAr> nodos){
        for(NodosArbolesAr nodo: nodos){
            System.out.println(nodo.getData()+" posicion: "+nodo.getPosicion());
        }
    }
    public static void ImprimirBonitoArbol(arbolAritmetico arbolfinal,LinkedList<String> expresion,LinkedList<String> RutasArboles,LinkedList<arbolAritmetico> ListaDeArboles){
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
        LinkedList<arbolAritmetico> arbolInvertido=new LinkedList<>();
        for(arbolAritmetico arboldo: ListaDeArboles){
            arbolInvertido.addFirst(arboldo);
        }

        totalDeCapas=(int) Math.sqrt(expresion.size())+1;
        System.out.println("***Arboles:***");
        for(int i=0; i<(totalDeCapas);i++){
            System.out.print("Capa: "+i+" ");
        }
        System.out.println();
        int nivel=0;
        for(arbolAritmetico nodosss: arbolInvertido){
            ImprimirSubArboles(nodosss.getRoot(),nivel);
            
            nivel++;
       }
    }
    public static void ImprimirSubArboles(NodosArbolesAr nodo, int nivel){
            for(int i=0; i<nivel; i++){
                System.out.print("\t");
            }
            System.out.print(nodo.getData());
            nodo.setBool(true);
            if(nodo.getIzq()!=null){
                ImprimirSubArboles(nodo.getIzq(), nivel+1);

            }
            if(nodo.getDer()!=null){
                ImprimirSubArboles(nodo.getDer(), nivel+1);
            }
            System.out.println();
    }
    public static arbolAritmetico UnirArboles(LinkedList<arbolAritmetico> ListaDeArboles){
        arbolAritmetico arbol=new arbolAritmetico();
        for(arbolAritmetico arbolesVecinos: ListaDeArboles){
            arbol.AddArbol(arbolesVecinos);
        }
        return arbol;
    }
    
    public static void SepararArboles(LinkedList<String> expresion, arbolAritmetico arbol,LinkedList<arbolAritmetico> ListaDeArboles,LinkedList<String> RutasArboles){
        LinkedList<String> expresionInvertida=new LinkedList<>();
        for(String nodo: expresion){
            expresionInvertida.addFirst(nodo);
        }
        int contadorDeNodos=0;
        for(String nodos: expresionInvertida){
            NodosArbolesAr nodo=new NodosArbolesAr(nodos);
            nodo.setposicion(contadorDeNodos);
            arbol.AñadirAutomatico(nodo);
            contadorDeNodos++;
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
    public boolean ComprobacionSignos(String datosNodo, String[]signos){
        for(String signo: signos){
            if(datosNodo.equals(signo)){
                return true;
            }
        }
        return false;
    }
    public void AñadirAutomatico(NodosArbolesAr nodo){
        String[] signos={"+","*","-","/"};
        NodosArbolesAr rutaArbol=this.root;
        if(this.root==null&&ComprobacionSignos(nodo.getData(), signos)){
            this.root=nodo;
        }else {
            ComprobacionesParaAñadir(rutaArbol, nodo,signos);
        }
    }
    public void ComprobacionesParaAñadir(NodosArbolesAr rutaArbol, NodosArbolesAr nodo,String[]signos){
        char[] aux=nodo.getData().toCharArray();
        Boolean ComprobarciónNumero=Character.isDigit(aux[0]);
            if((ComprobacionSignos(nodo.getData(), signos))&&(!ComprobacionSignos(rutaArbol.getData(), signos))){
                if(rutaArbol.getIzq()==null){
                    rutaArbol.setIzq(nodo);
                }else{
                    ComprobacionesParaAñadir(rutaArbol.getIzq(), nodo, signos);
                }
            }else if((ComprobacionSignos(nodo.getData(), signos))&&(ComprobacionSignos(rutaArbol.getData(), signos))){
                if(rutaArbol.getDer()==null){
                    rutaArbol.setDer(nodo);
                }else{
                    ComprobacionesParaAñadir(rutaArbol.getDer(), nodo, signos);
                }
            }else if(ComprobarciónNumero==true){
                if(rutaArbol.getIzq()==null){
                    rutaArbol.setIzq(nodo);
                }else if(rutaArbol.getDer()==null){
                    rutaArbol.setDer(nodo);
                }else{
                    ComprobacionesParaAñadir(rutaArbol.getDer(), nodo, signos);
                }
            }
    }
    protected void visit(NodosArbolesAr n){
        System.out.println(n.getData()+" Posicion:"+n.getPosicion());
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