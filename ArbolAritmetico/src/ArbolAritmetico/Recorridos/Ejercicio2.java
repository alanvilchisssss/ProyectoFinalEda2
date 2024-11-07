package ArbolAritmetico.Recorridos;
import java.util.List;
import ArbolAritmetico.Nodos.Nodo;
public class Ejercicio2{
	public static void Prefija(Nodo n,List<Nodo> notacion){
		if(n==null){
			return;
		}
		notacion.add(n);
		Prefija(n.getIzq(), notacion);
		Prefija(n.getDer(), notacion);
	}
	public static void Infija(Nodo n,List<Nodo> notacion){
		if(n==null){
			return;
		}
		Infija(n.getIzq(), notacion);
		notacion.add(n);
		Infija(n.getDer(), notacion);
	}
	public static void Postfija(Nodo n,List<Nodo> notacion){
		if(n==null){
			return;
		}
		Postfija(n.getIzq(), notacion);
		Postfija(n.getDer(), notacion);
		notacion.add(n);
	}
}