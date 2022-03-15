package FuncionalLambda;

import java.util.HashMap;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //Optional<Album> album = getAlbum("Random Accesss memories").orElseThrow(() -> new Exception("mensaje"));
        Optional<Album> album = getAlbum("Thriller" );
        if (album.isPresent()){//si esta presente se va realizar cierta operacion
            System.out.println("se encontro el album");
        }else {
            System.out.println("no se encontro el album");
        }

    }
    public static Optional<Album> getAlbum(String nombre){
        HashMap<String, Album> lista = new HashMap<>();
        lista.put("Thriller", new Album("Thriller", "Michael Jackson ","Records"));
        lista.put("Pasadena", new Album("Pasadena", "Guns N roses", "Sony"));
        lista.put("Cancion Animal", new Album("Cancion Animal", "Soda Esterio", "portat Discos"));

        Optional<Album> album = Optional.empty();//indicamos que esta vacio
        if (lista.containsKey(nombre)){//lista contienne el valor Key retornamos ese valor
            album = Optional.of(lista.get(nombre));
        }
        return album;
    }
}
