package FuncionalStreams.Concurencia;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ColeccionesConcurrentes {//hay clase para trabajar las colleciones

    private  static ConcurrentHashMap<Integer, String> map =  new ConcurrentHashMap<>();

    public static void main(String[] args) {
        //agregar si no existe
        map.putIfAbsent(1, "Java");
        map.putIfAbsent(2, "Python");
        map.putIfAbsent(3, "escala");

        //al ser repetido lo omite
        map.putIfAbsent(2,"Ruby" );

        map.replace(3, "Colombia");
        System.out.println(map);

    }
}
