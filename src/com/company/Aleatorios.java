package com.company;

import com.company.formas.rectangulares.Cuadrado;
import com.company.formas.rectangulares.Rectangulo;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Esta clase genera tantas figuras con valores aleatorios como se indique
 *
 * @author Jose Maria
 */
public class Aleatorios {
    private static int numRectángulos;

    public static void main() {
        Scanner sc = new Scanner(System.in);
        /*System.out.println("Introduce el número de formas geométricas a crear:");
        numCirculos = sc.nextInt();
        System.out.println("Introduce el numero de triangulos");
        numTriangulos = sc.nextInt();*/
        System.out.println("Introduce el numero de cuadrados");
        numRectángulos = sc.nextInt();

        //generaCirculos(numCirculos);
        generaRectángulos(numRectángulos);
        //generaTriangulos(numTriangulos);
    }


    /**
     * @param cantidad Número de círculos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de círculos con valores aleatorios.
     */
    private static void generaCirculos(int cantidad) {


    }

    /**
     * @param cantidad Número de triángulos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de triángulos con valores aleatorios.
     */
    private static void generaTriangulos(int cantidad) {

    }

    /**
     * @param cantidad Número de cuadrados a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de cuadrados con valores aleatorios.
     */
    private static void generaRectángulos(int cantidad) {
        int númeroCuadrados = (int) (random() * cantidad + 1);
        int númeroRectangulos = cantidad - númeroCuadrados;

        //Primero generamos todos los cuadrados que se vayan a crear
        for (int cuadradosCreados = 0; cuadradosCreados < númeroCuadrados; cuadradosCreados++) {
            BigDecimal medidaLado = BigDecimal.valueOf(random() * 100 + 1);
            Cuadrado cuadrado = new Cuadrado(medidaLado);
            System.out.println("---------------Figura---------------\n" + cuadrado.toString());
        }

        for (int rectangulosCreados = 0; rectangulosCreados < númeroRectangulos; rectangulosCreados++) {
            BigDecimal medidaLado1 = BigDecimal.valueOf(random() * 100 + 1);
            BigDecimal medidaLado2 = BigDecimal.valueOf(random() * 100 + 1);
            Rectangulo rectangulo = new Rectangulo(medidaLado1, medidaLado2);
            System.out.println("---------------Figura---------------\n" + rectangulo.toString());
        }

    }
}
