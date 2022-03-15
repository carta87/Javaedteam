package TiposDeDatos.Arreglos;

public class areglos {




    public static void main(String[] args) {

        int arreglo[];// plural el nombre
        int numeros[] = new int[2];
        numeros[0] = 100;

        //para recorrer el arreglo
        for (int i = 0; i < numeros.length ; i++) {
            System.out.println(numeros[i]);
        }

        System.out.println("___________________");

        int numeros1[] = {1,2,3,4,5};
        utilizarArreglo(numeros1);
        System.out.println(numeros1[4]);
    }

    //arreglo como parametro... no es buena practica
    public static void utilizarArreglo(int numeros1[]){
        numeros1[4]= 1;
    }
}
