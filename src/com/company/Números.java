package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.company.UtileriaNumeros.*;

/**
 * @author Jose Maria
 * <p>
 * Clase para el trabajo con números
 */
public class Números {

    /**
     * Constante que indica el total de números que pediremos por pantalla y con el que trabajaremos
     */
    private static final int NUMEROS_METER = 4;
    private static List<BigDecimal> numeros;

    /**
     * @throws RedondeoExcepcion Ocurre cuando al recoger la entrada por pantalla se indica un número al que redondear negativo
     */
    public static void main() throws RedondeoExcepcion {

        //Pediremos los datos por pantalla
        entrada();

        //Realizamos las operaciones indicadas
        operaciones();
    }

    /**
     * Método encargado de realizar todas las operaciones indicadas con los números de la lista
     */
    private static void operaciones() {
        //Suma
        System.out.println("La suma de estos números da: " + sumar(numeros));

        //Resta
        System.out.println("La resta de estos números da: " + restar(numeros));

        //División
        //Debido a que bigDecimal no divide entre 0 debemos comprobar que no se dividirá nunca entre 0 y en caso de que lo haga el valor sería infinito
        System.out.println((divideEntreCero(numeros)) ? "La división de estos números da: infinito" : "La división de estos números da: " + dividir(numeros));

        //Multiplicación
        System.out.println("La multiplicación de estos números da: " + multiplicar(numeros));

        //Módulo de dos números (los primeros pasados en la lista)
        System.out.println("El módulo de dividir el primer número con el segundo da: " + modulo(numeros.get(0), numeros.get(1)));

        //Comparación de todos los números de la cadena
        System.out.println("La comparación de los números es la siguiente: " + formatoOrdenacion(ordenacion(numeros)));

    }

    /**
     * @throws RedondeoExcepcion      Ocurre cuando se indica por pantalla un número negativo
     * @throws InputMismatchException Ocurre cuando se introduce un número de redondeo fuera del rango de valores de byte
     *                                <p>
     *                                Método encargado de recoger los datos por pantalla
     */
    private static void entrada() throws RedondeoExcepcion, InputMismatchException {
        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        int contador = 0;

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

        //Recogemos por pantalla la precisión con la que trabajaremos
        System.out.println("Introduzca el número de decimales al que realizaremos el redondeo en el trabajo con los números(0-127):");
        String precision = sc.nextLine();
        if (Long.parseLong(precision) >= 0) {
            if (Long.parseLong(precision) <= 127) {
                setPRECISION(Byte.parseByte(precision));
            } else {
                throw new InputMismatchException("El número introducido supera el rango de byte");
            }
        } else {
            throw new RedondeoExcepcion("El número de redondeo es negativo");
        }
    }
}
