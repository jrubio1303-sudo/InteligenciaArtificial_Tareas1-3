public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido inorden del árbol binario:");
        arbol.Recorrido("in");

        System.out.println("Recorrido preorden del árbol binario:");
        arbol.Recorrido("pre");

        System.out.println("Recorrido postorden del árbol binario:");
        arbol.Recorrido("post");
    }
}