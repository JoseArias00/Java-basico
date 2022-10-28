package com.company.formas.rectangulares;

import com.company.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Esta clase hereda de la clase Rectangular y es una clase con el objeto de tipo Cuadrado
 *
 * @author Jose Maria
 */
public class Cuadrado extends Rectangular {
    private static final int LADOSIGUALES = 4;
    private BigDecimal lados;

    public Cuadrado() {
    }

    public Cuadrado(BigDecimal lados) {
        super(LADOSIGUALES);
        this.lados = lados;
    }

    public BigDecimal area() {
        return lados.multiply(lados);
    }


    public String toString() {
        return super.toString().concat("---Cuadrado---\nLados: " + lados.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm\nÁrea: " + area().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm");
    }

}
