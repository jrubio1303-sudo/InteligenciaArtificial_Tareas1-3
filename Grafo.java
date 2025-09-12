import java.util.HashMap;
import java.util.Map;

public class Grafo {
    Map<Integer, NodoGrafo> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void agregarNodo(int valor) {
        nodos.putIfAbsent(valor, new NodoGrafo(valor));
    }

    public void agregarArista(int origen, int destino, int peso) {
        NodoGrafo nodoOrigen = nodos.get(origen);
        NodoGrafo nodoDestino = nodos.get(destino);
        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.agregarAdyacente(nodoDestino, peso);
            nodoDestino.agregarAdyacente(nodoOrigen, peso);
        }
    }

    public void imprimir() {
        for (NodoGrafo nodo : nodos.values()) {
            System.out.print("Nodo " + nodo.valor + " conectado a: ");
            for (Arista arista : nodo.adyacentes) {
                System.out.print("(" + arista.destino.valor + ", peso: " + arista.peso + ") ");
            }
            System.out.println();
        }
    }
}