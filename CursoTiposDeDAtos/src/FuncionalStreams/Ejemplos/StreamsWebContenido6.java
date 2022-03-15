package FuncionalStreams.Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamsWebContenido6 {
    public static void main(String[] args) throws Exception{
        //scraping(tecnica mediante programas de softeare pra extraer informacion de sitios web)
        String textoEjemplo = "hola <b>Mundo</b>, soy <b>carlos</b>. " +
                " Bienvenidos al <b>Mundo</b> de lambda";
        //evita el  For
        List<String> tags = getBoldTags(textoEjemplo);

        //map sirve para Modificar un valor ...  como forEch y elemento lo modefica y lo retorna
        tags.stream().map(tag ->{
            return "<strong> " + tag + "</strong>";
        }).skip(1).forEach(System.out::println);//skip que se salete uno, ::println  es la
        // funcion que accionar con cada elementos forEch
    }
    private static List<String> getBoldTags(String texto){
        List<String> tags = new ArrayList<>();
        //expresion regular para sellecionar tags
        String regrese = "<b>(\\S+)</b>";
        Pattern pattern = Pattern.compile(regrese);
        Matcher resultado = pattern.matcher(texto);

        while (resultado.find()){
            String aux = resultado.group();
            aux = aux.substring(3, aux.length() -4);
            System.out.println(aux);
            tags.add(aux);
        }
        return tags;

    }
    private static List<String> getTags(String texto, String tipoDeTag){
        List<String> tags = new ArrayList<>();
        //expresion regular para sellecionar tags
        String regrese = "<" + tipoDeTag +">([^<>]*)<" + tipoDeTag + ">";//acepte a excepcion menos las llaves menos de dos tag
        Pattern pattern = Pattern.compile(regrese);
        Matcher resultado = pattern.matcher(texto);

        while (resultado.find()){
            String aux = resultado.group();
            Integer reducir = tipoDeTag.length() +2; //Settiar = Establecer
            aux = aux.substring( reducir, aux.length() -reducir);
            System.out.println(aux);
            tags.add(aux);
        }

        return tags;
    }
    private static  String getWebContent (String link){
        StringBuffer resultado = new StringBuffer();
        try {
            URL url = new URL(link);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String linea;//varaiable para leerlo
            while ((linea = reader.readLine()) !=null){
                resultado.append(linea);//cada linea la agrega al resultado
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return resultado.toString();


    }
}

