package com.company.formas;

public class Cuadrados {
    private double lado;
    private double area;

    public Cuadrados(){
    }

    public void crear(){
        lado = Math.random()*100+1;
        area = Math.pow(this.lado, 2);
    }

    public void mostrar(){
        System.out.println("---Cuadrado---");
        System.out.println("Lado: " + this.lado);
        System.out.println("Area: " + this.area);
    }
}
