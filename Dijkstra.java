import java.util.*;

public class Dijkstra {
    public static Map<Integer, Integer> calcularDistancias(Grafo grafo, int origen, Map<Integer, Integer> previos) {
        Map<Integer, Integer> distancias = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();
        PriorityQueue<NodoDistancia> cola = new PriorityQueue<>(Comparator.comparingInt(nd -> nd.distancia));

        for (Integer id : grafo.nodos.keySet()) {
            distancias.put(id, Integer.MAX_VALUE);
            previos.put(id, null);
        }
        distancias.put(origen, 0);
        cola.add(new NodoDistancia(origen, 0));

        while (!cola.isEmpty()) {
            NodoDistancia actual = cola.poll();
            if (visitados.contains(actual.id)) continue;
            visitados.add(actual.id);

            NodoGrafo nodoActual = grafo.nodos.get(actual.id);
            for (Arista arista : nodoActual.adyacentes) {
                int nuevoDist = distancias.get(actual.id) + arista.peso;
                int destinoId = arista.destino.valor;
                if (nuevoDist < distancias.get(destinoId)) {
                    distancias.put(destinoId, nuevoDist);
                    previos.put(destinoId, actual.id);
                    cola.add(new NodoDistancia(destinoId, nuevoDist));
                }
            }
        }
        return distancias;
    }

    public static void imprimirCamino(int origen, int destino, Map<Integer, Integer> previos) {
        if (previos.get(destino) == null) {
            System.out.println("No hay camino del nodo " + origen + " al nodo " + destino);
            return;
        }
        List<Integer> camino = new ArrayList<>();
        for (Integer at = destino; at != null; at = previos.get(at)) {
            camino.add(at);
        }
        Collections.reverse(camino);
        System.out.print("Camino: ");
        for (int i = 0; i < camino.size(); i++) {
            System.out.print(camino.get(i));
            if (i < camino.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
    }
}

class NodoDistancia {
    int id;
    int distancia;

    public NodoDistancia(int id, int distancia) {
        this.id = id;
        this.distancia = distancia;
    }
}