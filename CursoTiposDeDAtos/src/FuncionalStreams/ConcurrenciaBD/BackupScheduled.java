package FuncionalStreams.ConcurrenciaBD;

import jdk.jfr.Enabled;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@Configuracion   Dependencia de springFramework- maven
//@EnabledScheduling  Dependencia de springFramework - maven
//despues para actualizar nos posicionamos en el proyecto, maven, Reload project

public class BackupScheduled {
    //programar la ejecucion automatica de una tarea- task

    //@Scheduled(cron = "0 0 0 * *?") se va ejecutar todos los dias a las 0 horas sin importar la fecha
    public void scheduleDbBackup(){

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
