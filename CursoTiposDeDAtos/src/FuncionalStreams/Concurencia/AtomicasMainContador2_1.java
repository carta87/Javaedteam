package FuncionalStreams.Concurencia;

import java.util.stream.IntStream;

public class AtomicasMainContador2_1 {
    public static void main(String[] args) {
        AtomicasContador2 contador = new AtomicasContador2();
        IntStream.range(0,100).parallel().forEach(value -> {//for de 1 a 100
           contador.agregar(1);

        });
        System.out.println(contador.get());
    }
}
