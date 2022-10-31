package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Números {
    private static int redondeo;
    private static ArrayList<BigDecimal> resultados;

    /**
     * Método principal
     */
    public static void main() {
        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        BigDecimal primero;
        BigDecimal segundo;
        resultados = new ArrayList<BigDecimal>();

        //Recogemos los dos números introducidos por el usuario más el número de decimales al que realizar la aproximación
        System.out.println("Introduzca 2 números:");
        primero = sc.nextBigDecimal();
        segundo = sc.nextBigDecimal();

        System.out.println("Introduzca el número de decimales al que redondear");
        redondeo = sc.nextInt();

        //Realizamos las operaciones indicadas
        operaciones(primero, segundo);
    }

    /**
     * @param primero Primer numero introducido por el usuario
     * @param segundo Segundo numero introducido por el usuario
     *                <p>
     *                Método encargado de realizar las operaciones indicadas
     */
    private static void operaciones(BigDecimal primero, BigDecimal segundo) {
        //Realizamos las operaciones indicadas anadiendolas al arraylist
        resultados.add(primero.add(segundo));   //Suma
        resultados.add(primero.subtract(segundo));  //Resta
        resultados.add(primero.divide(segundo, redondeo, RoundingMode.HALF_UP));    //Division
        resultados.add(primero.multiply(segundo));  //Multiplicación
        resultados.add(primero.remainder(segundo)); //Modulo

        redondear();

        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }

        //Realizamos la comparacion de los numeros introducidos
        int comparacion = primero.compareTo(segundo); //Diferencia
        if (comparacion == -1) {
            System.out.println("El segundo número introducido es mayor que el primero");
        } else if (comparacion == 0) {
            System.out.println("Ambos números son iguales");
        } else {
            System.out.println("El primer número introducido es mayor que el segundo");
        }
    }

    /**
     * Metodo encargado de realizar los redondeos de los resultados
     */
    private static void redondear() {
        for (int i = 0; i < resultados.size(); i++) {
            resultados.set(i, resultados.get(i).setScale(redondeo, RoundingMode.HALF_UP));
        }
    }
}
