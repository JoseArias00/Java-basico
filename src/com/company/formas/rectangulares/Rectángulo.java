package com.company.formas.rectangulares;

import com.company.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Esta clase hereda de la clase Rectangular y es una clase con el objeto de tipo Cuadrado
 *
 * @author Jose Maria
 */
public class Rectángulo extends Rectangular {
    private static final int LADOSIGUALES = 2;
    private BigDecimal lados1;
    private BigDecimal lados2;

    public Rectángulo() {
    }

    public Rectángulo(BigDecimal lados1, BigDecimal lados2) {
        super(LADOSIGUALES);
        this.lados1 = lados1;
        this.lados2 = lados2;
    }

    /**
     * @return El área del rectángulo creado
     * <p>
     * Método encargado de calcular el área del rectángulo a partir del valor de medida de los lados iguales
     */
    @Override
    public BigDecimal área() {
        return lados1.multiply(lados2);
    }


    /**
     * @return La cadena a imprimir en pantalla con los valores del rectángulo
     * <p>
     * Método encargado de concatenar a la cadena de la clase FormasGeométricas los valores del rectángulo generado
     */
    public String toString() {
        return super.toString().concat("---Rectángulo---\nLados1: " + lados1.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm\nLados2: " + lados2.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm\nÁrea: " + área().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm");
    }

}
