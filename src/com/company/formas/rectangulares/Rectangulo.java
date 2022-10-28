package com.company.formas.rectangulares;

import com.company.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Esta clase hereda de la clase Rectangular y es una clase con el objeto de tipo Cuadrado
 *
 * @author Jose Maria
 */
public class Rectangulo extends Rectangular {
    private static final int LADOSIGUALES = 2;
    private BigDecimal lados1;
    private BigDecimal lados2;

    public Rectangulo() {
    }

    public Rectangulo(BigDecimal lados1, BigDecimal lados2) {
        super(LADOSIGUALES);
        this.lados1 = lados1;
        this.lados2 = lados2;
    }

    @Override
    public BigDecimal area() {
        return lados1.multiply(lados2);
    }


    public String toString() {
        return super.toString().concat("---Rectángulo---\nLados1: " + lados1.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm\nLados2: " + lados2.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm\nÁrea: " + area().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm");
    }

}
