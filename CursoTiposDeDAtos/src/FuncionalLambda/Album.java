package FuncionalLambda;

public class Album {
    private String nombre;
    private String autor;
    private String discografia;

    public Album(String nombre, String autor, String discografia){
        this.nombre = nombre;
        this.autor = autor;
        this.discografia = discografia;
    }

    public Album(){
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDiscografia() {
        return discografia;
    }

    public void setDiscografia(String discografia) {
        this.discografia = discografia;
    }
}
