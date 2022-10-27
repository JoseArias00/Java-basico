package com.company.formas;

public class Triangulo {
    private final int LADOS = 3;
    private double lado1;
    private double lado2;
    private double lado3;
    private double angulo1con2;
    private double angulo2con3;
    private double angulo3con1;
    private double area;
    private double altura;

    public Triangulo(){
    }

    public void crear(){
        lado1 = Math.random()*100-1;
        lado2 = Math.random()*100-1;
        lado3 = (Math.pow(lado1, 2) + Math.pow(lado2, 2)/2);
        angulo1con2 = 90.0;
        angulo2con3 = 45.0;
        angulo3con1 = 45.0;
        altura=lado2;
        area=(lado1*altura)/2;
    }

    public void mostrar(){
        System.out.println("---Triangulo---");
        System.out.println("Cateto 1: " + lado1);
        System.out.println("Cateto 2: " + lado2);
        System.out.println("Hipotenusa: " + lado3);
        System.out.println("Angulo 1: " + angulo1con2);
        System.out.println("Angulo 2: " + angulo2con3);
        System.out.println("Angulo 3: " + angulo3con1);
        System.out.println("Cateto: " + lado1);
        System.out.println("Area: " + area);
    }

}
