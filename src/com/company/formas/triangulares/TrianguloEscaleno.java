package com.company.formas.triangulares;

import com.company.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Esta clase hereda de la clase Triangular y es una clase con el objeto de tipo TrianguloEscaleno
 *
 * @author Jose Maria
 */
public class TrianguloEscaleno extends Triangular {
    private static final int LADOSIGUALES = 2;
    private BigDecimal lado1;
    private BigDecimal lado2;
    private BigDecimal lado3;


    public TrianguloEscaleno() {
    }

    public TrianguloEscaleno(BigDecimal lado1, BigDecimal lado2, BigDecimal lado3) {
        super(LADOSIGUALES);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    /**
     * @return El área del triángulo creado
     * <p>
     * Método encargado de calcular el área del triángulo a partir del valor de medida de sus lados desiguales
     */
    @Override
    public BigDecimal área() {
        BigDecimal semiPerímetro = (lado1.add(lado2.add(lado3))).divide(BigDecimal.valueOf(2));
        BigDecimal SPMenosLado1 = semiPerímetro.subtract(lado1);
        BigDecimal SPMenosLado2 = semiPerímetro.subtract(lado2);
        BigDecimal SPMenosLado3 = semiPerímetro.subtract(lado3);
        return ((semiPerímetro.multiply(SPMenosLado1.multiply(SPMenosLado2).multiply(SPMenosLado3))).abs());
    }

    /**
     * @return La cadena a imprimir en pantalla con los valores del triángulo escaleno
     * <p>
     * Método encargado de concatenar a la cadena de la clase FormasGeometricas los valores del triángulo generado
     */
    public String toString() {
        return super.toString().concat("---Triángulo Escaleno---\nLado1: " + lado1.setScale(Main.REDONDEO, RoundingMode.HALF_UP) +
                " cm\nLado2: " + lado2.setScale(Main.REDONDEO, RoundingMode.HALF_UP) +
                " cm\nLado3: " + lado3.setScale(Main.REDONDEO, RoundingMode.HALF_UP) +
                " cm\nÁrea: " + área().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm");
    }
}
