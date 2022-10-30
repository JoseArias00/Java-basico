package com.company.formas.triangulares;

import com.company.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Esta clase hereda de la clase Triangular y es una clase con el objeto de tipo TriánguloEquilátero
 *
 * @author Jose Maria
 */
public class TriánguloEquilátero extends Triangular {
    private static final int LADOSIGUALES = 3;
    private BigDecimal lados;

    public TriánguloEquilátero() {
    }

    public TriánguloEquilátero(BigDecimal lados) {
        super(LADOSIGUALES);
        this.lados = lados;
    }

    /**
     * @return El área del triángulo creado
     * <p>
     * Método encargado de calcular el área del triángulo a partir del valor de medida de sus lados iguales
     */
    @Override
    public BigDecimal área() {
        return ((lados.pow(2)).multiply(BigDecimal.valueOf(3).pow(1 / 3))).divide(BigDecimal.valueOf(4));
    }

    /**
     * @return La cadena a imprimir en pantalla con los valores del triángulo equilátero
     * <p>
     * Método encargado de concatenar a la cadena de la clase FormasGeométricas los valores del triángulo generado
     */
    public String toString() {
        return super.toString().concat("---Triángulo Equilátero---\nLados: " + lados.setScale(Main.REDONDEO, RoundingMode.HALF_UP) +
                " cm\nÁrea: " + área().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm");
    }
}
