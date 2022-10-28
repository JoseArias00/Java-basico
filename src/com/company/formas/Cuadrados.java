package com.company.formas;

public class Cuadrados {
    private double lado;
    private double area;

    public Cuadrados(){
    }

    /**
     * Método encargado de crear el cuadrado a partir de un lado
     */
    public void crear(){
        lado = Math.random()*100+1;
        area = Math.pow(this.lado, 2);
    }

    /**
     * Método encargado de mostrar los valores del cuadrado creado
     */
    public void mostrar(){
        System.out.println("---Cuadrado---");
        System.out.println("Lado: " + this.lado);
        System.out.println("Area: " + this.area);
    }
}
