package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.UtileriaNumeros.*;

public class Números {
    private static final int NUMEROS_METER = 2;

    /**
     * Método principal
     */
    public static void main() {
        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        List<BigDecimal> numeros = new ArrayList<>();

        //Recogemos los dos números introducidos por el usuario más el número de decimales al que realizar la aproximación
        System.out.println("Introduzca " + NUMEROS_METER + " números:");
        while (contador < NUMEROS_METER) {
            String numero = sc.nextLine();
            if (!isBigDecimal(numero)) {
                throw new NumberFormatException("La entrada no es un BigDecimal");
            } else {
                numeros.add(BigDecimal.valueOf(Double.parseDouble(numero)));
                contador++;
            }
        }

        //Realizamos las operaciones indicadas
        operaciones(numeros);
    }

    /**
     * @param primero Primer numero introducido por el usuario
     * @param segundo Segundo numero introducido por el usuario
     *                <p>
     *                Método encargado de realizar las operaciones indicadas
     */
    private static void operaciones(final List<BigDecimal> numeros) {
        //Realizamos las operaciones indicadas anadiendolas al arraylist

        //Suma
        System.out.println("La suma de estos números da: " + sumar(numeros));
        System.out.println("La resta de estos números da: " + restar(numeros));
        System.out.println("La división de estos números da: " + dividir(numeros));
        System.out.println("La multiplicación de estos números da: " + multiplicar(numeros));

        /*resultados.add(primero.subtract(segundo));  //Resta
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
        }*/
    }

    /**
     * Metodo encargado de realizar los redondeos de los resultados
     */
    /*private static void redondear() {
        for (int i = 0; i < resultados.size(); i++) {
            resultados.set(i, resultados.get(i).setScale(redondeo, RoundingMode.HALF_UP));
        }
    }*/
}
