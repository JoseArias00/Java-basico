package com.company.formas;

public class Circulo {
    private final double PI = Math.PI;
    private double radio;
    private double diametro;
    private double circunferencia;
    private double area;

    /**
     *              Constructor de la clase
     */
    public Circulo() {
    }

    /**
     * Método encargado de crear a partir del radio los siguientes parámetros
     */
    public void crear() {
        radio = Math.random() * 100 + 1;
        diametro = radio * 2;
        circunferencia = diametro * PI;
        area = PI * Math.pow(radio, 2);
    }

    /**
     * Método encargado de mostrar los valores del círculo creado
     */
    public void mostrar() {
        System.out.println("---Circulo---");
        System.out.println("Radio: " + this.radio);
        System.out.println("Diametro: " + this.diametro);
        System.out.println("Circunferencia: " + this.circunferencia);
        System.out.println("Area: " + this.area);
    }
}
