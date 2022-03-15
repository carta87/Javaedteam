package FuncionalStreams.Concurencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamsHilos1 {

    //en el main se va ejecutar un hilo pero a la vez va ejecutar otro hilo gracias
    //se extendio Thread y se implemento el metodo run y en este main se inicio con start

    public static void main(String[] args) throws InterruptedException {
        StreamsHilos1_1 streamsHilos1_1 = new StreamsHilos1_1();
        System.out.println("Inicio");
        Thread.sleep(1000 * 2);//para pausar el hilo por 2 segundos
        streamsHilos1_1.setPriority(2);//dependiendo de la tarea asginar priorodad esto hara que utilizara la
                                      // mayoria de recuros para realizar la tarrea que es mas pesada
        streamsHilos1_1.start();
        System.out.println("final");
    }
}
