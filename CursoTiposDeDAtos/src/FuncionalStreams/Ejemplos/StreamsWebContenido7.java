package FuncionalStreams.Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamsWebContenido7 {
    public static void main(String[] args) throws Exception {
        //scraping(tecnica mediante programas de softeare pra extraer informacion de sitios web)
        String contenidoHtml = getWebContent("https://www.bbc.com/");
        List<String> tags = getTags(contenidoHtml, "h3");

        tags.stream().forEach(System.out::println);

    }

    private static List<String> getBoldTags(String texto) {
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

    private static List<String> getTags(String texto, String tipoDeTag) {
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

    private static java.lang.String getWebContent(String link) {
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