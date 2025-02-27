package e2;

import java.util.Arrays;

public class ImmutableMatrix {
    private final int[][] matriz;

    public ImmutableMatrix (int[][] array) throws IllegalArgumentException{
        int temp;


        if(array == null || isMatrixRagged(array)){
            throw new IllegalArgumentException();
        } else {
            this.matriz = new int[array.length][];
            for (temp = 0; temp < array.length; temp++) {
                this.matriz[temp] = Arrays.copyOf(array[temp], array[temp].length);
            }
        }
    }

    public ImmutableMatrix (int filas, int columnas) throws IllegalArgumentException{
        int temp1, temp2, temp3 =1;


        if(filas < 0 || columnas < 0){
            throw new IllegalArgumentException();
        }
        this.matriz = new int[filas][columnas];
        for(temp1 = 0; temp1 < filas; temp1++){
            for(temp2 = 0; temp2 < columnas; temp2++){
                this.matriz[temp1][temp2] = temp3;
                temp3++;
            }
        }
    }

    public static boolean isMatrixRagged (int[][] array) throws IllegalArgumentException{
        int temp;
        boolean esVerdadero = Boolean.FALSE;


        if(array == null){
            throw new IllegalArgumentException();
        }
        for(temp = 1; temp < array.length; temp++){
            if(array[temp].length != array[0].length){
                esVerdadero = Boolean.TRUE;
                break;
            }
        }
        return esVerdadero;
    }

    public String toString(){
        int temp;
        StringBuilder cadenaMatriz = new StringBuilder();
        int[] tamanoFilas = new int[matriz.length];


        for(temp = 0; temp < tamanoFilas.length; temp++){
            cadenaMatriz.append(Arrays.toString(matriz[temp])).append('\n');
        }
        return cadenaMatriz.toString();
    }

    public  int at(int coordenadaFila, int coordenadaColumna) throws IllegalArgumentException{
        int[][] matrizTemp = new int[matriz.length][matriz[0].length];


        if(coordenadaFila < 0 || coordenadaFila > matrizTemp.length || coordenadaColumna < 0 ||
                coordenadaColumna > matrizTemp[0].length){
            throw new IllegalArgumentException();
        }
        return matriz[coordenadaFila][coordenadaColumna];
    }

    public int rowCount(){
        int temp;
        int[] tamanoFilas = new int[matriz.length];


        for (temp = 1; temp < tamanoFilas.length; temp++);
        return temp;
    }

    public int columnCount(){
        int temp;
        int[] tamanoColumnas = new int[matriz[0].length];


        for (temp = 1; temp < tamanoColumnas.length; temp++);
        return temp;
    }

    public int[][] toArray2D(){
        int temp;
        int [][] matrizTemp = new int[matriz.length][matriz[0].length];


        for(temp = 0; temp < matrizTemp.length; temp++){
            matrizTemp[temp] = Arrays.copyOf(matriz[temp], matriz[temp].length);
        }
        return matrizTemp;
    }

    public ImmutableMatrix reverse(){
        int temp1 , temp2, columnasParaInvertir = (matriz[0].length - 1);
        int [][] matrizTemp = new int [matriz.length][matriz[0].length];


        for(temp1 = 0; temp1 < matrizTemp.length; temp1++){
            for(temp2 = 0; temp2 < matrizTemp[0].length; temp2++){
                matrizTemp[temp1][temp2] = matriz[temp1][columnasParaInvertir - temp2];
            }
        }
        return new ImmutableMatrix(matrizTemp);
    }

    public ImmutableMatrix transpose(){
        int temp1 , temp2;
        int [][] matrizTemp = new int [matriz[0].length][matriz.length];


        for(temp1 = 0; temp1 < matrizTemp[0].length; temp1++){
            for(temp2 = 0; temp2 < matrizTemp.length  ; temp2++){
                matrizTemp[temp2][temp1] = matriz[temp1][temp2];
            }
        }

        return new ImmutableMatrix(matrizTemp);
    }

    public ImmutableMatrix reshape(int nuevoTamanoColumnas) throws IllegalArgumentException{
        int temp1 , temp2, temp3 = 0, filas = matriz.length, columnas = matriz[0].length, nuevoTamanoFilas;
        int [][] matrizTemp1;


        if(nuevoTamanoColumnas < 0|| (filas * columnas) % nuevoTamanoColumnas != 0){
            throw new IllegalArgumentException();
        } else {
            nuevoTamanoFilas = (filas * columnas) / nuevoTamanoColumnas;
            matrizTemp1 = new int[nuevoTamanoFilas][nuevoTamanoColumnas];
            for(temp1 = 0; temp1 < filas; temp1++){
                for(temp2 = 0; temp2 < columnas; temp2++){
                    matrizTemp1[temp3 / nuevoTamanoColumnas][temp3 % nuevoTamanoColumnas] = matriz[temp1][temp2];
                    temp3++;
                }
            }
        }
        return new ImmutableMatrix(matrizTemp1);
    }
}
