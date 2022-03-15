package FuncionalStreams.Ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamsNumeroVecesRepetido2 {
    public static void main(String[] args) throws Exception{

        //para conocer la cantidad de veces que se repite un valor
        String textoEjemplo = "hola <b>Mundo</b>, soy <b>carlos</b>. " +
                " Bienvenidos al <b>Mundo</b> de lambda";
        //getBoldTags(textoEjemplo);

        //evita el  For
        List<String> tags = getBoldTags(textoEjemplo);
        long total = tags.stream()
                         .filter(tag -> tag.equalsIgnoreCase("mundo"))
                         .count();
        System.out.println("Total: " + total);


    }
    private static List<String> getBoldTags(String texto) {
        List<String> tags = new ArrayList<>();
        //expresion regular para sellecionar tags
        String regrese = "<b>(\\S+)</b>";
        Pattern pattern = Pattern.compile(regrese);
        Matcher resultado = pattern.matcher(texto);

        /*while (resultado.find()) {//senicllo
            System.out.println(resultado.group());
        }
        return tags;*/

        //para quitarle los tag a la hora de imprimirlo
        while (resultado.find()){
            String aux = resultado.group();
            aux = aux.substring(3, aux.length() -4);
            //System.out.println(aux);
            tags.add(aux);//agregamos al listado
        }
        return tags;
    }

}
