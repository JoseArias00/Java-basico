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
    private static final int LADOS_IGUALES = 4;

    /**
     *
     */
    private BigDecimal longitudLado;

    public Cuadrado() {
    }

    /**
     * @param longitudLado
     */
    public Cuadrado(BigDecimal longitudLado) {
        super(LADOS_IGUALES);
        this.longitudLado = longitudLado;
    }

    /**
     * @return El área del cuadrado creado
     * <p>
     * Método encargado de calcular el área del cuadrado a partir del valor de medida de los lados
     */
    @Override
    public BigDecimal área() {
        return longitudLado.multiply(longitudLado);
    }


    /**
     * @return La cadena a imprimir en pantalla con los valores del cuadrado
     * <p>
     * Método encargado de concatenar a la cadena de la clase FormasGeometricas los valores del cuadrado generado
     */
    public String toString() {
        return super.toString() + "---Cuadrado---\nLados: " + longitudLado.setScale(Main.REDONDEO, RoundingMode.HALF_UP) +
                " cm\nÁrea: " + área().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm";
    }

}
