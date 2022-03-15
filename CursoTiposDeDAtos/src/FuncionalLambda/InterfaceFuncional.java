package FuncionalLambda;

@FunctionalInterface
public interface InterfaceFuncional {
    double calcular(double x, double y);//definicion funcion Abstracta
}



class main {
    public static void main(String[] args) {
        System.out.println(calcularArea(2,2.4));

    }
    private static double calcularArea(double ancho, double alto){
     InterfaceFuncional operacion = (width, height) -> width * height;
     return operacion.calcular(ancho, alto);
    }
}
