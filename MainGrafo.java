//Los algoritmos fueron realizados con la ayuda de IA 
//y modificados por mi para ejemplos y entendimiento
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MainGrafo {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarNodo(1);
        grafo.agregarNodo(2);
        grafo.agregarNodo(3);
        grafo.agregarNodo(4);
        grafo.agregarNodo(5);
        grafo.agregarNodo(6);

        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(1, 3, 2);
        grafo.agregarArista(2, 3, 1);
        grafo.agregarArista(2, 4, 5);
        grafo.agregarArista(3, 6, 1);
        grafo.agregarArista(4, 6, 5);
        grafo.agregarArista(5, 6, 2);
        grafo.agregarArista(4, 5, 5);

        grafo.imprimir();

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Desde qué nodo quieres iniciar el recorrido?");
        int origen = sc.nextInt();
        
        System.out.print("¿A qué nodo quieres llegar desde el nodo " + origen + "? ");
        int destino = sc.nextInt();

        Map<Integer, Integer> previos = new HashMap<>();
        Map<Integer, Integer> distancias = Dijkstra.calcularDistancias(grafo, origen, previos);

        if (distancias.get(destino) == Integer.MAX_VALUE) {
            System.out.println("No hay camino del nodo " + origen + " al nodo " + destino);
        } else {
            System.out.println("Distancia mínima desde el nodo " + origen + " al nodo " + destino + ": " + distancias.get(destino));
            Dijkstra.imprimirCamino(origen, destino, previos);
        }
    }
}