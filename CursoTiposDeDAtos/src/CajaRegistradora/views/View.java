package CajaRegistradora.views;

import CajaRegistradora.Objects.Product;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void showHeaderPrincipla(){
        System.out.println("\t\t*************************************");
        System.out.println("\t\t* Bienvenido a la caja registradora *");
        System.out.println("\t\t*************************************");
    }
    public static void showMenuPrincipal(){
        System.out.println("\t\t\t 1. Comprar");
        System.out.println("\t\t\t 2. Vender");
        System.out.println("\t\t\t 3. Inventario");
        System.out.println("\t\t\t 4. Compras");
        System.out.println("\t\t\t 5. Ventas");
        System.out.println("\t\t\t 6. Salir");

    }
    public static void showGetOption(){
        System.out.print("\t\tDigite la opcion: ");
    }

    public static void showGetAmount(){System.out.println("\t\tDigite la Cantidad: ");
    }

    public static void showGetPrice()  { System.out.print("\t\tDigite el precio: ");
    }

    public static int getAmount(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
    public static double getPrice(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    public static int getOption (){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
    public static void showBuyHeader(){
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*            Menu Compras           *");
        System.out.println("\t\t*************************************");
        showItemsMenu();
    }
    public static void showSaleHeader(){
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*            Menu ventas            *");
        System.out.println("\t\t*************************************");
        showItemsMenu();
    }
    public static void showStockHeader(){
        System.out.println("\t\t**************************************************************");
        System.out.println("\t\t*                       Inventario                           *");
        System.out.println("\t\t**************************************************************");
        showItemsHeader();
    }

    public static void showItemsHeader(){
        System.out.println("\t\t--------------------------------------------------------------");
        System.out.println("\t\t*   PRODUCTO   \t\t| CANTIDAD \t |Vr UNITARIO \t|Vr TOTAL\t *");
        System.out.println("\t\t--------------------------------------------------------------");
    }
    public static void showBuyListHeadr(){
        System.out.println("\t\t***************************************************");
        System.out.println("\t\t*                   C O M P R A S                 *");
        System.out.println("\t\t***************************************************");
        showItemsHeader();
    }
    public static void showSaleListHeader(){
        System.out.println("\t\t***************************************************");
        System.out.println("\t\t*                    V E N T A S                  *");
        System.out.println("\t\t***************************************************");
        showItemsHeader();
    }
    public static void showItemsMenu(){
        System.out.println("\t\t 1. Papas                ");
        System.out.println("\t\t 2. Arroz                ");
        System.out.println("\t\t 3. Carne                ");
        System.out.println("\t\t 4. Volver               ");
    }
    public static void showThanks(){
        System.out.println("Gracias por utilizar nuestra primer APP");
    }

    public static void showOptionInvali (){
        System.out.println("Option invalida");
    }

    public static void showGetBack(String name){
        System.out.println("Saliendo del modulo..." + name);
    }

    public static void showItemsStock(Product[] products){
        for (Product product: products ) {
            System.out.println("\t\t* " + product.getName() + " \t\t| " + product.getAmount() +
                    " \t\t| " + product.getPrice() + "\t\t\t| " +(product.getAmount()*product.getPrice()) + " \t\t*" );
        }
    }
    public static void showAnyKey(){
        System.out.println("digite cualquier numero para continuar");
    }

    public static void showInvalidAmount(){
        System.out.println("la cantidad no es valida");
    }

    public static void showPurchases(List<Product> listado){
        for (Product v: listado) {
            System.out.println("\t\t* "+ v.getName()+ "\t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+ v.getAmount()*v.getPrice()+"\t\t*");
        }
    }
    public static void showSales(List<Product> listado){
        for (Product v: listado) {
            System.out.println("\t\t* " + v.getName() + "\t| " + v.getAmount() + "\t\t| " + v.getPrice()+"\t\t\t| " + v.getAmount() * v.getPrice() * 1.25 + "\t\t*");
        }
    }

}
