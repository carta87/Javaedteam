package FuncionalStreams.Ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamsExtraerUnString1 {

    public static void main(String[] args) throws Exception{

        //scraping(tecnica mediante programas de softeare pra extraer informacion de sitios web)
        // para poder traer las negritas ademas de eliminar con subString ciertos palabras

        //extraer las plababras en negritas atravez de metodo getBoldTags
        String textoEjemplo = "hola <b>Mundo</b>, soy <b>carlos</b>";
        getBoldTags(textoEjemplo);

    }

    private static List<String> getBoldTags(String texto) {
        List<String> tags = new ArrayList<>();
        //expresion regular para sellecionar tags
        String regrese = "<b>(\\S+)</b>";
        Pattern pattern = Pattern.compile(regrese);
        Matcher resultado = pattern.matcher(texto);

        while (resultado.find()) {//senicllo
            System.out.println(resultado.group());
        }
        return tags;

        /*para quitarle los tag a la hora de imprimirlo
        while (resultado.find()){
            String aux = resultado.group();
            aux = aux.substring(3, aux.length() -4);
            System.out.println(aux);
            tags.add(aux);//agregamos al listado
        }
        return tags;*/
    }

}
