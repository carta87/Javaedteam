package TiposDeDatos.Listas;

public class Cola {
    //el primero es el priemero para salir
    NodoCola primero, ultimo;
    int tamano;

    public Cola() {
          primero = ultimo = null;
          tamano = 0;
    }


    public void insertar(int valor){
       NodoCola nuevo = new NodoCola(valor);
       if (empty()){
           primero= nuevo;
       }else {
           ultimo.siguiente =nuevo;
           tamano++;
       }
       ultimo = nuevo;
       tamano++;


    }
    public int eleminar( ){
        int temporal = primero.valor;
        primero =primero.siguiente;
        tamano--;
        return temporal;
    }
    public int size(){
        return tamano;
    }
    public boolean empty(){
        return primero== null;
    }

    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.insertar(1);
        cola.insertar(2);
        cola.insertar(3);

        System.out.println(cola.eleminar());
        System.out.println(cola.eleminar());


    }
}
