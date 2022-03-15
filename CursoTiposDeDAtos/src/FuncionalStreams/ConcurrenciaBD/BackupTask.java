package FuncionalStreams.ConcurrenciaBD;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupTask {

    private final String FOLDER_PATH = "C:\\Users\\USUARIO\\Desktop\\Tafur";

    public synchronized void  backup(DatabasseConfig dbConfig){//cuando entra en este metodo no deja que otro
                                                              // entre hasta que alla terminado
        System.out.println("backup Started  at" + new Date());//para saber en que momento realizo el backup

        Date backupDate = new Date();  //fecha del dia actual
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String backupDateStr = format.format(backupDate);

        //creamos la ruta donde se van a guardar la ruta
        //String folderPath = "C:\\Users\\USUARIO\\Desktop\\Tafur";
        File file = new File(FOLDER_PATH);//SE CAMBIO EN CONSTANTE
        file.mkdir();//para que cree la carpecta

        //donde se va guardar el backup
        String saveFileName = "backup_" + dbConfig.getDbName() + "_" + backupDateStr + ".sql";
        String savePath = FOLDER_PATH + File.separator + saveFileName;

        //crear un archivo nuevo que va simular un backup de la base de datos
        String executeCmd = "cmd.exe /c echo. 2>" + savePath;

        execCommand(executeCmd);

    }
    private synchronized void execCommand(String executeCmd){
        System.out.println(executeCmd);
        Process runtimeProcess= null;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);//parte importante
        }catch (IOException e){
            e.printStackTrace();
        }
        int processComplete = 0;//seguimiento del proceso
        try {
            processComplete = runtimeProcess.waitFor();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (processComplete == 0){
            System.out.println("Command Complete at " + new Date());
        }else {
            System.out.println("command Failure" );
        }
    }
}
