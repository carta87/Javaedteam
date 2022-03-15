package FuncionalStreams.Concurencia;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicasVariables {//son variables preparadas para trabajar con concurencia

    private static Integer contador =0;
    private static AtomicInteger contadorAtomico = new AtomicInteger(0);
                        //se crea objecto y se inacializa en 0

    public static void main(String[] args) {
         ejemplo1();
         //ejemplo2();
    }

    public static void ejemplo1(){
        String[] lenguajes = {
                "Java", "Escala", "JavaScript", "Python", "Pascal", "Ruby", "C", "C++"};

        for (int i = 0; i < 100; i++) {
            contador =0;
            //varios procesos apuntando a misma variable contador con varios hilos al mismo tiempo
            Arrays.stream(lenguajes).parallel().forEach(lenjuaje -> {
                contador++;
            });
            System.out.println(contador);
        }

    }
    public static void ejemplo2(){
        String[] lenguajes = {
                "Java", "Escala", "JavaScript", "Python", "Pascal", "Ruby", "C", "C++"};

        for (int i = 0; i < 100; i++) {
            contadorAtomico.set(0);
            //varios procesos apuntando a misma variable contador con varios hilos al mismo tiempo
            Arrays.stream(lenguajes).parallel().forEach(lenjuaje -> {
               contadorAtomico.incrementAndGet();
            });
            System.out.println(contadorAtomico);
        }

    }


}
