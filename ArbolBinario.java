public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }
        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRec(raiz.derecho, valor);
        }
        return raiz;
    }

    //Aqui es un solo metodo para los tres tipos de recorrido
    public void Recorrido(String tipo) {
        switch (tipo.toLowerCase()) {
            case "in":
                inOrdenRec(raiz);
                break;
            case "pre":
                preOrdenRec(raiz);
                break;
            case "post":
                postOrdenRec(raiz);
                break;
            default:
                System.out.println("Tipo de recorrido no válido.");
                return;
        }
        System.out.println();
    }

    private void inOrdenRec(Nodo raiz) {
        if (raiz != null) {
            inOrdenRec(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inOrdenRec(raiz.derecho);
        }
    }

    private void preOrdenRec(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdenRec(raiz.izquierdo);
            preOrdenRec(raiz.derecho);
        }
    }

    private void postOrdenRec(Nodo raiz) {
        if (raiz != null) {
            postOrdenRec(raiz.izquierdo);
            postOrdenRec(raiz.derecho);
            System.out.print(raiz.valor + " ");
        }
    }
}