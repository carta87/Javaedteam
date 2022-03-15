package TiposDeDatos.Listas;

public class NodoArbol {
    int valor;
    NodoArbol hijoIzquierdo, hijoDerecho;

    public NodoArbol(int v){
        this.valor =v;
        hijoDerecho = hijoIzquierdo = null;
    }
    public int getValor(int valor){
        //return this.valor = valor;
        return valor;
    }
}

class Main2{
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insert(4);
        arbol.insert(2);
        arbol.insert(5);
        arbol.insert(8);
        arbol.insert(10);
        arbol.insert(3);
        arbol.ver(arbol.raiz);
    }

}
