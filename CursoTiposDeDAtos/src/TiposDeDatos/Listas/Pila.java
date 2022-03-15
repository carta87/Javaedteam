package TiposDeDatos.Listas;

import java.util.ArrayList;

public class Pila {

    private ArrayList<Object> pila = new ArrayList<>();
    //push empujar
    private void púsh(Object elemento){
        pila.add(elemento);
    }
    //pop tomar
    private Object pop(){
        if (!pila.isEmpty()){

            Object t = pila.get(pila.size()-1);
            pila.remove(pila.size()-1);
            return t;
            // Object temporal = pila.get(pila.size()-1);
            //return  pila.get(pila.size()-1);

        }else{
            return null;
        }
    }

    private Object peek(){
        if (!pila.isEmpty()){
            return pila.get(pila.size()-1);
        }else {
            return null;
        }
    }
    //esta presente o vacio
    private boolean emptu(){
        return pila.isEmpty();

    }
    //cantidad
    private int size(){
        return  pila.size()+1;
    }


    public static void main(String[] args) {
        Pila pila =new Pila();
        pila.púsh("hola");
        pila.púsh(1);
        pila.púsh("x");
        pila.pop();
        System.out.println(pila.peek());
        System.out.println(pila.emptu());
        System.out.println(pila.size());
    }
}
