package CajaRegistradora.test;

import CajaRegistradora.Controllers.Register;
import CajaRegistradora.Objects.Product;
import CajaRegistradora.Storage.Database;
import CajaRegistradora.views.View;

public class MainTest {
    public static void main(String[] args) {
      /* probando  que si no sobreEscribo el toString me va devolver
        la direccion donde vive el objecto en memoria

       Jabon jabon = new Jabon("una marca buena");
        System.out.println(jabon);*/

        //Probando los recursos que hay en la database
       /* Database database= new Database();
        Product product = database.getByIndex(0);
        System.out.println(product);

        product.setName("pastusa");
        product.setAmount(3);
        product.setPrice(10_000);



        Product[] products = database.getAll();
        for(Product prueba : products ){
            System.out.println(prueba);
        }

        //probando metodo estatico no necesito crear una instancia
        View.showHeaderPrincipla();
        View.showMenuPrincipal();
        View.showGetOption();
        int option = View.getOption();
        System.out.println("la option digitada es " + option);*/

        //al final solo quedaria esta parte de codigo
        //para ejecutar nuestra caja registradora
        Register register = new Register();
        register.register();

    }

}
