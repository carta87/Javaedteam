package TiposDeDatos.Listas;

import java.util.Enumeration;
import java.util.Hashtable;

public class Item {
    private String name;
    private int valor;

    public Item(String name, int valor) {
        this.name = name;
        this.valor = valor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", valor=" + valor ;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}

class Main{
    public static void main(String[] args) {
        Item item1= new Item("jose",20);
        Item item2= new Item("juan",25);
        Item item3= new Item("pedro",35);

        String temporal;

        Hashtable<String, Item> tabla = new Hashtable<String, Item>();
        tabla.put(item1.getName(), item1);
        tabla.put(item2.getName(),item2);
        tabla.put(item3.getName(),item3);

        Enumeration<String> keys = tabla.keys();
        while(keys.hasMoreElements()){
            temporal = keys.nextElement();
            System.out.println(tabla.get(temporal));
        }
    }
}
