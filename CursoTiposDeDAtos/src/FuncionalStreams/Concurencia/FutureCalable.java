package FuncionalStreams.Concurencia;

import java.util.concurrent.*;

public class FutureCalable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //para instanciarlo .... la cantidad de hilos que va ejecutar al mismo tiempo
        ExecutorService executor = Executors.newFixedThreadPool(1);

       Future<String> hilo = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {//lo que se va ejecutar en este hilo
               Thread.sleep(1000 * 5);
                return "ok";
            }
        });

       hilo.cancel(true);

        Thread.sleep(1000 * 10);
        //preguntar si ya termnino = controlar el estado
       if(hilo.isDone()){
           try {
               System.out.println("termino " + hilo.get());
           } catch (CancellationException e) {
               System.out.println("fue interrumpido");
               //e.printStackTrace();
           }
       }else {
           System.out.println("sigue trabajando");
       }

    }
}
