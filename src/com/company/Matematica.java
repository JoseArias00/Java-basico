package com.company;

import java.util.Scanner;

public class Matematica {

    public static void main() {
        System.out.println("Introduzca un número de 4 dígitos (sin símbolo): ");
        Scanner sc = new Scanner(System.in);
        String dígito = sc.nextLine();
        Kaprekar kapre = new Kaprekar(dígito);
        kapre.esVálido();
    }
}
