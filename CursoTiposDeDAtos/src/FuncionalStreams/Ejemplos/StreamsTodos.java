package FuncionalStreams.Ejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamsTodos {
    public static void main(String[] args) throws Exception{
        //scraping(tecnica mediante programas de softeare pra extraer informacion de sitios web)
        // para poder traer las negritas ademas de eliminar con subString ciertos palabras


        System.out.println("priemer ejemplo... ");//extraer las plababras en negritas atravez de metodo getBoldTags
        String textoEjemplo = "hola <b>Mundo</b>, soy <b>carlos</b>";
        //getBoldTags(textoEjemplo);
        List<String> tags = getBoldTags(textoEjemplo);

        String contenidoHtml = getWebContent("https://bbc.com/");
        List<String> tagsMetodoDinamico = getTags(contenidoHtml, "h3");
        tags.stream().forEach(System.out::println);

        long total = tags.stream().filter(tag -> tag.equalsIgnoreCase("mundo")).count();
        System.out.println("Total:  " + total);

        //traer los resultados en un array ... los vas convertir en un listado
        List<String> resultado =tags.stream().filter(tag -> tag.equalsIgnoreCase("mundo")).collect(Collectors.toList());
        System.out.println(resultado.get(0));//ver el primer valor valor del listado

        //pregunntar si existe algun elemento de la arrray
        if (tags.stream().anyMatch(tag -> tag.equals("Mundo"))){
            System.out.println("encontrado");
        }
        //Modificar un valor ... forEch y modificar
        tags.stream().map(tag ->{
            return "<strong> " + tag + "</strong>";
        }).skip(1).forEach(System.out::println);//skip que se salete uno
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
        /*probbrando el primer metoso
        while (resultado.find()){
            System.out.println(resultado.group());
        }
        return tags;*/
    }
    private static List<String> getTags(String texto, String tipoDeTag){
        List<String> tags = new ArrayList<>();
        //expresion regular para sellecionar tags
        String regrese = "<" + tipoDeTag +">([^<>]*)<" + tipoDeTag + ">";//acepte todo menos las llaves menos de dos tag
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
            String linea;
            while ((linea = reader.readLine()) !=null){
                resultado.append(linea);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return resultado.toString();


    }
}
