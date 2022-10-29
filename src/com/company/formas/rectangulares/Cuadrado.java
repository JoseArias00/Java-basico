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

    /**
     * @return El área del cuadrado creado
     * <p>
     * Método encargado de calcular el área del cuadrado a partir del valor de medida de los lados
     */
    public BigDecimal área() {
        return lados.multiply(lados);
    }


    /**
     * @return La cadena a imprimir en pantalla con los valores del cuadrado
     * <p>
     * Método encargado de concatenar a la cadena de la clase FormasGeométricas los valores del cuadrado generado
     */
    public String toString() {
        return super.toString().concat("---Cuadrado---\nLados: " + lados.setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm\nÁrea: " + área().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm");
    }

}
