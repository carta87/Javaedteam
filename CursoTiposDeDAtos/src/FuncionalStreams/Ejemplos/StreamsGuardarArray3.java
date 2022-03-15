package FuncionalStreams.Ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamsGuardarArray3 {
    public static void main(String[] args) throws Exception {

            //apliacar un filto para guardarlo en un array
            String textoEjemplo = "hola <b>Mundo</b>, soy <b>carlos</b>. " +
                    " Bienvenidos al <b>Mundo</b> de lambda";
            //evita el  For
            List<String> tags = getBoldTags(textoEjemplo);


            List<String> resultado = tags.stream()  //1.adiciono esta lista para guardarlo en una lista
                                         .filter(tag -> tag.equalsIgnoreCase("mundo"))
                    .collect(Collectors.toList());//2.recolectrar los datos
                                           // del string y convertirlo en listado con Colllect
            System.out.println(resultado.get(0));//3. ver la posicion 0 de la lsita

           //para preguntar si hay algun elemento en la array o lista




        }
        private static List<String> getBoldTags(String texto) {
            List<String> tags = new ArrayList<>();
            //expresion regular para sellecionar tags
            String regrese = "<b>(\\S+)</b>";
            Pattern pattern = Pattern.compile(regrese);
            Matcher resultado = pattern.matcher(texto);

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

