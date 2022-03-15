package FuncionalStreams.Ejemplos;
import java.util.Arrays;

public class StreamsFlashMap8 {

    public static void main(String[] args) throws Exception {

    String[][] matriz ={{"java, php"}, {"C", "C++"}};
    long total = Arrays.stream(matriz).count();
    System.out.println("ejemplo 1= " + total);

    //metodo flasMap es concatenar String... traer lo elementos mas internos
                                  // que hay dentro de Matriz utilizarlo com un string


    String[][] matriz2 ={{"Java", "php"}, {"C", "C++"}};
    long total2 = Arrays.stream(matriz2).flatMap(array -> Arrays.stream(array)).count();
    System.out.println("ejemplo 2 =" + total2);//esta contando los elementos internos de cada arreglo
    }
}
