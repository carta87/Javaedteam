package TiposDeDatos.Arreglos;

import java.util.Vector;

public class VectorClase {
    public static void main(String[] args) {
        //la forma que incrmenta es al 100% de la capaciad
        //esta clase es sincronica... estar al tanto si crece o no decrece
        //afecta la velocidad segun la cantidad del tamaño del vector ... consume mas recursos

       // Vector vector = new Vector(9 ,2);
        Vector vector = new Vector();
        vector.add("jose");
        vector.add("lujan");
        vector.add("castillo");
        vector.insertElementAt("tafur", 0);
        vector.removeElementAt(2);

        System.out.println(vector);




    }
}
