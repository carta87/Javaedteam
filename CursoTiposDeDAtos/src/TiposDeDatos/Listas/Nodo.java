package TiposDeDatos.Listas;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    int valorODato;
    Nodo referencia;

    public Nodo(int d) {
        this.valorODato =d;
        this.referencia = null;
    }

    @Override
    public String toString() {
        return "DefiniendoListaSimple{" +
                "valorODato=" + valorODato +
                ", referencia=" + referencia +
                '}';
    }

    public int getValorODato() {
        return valorODato;
    }

    public Nodo getReferencia() {
        return referencia;
    }

    public void setReferencia(Nodo referencia) {
        this.referencia = referencia;
    }

    public static void main(String[] args) {

        List<String> miLista = new ArrayList<String>();
        miLista.add("huevos");
        miLista.add("carne");
        miLista.add("jamon");



        System.out.println(miLista);
        System.out.println(miLista.size());//cantidad de elementos/nodos
        System.out.println(miLista.get(1));//elegir un elemento

        //agregando un objecto
       List<Nodo> listaSimples = new ArrayList<Nodo>();
       listaSimples.add(new Nodo(1));
       listaSimples.add(new Nodo(2));
       listaSimples.add(new Nodo(3));

       //al imprimir los datos me salen las direciones de momoria donde viven eses objectos
        //a no ser que sobreescriba el toString
        System.out.println(listaSimples);

    }
}
  class ListaEnlazada{

    protected Nodo primero;

      public ListaEnlazada() {
          primero = null;
      }
      //regresa una lista para definir el primer elmento que deseamos agregar
      public ListaEnlazada agregarInicio(int dato){
          Nodo nuevo; //declarar y despues iniciar
          nuevo = new Nodo(dato);
          nuevo.referencia = primero;
          primero = nuevo;
          return this;
      }

      public void agregar(int d){
          Nodo nodof = new Nodo(d);
          nodof.referencia= null;

          if (primero==null){
              primero= nodof;
              return;
          }
          Nodo temporal;
          for (temporal =primero; temporal.getReferencia()!=null; temporal=temporal.getReferencia()) {
              temporal.setReferencia(nodof);

          }

      }
      public void eliminar(int v){
         boolean encontrado = false;
         Nodo nodoActual, nodoAnterior;
         nodoActual = primero;
         nodoAnterior =null;

         //buscar
         while (nodoActual!=null && !encontrado){
             encontrado= (nodoActual.valorODato == v);
             if (!encontrado){
                 nodoActual = nodoActual;
                 nodoActual = nodoActual.referencia;
             }
         }
         if (nodoActual!=null){
             if (nodoActual == primero){
                 primero = nodoActual.referencia;
             }else {
                 nodoAnterior.setReferencia(nodoActual.referencia);
             }
         }


      }

      public Nodo buscar(int d){
         Nodo nodoBuscar;
         for(nodoBuscar = primero; nodoBuscar!= null; nodoBuscar.getReferencia())
             if (d== nodoBuscar.valorODato)
                 return nodoBuscar;

             return null;

      }
      public  void ver(){
          Nodo nodover;
          int i= 0;
          nodover =primero;
          while (nodover!=null){
              System.out.println(nodover.valorODato);
              nodover = nodover.referencia;

          }
      }

      public static void main(String[] args) {
          ListaEnlazada lista = new ListaEnlazada();
          lista.agregarInicio(1);
          lista.agregarInicio(2);
          lista.agregarInicio(3);
          lista.ver();
          System.out.println(lista);

      }
  }