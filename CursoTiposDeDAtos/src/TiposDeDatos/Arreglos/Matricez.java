package TiposDeDatos.Arreglos;

public class Matricez {


    public static void main(String[] args) {
        int numeros1[][] = new int[4][4];

        int datos[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(datos[i][j]);

            }

        }
        System.out.println("_______________");

        //Matriz de tres dimenciones

        int x = 3;
        int y = 3;
        int z = 3;

        String cubo[][][] = new String[x][y][z];

        //para llenar los datos del arreglo
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    cubo[i][j][k] = String.valueOf(i) + String.valueOf(j) +
                            String.valueOf(k);
                }

            }

        }


        //para leer los datos
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    System.out.println(cubo[i][j][k]);
                }

            }

        }
    }
}
