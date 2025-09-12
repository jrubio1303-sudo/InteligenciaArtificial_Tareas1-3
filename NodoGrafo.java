import java.util.ArrayList;
import java.util.List;

public class NodoGrafo {
    int valor;
    List<Arista> adyacentes;

    public NodoGrafo(int valor) {
        this.valor = valor;
        this.adyacentes = new ArrayList<>();
    }

    public void agregarAdyacente(NodoGrafo destino, int peso) {
        adyacentes.add(new Arista(destino, peso));
    }
}

class Arista {
    NodoGrafo destino;
    int peso;

    public Arista(NodoGrafo destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}