package CajaRegistradora.Controllers;

import CajaRegistradora.Objects.Meat;
import CajaRegistradora.Objects.Potato;
import CajaRegistradora.Objects.Product;
import CajaRegistradora.Objects.Rice;
import CajaRegistradora.Storage.Database;
import CajaRegistradora.views.View;

import java.util.List;

public class Register {
    private Database database;

    public Register(){
        database = new Database();
    }

    //este metodo inici el proceso de la registradora
    public void register(){

        View.showHeaderPrincipla();
        int option;
        do {
            View.showMenuPrincipal();  //vuelve a mostrar menu principal
            View.showGetOption();
            option = View.getOption();
            switch (option){
                case 1://comprar
                    buy();
                    break;
                case 2://vender
                    sale();
                    break;
                case 3://inventario
                    showStock();
                    break;
                case 4://compras
                    showPurchases();
                    break;
                case 5://ventas
                     showSales();
                case 6: //salir
                    View.showThanks();
                    System.exit(0);
                    break;
                default: View.showOptionInvali();
            }
        }while (option >=1 || option <= 6);
    }
    //se encargara de mostrar el menu de compras y obtener la opcion deseada por el usuario
    private void buy(){//comprar
        View.showBuyHeader();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <= 3){
                buyProduct(option);
            }else  if (option == 4){
                View.showGetBack("compras");
                return;
            } else {
                View.showOptionInvali();
            }
       }while (option <1 || option > 4);
    }
    //registra en la base de datos el producto comprado
    private void buyProduct(int option){
        Product product = null;
        switch (option){
            case 1:
                product = new Potato("Sabanera ");
                break;
            case 2:
                product = new Rice("Arroz Roa");
                break;
            case 3:
                product = new Meat("lomo fino");
                break;
            default:
                View.showOptionInvali();
        }
        View.showGetAmount();
        int amount = View.getAmount();
        View.showGetPrice();
        double price = View.getPrice();

        product.setAmount(amount);
        product.setPrice(price);
        database.buy(product);//guardamos el producto ingresado en la base de datos
    }
    private void showStock(){
        View.showStockHeader();
        View.showItemsStock(database.getAll());
        View.showAnyKey();
        View.getOption();
    }

    //se encargara de mostrar el menu de ventas y obtener la opcion deseada por el usuario
    private void sale(){//comprar
        View.showSaleHeader();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <= 3){
                saleProduct(option);
            }else  if (option == 4){
                View.showGetBack("ventas");
                return;
            } else {
                View.showOptionInvali();
            }
        }while (option <1 || option > 4);
    }
    //registra en la base de datos el producto venta
    private void saleProduct(int option){
        Product product = null;

        if (option<1 || option >3){
            View.showOptionInvali();
            return;
        }
        product= database.getByIndex(option-1);
        View.showGetAmount();
        int amount = View.getAmount();
        if (product.getAmount() < amount){
            View.showInvalidAmount();
            return;
        }
        product.setAmount(amount);//has aqui se valida si hay disponibilidad de cantidad
        //pero en siguiente linea realiza la operacion en la base de datos
        database.sale(product);//guardamos el producto ingresado en la base de datos
    }
    private void showPurchases(){
        List<Product> listado = database.getPurchases();
        View.showBuyListHeadr();
        View.showPurchases(listado);
    }

    private void showSales(){
        List<Product> listado = database.getSales();
        View.showSaleListHeader();
        View.showSales(listado);
    }

}




