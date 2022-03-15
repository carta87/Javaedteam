package FuncionalStreams.ConcurrenciaBD;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {//creando varios  backup de varias BD con el fin que sea dianamico

    public static void main(String[] args) {
        BackupTask backupTask = new BackupTask();

        DatabasseConfig dbConfigA = new DatabasseConfig("admin" , "admin", "systemdb");
        DatabasseConfig dbConfigB = new DatabasseConfig("blog" , "blog123", "blogdb");
        DatabasseConfig dbConfigC = new DatabasseConfig("admin" , "admin", "estadisticasdb");

        //new BackupTask().backup(dbConfigA); si vamos a crear solo una

        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);//cantidad maxima de hilos
            service.submit(()-> backupTask.backup(dbConfigA));//que valla creando varios hilos en tareas
            service.submit(()-> backupTask.backup(dbConfigB));
            service.submit(()-> backupTask.backup(dbConfigC));

        }finally {
            if(service != null) service.shutdown();//que se cierra el executorservice
        }


    }
}
