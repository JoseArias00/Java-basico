package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Numeros {
    private static int redondeo;
    private static ArrayList<BigDecimal> resultados;

    /**
     * Metodo principal
     */
    public static void main() {
        //Declaracion de variables
        Scanner sc = new Scanner(System.in);
        BigDecimal primero;
        BigDecimal segundo;
        resultados = new ArrayList<BigDecimal>();

        //Recogemos los dos numeros introducidos por el usuario mas el numero de decimales al que realizar la aproximacion
        System.out.println("Introduzca 2 numeros:");
        primero = sc.nextBigDecimal();
        segundo = sc.nextBigDecimal();

        System.out.println("Introduzca el numero de decimales al que redondear");
        redondeo = sc.nextInt();

        //Realizamos las operaciones indicadas
        operaciones(primero, segundo);
    }

    /**
     * @param primero Primer numero introducido por el usuario
     * @param segundo Segundo numero introducido por el usuario
     *
     * Metodo encargado de realizar las operaciones indicadas
     */
    private static void operaciones(BigDecimal primero, BigDecimal segundo) {
        //Realizamos las operaciones indicadas anadiendolas al arraylist
        resultados.add(primero.add(segundo));   //Suma
        resultados.add(primero.subtract(segundo));  //Resta
        resultados.add(primero.divide(segundo, redondeo, RoundingMode.HALF_UP));    //Division
        resultados.add(primero.multiply(segundo));  //Multiplicacion
        resultados.add(primero.remainder(segundo)); //Modulo

        redondear();

        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }

        //Realizamos la comparacion de los numeros introducidos
        int comparacion = primero.compareTo(segundo); //Diferencia
        if (comparacion == -1) {
            System.out.println("El segundo numero introducido es mayor que el primero");
        } else if (comparacion == 0) {
            System.out.println("Ambos numeros son iguales");
        } else {
            System.out.println("El primer numero introducido es mayor que el segundo");
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
