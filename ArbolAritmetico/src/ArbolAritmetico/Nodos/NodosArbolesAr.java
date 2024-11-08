package ArbolAritmetico.Nodos;

public class NodosArbolesAr{
    public char dato;
    public NodosArbolesAr izq=null;
    public NodosArbolesAr der=null;
    public NodosArbolesAr(){
        izq=der=null;
    }
    public NodosArbolesAr(char data){
        this(data,null,null);
    }
    public NodosArbolesAr(char data, NodosArbolesAr lt, NodosArbolesAr rt){
        dato=data;
        izq = lt;
        der = rt;
    }  
    public void setIzq(NodosArbolesAr izq) {
        this.izq = izq;
    }
    
    public void setDer(NodosArbolesAr der) {
        this.der = der;
    }
    public NodosArbolesAr getIzq(){
        return izq;
    }
    public NodosArbolesAr getDer(){
        return der;
    }
    public char getData(){
        return dato;
    }
    public void setData(char valor){
        this.dato=valor;
    }
}
