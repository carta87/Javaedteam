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

public class StreamsHilos1_1 extends Thread{

    @Override
    public void run() {
        //parallel nos permite hacer concurencia.  poder ejercutar ese for en varios hilos

        String[] webs= {
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",
                "https://www.bbc.com/",

        };

        //Arrays.stream(webs).forEach(web ->{
        Arrays.stream(webs).parallel().forEach(web ->{//solo llamando el metodo lo reliza de forma mas optima
            //cantidad de hilos va depender de la cantidad de core,s de la pc
            //procesos muy pesados puede comenzar desde cualquier elemento del forEch
            String contenidoHtml = getWebContent(web);
            List<String> tags = getTags(contenidoHtml, "h3");

            tags.stream().forEach(System.out::println);

        });

    }

    private  List<String> getBoldTags(String texto) {
        List<String> tags = new ArrayList<>();
        //expresion regular para sellecionar tags
        String regrese = "<b>(\\S+)</b>";
        Pattern pattern = Pattern.compile(regrese);
        Matcher resultado = pattern.matcher(texto);

        while (resultado.find()) {
            String aux = resultado.group();
            aux = aux.substring(3, aux.length() - 4);
            System.out.println(aux);
            tags.add(aux);
        }
        return tags;

    }

    private  List<String> getTags(String texto, String tipoDeTag) {
        List<String> tags = new ArrayList<>();
        //expresion regular para sellecionar tags
        String regrese = "<" + tipoDeTag + ">([^<>]*)</" + tipoDeTag + ">";//acepte a excepcion menos las llaves menos de dos tag
        Pattern pattern = Pattern.compile(regrese);
        Matcher resultado = pattern.matcher(texto);

        while (resultado.find()) {
            String aux = resultado.group();
            Integer reducir = tipoDeTag.length() + 2; //Settiar = Establecer
            aux = aux.substring(reducir, aux.length() - reducir-1);
            //System.out.println(aux);
            tags.add(aux);
        }

        return tags;
    }

    private  java.lang.String getWebContent(String link) {
        StringBuffer resultado = new StringBuffer();
        try {
            URL url = new URL(link);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String linea;//varaiable para leerlo
            while ((linea = reader.readLine()) != null) {
                resultado.append(linea);//cada linea la agrega al resultado
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado.toString();


    }
}

