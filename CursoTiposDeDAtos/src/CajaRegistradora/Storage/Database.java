package CajaRegistradora.Storage;

import CajaRegistradora.Objects.Meat;
import CajaRegistradora.Objects.Potato;
import CajaRegistradora.Objects.Product;
import CajaRegistradora.Objects.Rice;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private Product[] products;
    private List<Product> purchases;//compras
    private List<Product> sales;//ventas

    public Database(){
        products = new  Product[3];
        Product potato = new Potato("sabanera ");
        Product rice = new Rice("Arroz roa");
        Product meat = new Meat("Lomo fino");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;

        purchases = new ArrayList<>();
        sales = new ArrayList<>();
    }
    public Product getByIndex(int indice){
        if(indice < 0 || indice >2){
            System.out.println("indice invalido");
            return null;
        }
        Product result = null;
        try {
            return products[indice].clone();
        }catch (CloneNotSupportedException cnse){
            System.out.println(cnse);
        }
        return result;
    }
    public Product[] getAll(){
        Product[] result = new Product[3];
        try {
            result[0] = products[0].clone();
            result[1] = products[1].clone();
            result[2] = products[2].clone();
        }catch (CloneNotSupportedException cnse){
            System.out.println(cnse);
        }
        return result;
    }
    public void buy(Product product){
        Product temporal;
        switch (product.getClass().getSimpleName()){
            case "Potato":
                temporal = products[0];
                break;
            case  "Rice":
                temporal = products[1];
                break;
            case  "Meat":
                temporal = products[2];
                break;
            default:
                System.out.println("producto invalido");
                return;
        }

        temporal.setAmount(temporal.getAmount() + product.getAmount());
        temporal.setPrice(product.getPrice());
        purchases.add(product);
    }

    public void sale(Product product){
        Product temporal;
        switch (product.getClass().getSimpleName()){
            case "Potato":
                temporal = products[0];
                break;
            case  "Rice":
                temporal = products[1];
                break;
            case  "Meat":
                temporal = products[2];
                break;
            default:
                System.out.println("producto invalido");
                return;
        }

        temporal.setAmount(temporal.getAmount() - product.getAmount());
        product.setPrice(temporal.getPrice() * 1.25);//ingreso la cantidad de la ganancia
        sales.add(product);
    }

    public List<Product> getPurchases(){
        return purchases;
    }

    public List<Product> getSales(){
        return sales;
    }
}
