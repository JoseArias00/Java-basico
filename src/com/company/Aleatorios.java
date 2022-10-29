package com.company;

import com.company.formas.Círculo;
import com.company.formas.rectangulares.Cuadrado;
import com.company.formas.rectangulares.Rectángulo;

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
    private static int numCirculos;

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de círculos a crear:");
        numCirculos = sc.nextInt();
        /*System.out.println("Introduce el numero de triangulos");
        numTriangulos = sc.nextInt();*/
        System.out.println("Introduce el número de formas rectangulares");
        numRectángulos = sc.nextInt();

        generaCirculos(numCirculos);
        generaRectángulos(numRectángulos);
        //generaTriangulos(numTriangulos);
    }


    /**
     * @param cantidad Número de círculos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de círculos con valores aleatorios.
     */
    private static void generaCirculos(int cantidad) {
        for(int círculosCreados = 0; círculosCreados < cantidad ; círculosCreados++){
            BigDecimal radio = BigDecimal.valueOf(random()*100+1);
            Círculo círculo = new Círculo(radio);
            System.out.println("---------------Figura---------------\n" + círculo.toString());
        }

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
        int númeroRectángulos = cantidad - númeroCuadrados;

        //Primero generamos todos los cuadrados que se vayan a crear
        for (int cuadradosCreados = 0; cuadradosCreados < númeroCuadrados; cuadradosCreados++) {
            BigDecimal medidaLado = BigDecimal.valueOf(random() * 100 + 1);
            Cuadrado cuadrado = new Cuadrado(medidaLado);
            System.out.println("---------------Figura---------------\n" + cuadrado.toString());
        }

        for (int rectángulosCreados = 0; rectángulosCreados < númeroRectángulos; rectángulosCreados++) {
            BigDecimal medidaLado1 = BigDecimal.valueOf(random() * 100 + 1);
            BigDecimal medidaLado2 = BigDecimal.valueOf(random() * 100 + 1);
            Rectángulo rectángulo = new Rectángulo(medidaLado1, medidaLado2);
            System.out.println("---------------Figura---------------\n" + rectángulo.toString());
        }

    }
}
