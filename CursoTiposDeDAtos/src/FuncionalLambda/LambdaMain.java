package FuncionalLambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User("juan", "tafur", "juanTafur@hotmail.com"));
        list.add(new User("miguel", "tafur", "MiguelTafur@hotmail.com"));
        list.add(new User("carlos", "tafur", "cart_albert@hotmail.com"));

        //list.forEach(user -> System.out.println(user.getNombre()));

        list.sort((User userA, User userB) -> userA.getEmail().compareTo(userB.getEmail()));

        list.forEach(user -> {//operacion mas compleja requiere{}
            if(user.getNombre() == "carlos"){
                System.out.println("hola carlos");
            }else {
                System.out.println(user.getNombre());
            }
        });



    }
}
