package com.company;

import java.util.List;
import java.util.Scanner;

import static com.company.Kaprekar.*;

public class Matematica {

    public static void main() {
        operaciones();
    }

    private static void operaciones(){
        int num;
        int num1;
        int num2;
        int num3;

        System.out.println("Introduzca un número: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        System.out.println("Es número de kaprekar: " + esKaprekar(num));
        System.out.println("Introduzca 3 números más a comprobar: ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();
        List<Boolean> validos = sonKaprekar(num1,num2,num3);
        int identificador = 1;
        for (Boolean valido : validos){
            System.out.println("El número " + identificador + " es: " + ((valido) ? "Verdadero" : "Falso"));
            identificador ++;
        }
    }
}
