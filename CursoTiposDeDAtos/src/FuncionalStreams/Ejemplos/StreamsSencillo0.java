package FuncionalStreams.Ejemplos;

import java.util.Arrays;

public class StreamsSencillo0 {
    public static void main(String[] args) throws Exception{
        String[] palabras  = {"java", "python", "javaScript", "c", "php"};
        //convertir un arreglo en streams  ... sorted = ordenar
        Arrays.stream(palabras).sorted().forEach(recorrer -> System.out.println(recorrer));

    }
}
