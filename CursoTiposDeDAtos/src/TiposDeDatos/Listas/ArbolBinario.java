package TiposDeDatos.Listas;

public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario(){
        raiz =null;
    }
    public void insert(int v){
        NodoArbol nuevo = new NodoArbol(v);
        if (raiz ==null){
            raiz =nuevo;
        }else{
            NodoArbol temporal = raiz;
            NodoArbol padre;
            while (true){
                padre = temporal;
                if (v<temporal.valor){
                    temporal = temporal.hijoIzquierdo;
                    if (temporal == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }else {
                    temporal = temporal.hijoDerecho;
                    if (temporal==null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }

                }

            }
        }


    }
    public void ver(NodoArbol nodo){
        if (nodo!= null){
            ver(nodo.hijoIzquierdo);
            System.out.println(nodo.valor);
            ver(nodo.hijoIzquierdo);
        }

    }
    public boolean vacio(){
        return raiz== null;
    }
}
