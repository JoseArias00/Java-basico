package com.company;

import com.company.formas.Círculo;
import com.company.formas.rectangulares.Cuadrado;
import com.company.formas.rectangulares.Rectángulo;
import com.company.formas.triangulares.TriánguloEquilátero;
import com.company.formas.triangulares.TriánguloEscaleno;
import com.company.formas.triangulares.TriánguloIsósceles;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Esta clase genera tantas figuras con valores aleatorios como se indique
 *
 * @author Jose Maria
 */
public class Aleatorios {
    private static final String ERROR = "Lo sentimos,debes introducir un valor entero sin decimales (0-32.767)";

    /**
     * @throws InputMismatchException Excepción lanzada cuando se introduce un valor distinto a un valor entero
     *                                <p>
     *                                Método main donde recogemos en consola los valores deseados solicitados al cliente
     */
    public static void main() throws InputMismatchException {
        int numRectángulos;
        int numCirculos;
        int numTriángulos;
        Scanner sc = new Scanner(System.in);

        //Comprobamos que la entrada sea un int con un try catch y luego que cada valor sea positivo
        try {
            System.out.println("Introduce el número de círculos a crear:");
            numCirculos = sc.nextInt();
            while (numCirculos < 0) {
                throw new InputMismatchException();

            }

            System.out.println("Introduce el número de formas rectangulares (se generarán cuadrados y rectángulos de forma aleatoria):");
            numRectángulos = sc.nextInt();
            while (numRectángulos < 0) {
                throw new InputMismatchException();

            }

            System.out.println("Introduce el número de triángulos (se generarán triángulos equiláteros, isósceles y escalenos de forma aleatoria):");
            numTriángulos = sc.nextInt();
            while (numTriángulos < 0) {
                throw new InputMismatchException();
            }

            //Indicamos por órden el número de figuras a crear de cada tipo
            if (numCirculos > 0) {
                generaCirculos(numCirculos);
            }

            if (numRectángulos > 0) {
                generaRectángulos(numRectángulos);
            }

            if (numTriángulos > 0) {
                generaTriángulos(numTriángulos);
            }
        } catch (InputMismatchException e) {
            System.err.println(ERROR);
            main();
        }


    }


    /**
     * @param cantidad Número de círculos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de círculos con valores aleatorios.
     */
    private static void generaCirculos(int cantidad) {
        for (int círculosCreados = 0; círculosCreados < cantidad; círculosCreados++) {
            BigDecimal radio = BigDecimal.valueOf(random() * 100 + 1);
            Círculo círculo = new Círculo(radio);
            System.out.println("---------------Figura---------------\n" + círculo.toString());
        }

    }

    /**
     * @param cantidad Número de triángulos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de triángulos con valores aleatorios.
     */
    private static void generaTriángulos(int cantidad) {
        int numEquiláteros;
        int numIsósceles;
        int numEscalenos;
        //Usamos el azar para saber cuantos triángulos crear de cada tipo
        numEquiláteros = (int) (random() * cantidad + 1);
        cantidad -= numEquiláteros;
        for (int numEquiCreados = 0; numEquiCreados < numEquiláteros; numEquiCreados++) {
            BigDecimal lados = BigDecimal.valueOf(random() * 100 + 1);
            TriánguloEquilátero tEquilatero = new TriánguloEquilátero(lados);
            System.out.println("---------------Figura---------------\n" + tEquilatero.toString());
        }

        if (cantidad > 0) {
            numIsósceles = (int) (random() * cantidad + 1);
            cantidad -= numIsósceles;

            for (int numIsoCreados = 0; numIsoCreados < numIsósceles; numIsoCreados++) {
                BigDecimal ladosIguales = BigDecimal.valueOf(random() * 100 + 1);
                BigDecimal ladoDesigual = BigDecimal.valueOf(random() * 100 + 1);
                TriánguloIsósceles tIsósceles = new TriánguloIsósceles(ladosIguales, ladoDesigual);
                System.out.println("---------------Figura---------------\n" + tIsósceles.toString());
            }
            if (cantidad > 0) {
               numEscalenos = (int) (random() * cantidad + 1);

                for (int numEscaCreados = 0; numEscaCreados < numEscalenos; numEscaCreados++) {
                    BigDecimal lado1 = BigDecimal.valueOf(random() * 100 + 1);
                    BigDecimal lado2 = BigDecimal.valueOf(random() * 100 + 1);
                    BigDecimal lado3 = BigDecimal.valueOf(random() * 100 + 1);
                    TriánguloEscaleno tEscaleno = new TriánguloEscaleno(lado1, lado2, lado3);
                    System.out.println("---------------Figura---------------\n" + tEscaleno.toString());
                }
            }
        }

    }

    /**
     * @param cantidad Número de cuadrados a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de cuadrados con valores aleatorios.
     */
    private static void generaRectángulos(int cantidad) {
        int numCuadrados = (int) (random() * cantidad + 1);
        int numRectángulos = cantidad - numCuadrados;

        //Primero generamos todos los cuadrados que se vayan a crear
        for (int cuadradosCreados = 0; cuadradosCreados < numCuadrados; cuadradosCreados++) {
            BigDecimal medidaLado = BigDecimal.valueOf(random() * 100 + 1);
            Cuadrado cuadrado = new Cuadrado(medidaLado);
            System.out.println("---------------Figura---------------\n" + cuadrado.toString());
        }

        for (int rectángulosCreados = 0; rectángulosCreados < numRectángulos; rectángulosCreados++) {
            BigDecimal medidaLado1 = BigDecimal.valueOf(random() * 100 + 1);
            BigDecimal medidaLado2 = BigDecimal.valueOf(random() * 100 + 1);
            Rectángulo rectángulo = new Rectángulo(medidaLado1, medidaLado2);
            System.out.println("---------------Figura---------------\n" + rectángulo.toString());
        }

    }
}
