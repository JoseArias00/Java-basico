package com.company;

import com.company.formas.Circulo;
import com.company.formas.Cuadrados;
import com.company.formas.Triangulo;

import java.util.Scanner;

public class Aleatorios {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        int numCirculos;
        int numCuadrados;
        int numTriangulos;
        System.out.println("Introduce el numero de circulos");
        numCirculos = sc.nextInt();
        System.out.println("Introduce el numero de triangulos");
        numTriangulos = sc.nextInt();
        System.out.println("Introduce el numero de cuadrados");
        numCuadrados = sc.nextInt();

        generaCirculos(numCirculos);
        generaCuadrados(numCuadrados);
        generaTriangulos(numTriangulos);
    }


    /**
     * @param cantidad Número de círculos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de círculos con valores aleatorios.
     */
    private static void generaCirculos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Circulo circulo = new Circulo();
            circulo.crear();
            circulo.mostrar();
        }

    }

    /**
     * @param cantidad Número de triángulos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de triángulos con valores aleatorios.
     */
    private static void generaTriangulos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Triangulo triangulo = new Triangulo();
            triangulo.crear();
            triangulo.mostrar();
        }
    }

    /**
     *
     * @param cantidad Número de cuadrados a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de cuadrados con valores aleatorios.
     *
     */
    private static void generaCuadrados(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Cuadrados cuadrados = new Cuadrados();
            cuadrados.crear();
            cuadrados.mostrar();
        }
    }
}
