package com.company;

import java.util.Scanner;

public class Matematica {

    public static void main() {
        System.out.println("Introduzca un número de 4 dígitos (sin símbolo): ");
        Scanner sc = new Scanner(System.in);
        int dígito = sc.nextInt();
        Kaprekar kapre = new Kaprekar(dígito);
        System.out.println("Es kaprekar: " + kapre.esKaprekar());
    }
}
