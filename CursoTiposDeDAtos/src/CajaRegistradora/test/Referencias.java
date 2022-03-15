package CajaRegistradora.test;

public class Referencias {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.nombre = "carlos";
        persona.edad = 34;

        Persona otraPersona = persona;
        otraPersona.nombre = "juliana";
        otraPersona.edad = 1;

        System.out.println(persona.nombre);// =juliana
        System.out.println(otraPersona.nombre);// =juliana
        // esta direciionando a la misma direccion de memoria

        //al crear una nueva instancia me perimite asignar o restablecer
        //los atributos originales a la primera persona
        Persona segundaPersona = new Persona();
        segundaPersona.nombre = persona.nombre;
        segundaPersona.edad = persona.edad;

        System.out.println(persona.nombre);
        System.out.println(persona.edad);
        System.out.println(otraPersona.nombre);
        System.out.println(otraPersona.edad);
        System.out.println(segundaPersona.nombre);
        System.out.println(segundaPersona.edad);

        //clonar los atributos por medio de la interface clone
        try {
            segundaPersona = persona.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        segundaPersona.edad = 15;
        segundaPersona.nombre = "leydi";


        System.out.println("______________");
        Persona persona3 = new Persona();
        persona3.nombre = "eduardo";
        persona3.edad = 12;
        System.out.println(persona3.nombre);
        System.out.println(persona3.edad);
        try {
            persona3.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        Persona persona4 = persona3;
        System.out.println(persona4.nombre);
        System.out.println(persona4.edad);


    }
}
