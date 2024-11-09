package ArbolAritmetico.Nodos;

public class NodosArbolesAr{
    public String dato;
    public int posicion;
    public Boolean booleano=false;
    public NodosArbolesAr Padre=null;
    public NodosArbolesAr izq=null;
    public NodosArbolesAr der=null;
    public NodosArbolesAr(){
        izq=der=null;
    }
    public NodosArbolesAr(String data){
        this(data,null,null);
    }
    public NodosArbolesAr(String data, NodosArbolesAr lt, NodosArbolesAr rt){
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
    public String getData(){
        return dato;
    }
    public void setData(String valor){
        this.dato=valor;
    }
    public int getPosicion(){
        return posicion;
    }
    public void setposicion(int posicion){
        this.posicion=posicion;
    }
    public NodosArbolesAr getPadre(){
        return Padre;
    }
    public void setPadre(NodosArbolesAr Padre){
        this.Padre=Padre;
    }
    public Boolean getBool(){
        return booleano;
    }
    public void setBool(Boolean booleano){
        this.booleano=booleano;
    }
}
