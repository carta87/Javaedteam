package CajaRegistradora.Objects;

public abstract class Product implements Cloneable {
   private String name;
   private int amount;//cantidad
   private  double price;//precio

    public Product(){
    }

    public Product(String n){
        this.name = n;
    }

    @Override
    public String toString() {
        return  "Nombre = " + name  +
                ", Cantidad = " + amount +
                ", Precio = " + price ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount< 0){
            System.out.println("no puedo asignar una cantidad negativa");
            return;
        }
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0){
            System.out.println("no se puede asignar precio negativo");
            return;
        }
        this.price = price;
    }

    public Product clone()throws CloneNotSupportedException{
        return (Product) super.clone();
    }
}
