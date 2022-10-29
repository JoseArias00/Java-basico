package com.company.formas;

import com.company.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Círculo extends FormasGeométricas {
    private static final int NUMLADOS = 0;
    private static final BigDecimal PI = BigDecimal.valueOf(Math.PI);
    private BigDecimal radio;
    private BigDecimal diametro;
    private BigDecimal circunferencia;
    private BigDecimal área;

    public Círculo() {
    }

    public Círculo(BigDecimal radio) {
        super(NUMLADOS);
        this.radio = radio;
    }

    /**
     * @return Área del círculo
     * <p>
     * Método encargado de calcular el área del círculo creado
     */
    @Override
    public BigDecimal área() {
        diametro = radio.multiply(BigDecimal.valueOf(2));
        circunferencia = diametro.multiply(PI);
        área = PI.multiply(radio.pow(2));
        return área;
    }

    /**
     * @return La cadena a imprimir en pantalla con los valores del círculo
     * <p>
     * Método encargado de concatenar los valores de cada círculo creado con la cadena inicial de la clase FormasGeométricas para distinguir cada figura
     */
    public String toString() {
        return super.toString().concat("---Círculo---\nRadio: " + radio.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + "cm\nÁrea: " + área().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + "cm\nCircunferencia: " + circunferencia.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + "cm");
    }
}
