package com.company.formas.triangulares;

import com.company.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Esta clase hereda de la clase Triangular y es una clase con el objeto de tipo TrianguloIsosceles
 *
 * @author Jose Maria
 */
public class TrianguloIsosceles extends Triangular {
    private static final int LADOSIGUALES = 2;
    private BigDecimal ladosIguales;
    private BigDecimal ladoDesigual;

    public TrianguloIsosceles() {
    }

    public TrianguloIsosceles(BigDecimal ladosIguales, BigDecimal ladoDesigual) {
        super(LADOSIGUALES);
        this.ladosIguales = ladosIguales;
        this.ladoDesigual = ladoDesigual;
    }

    /**
     * @return El área del triángulo creado
     * <p>
     * Método encargado de calcular el área del triángulo a partir del valor de medida de sus lados iguales y el lado desigual
     */
    @Override
    public BigDecimal área() {
        BigDecimal altura = (ladosIguales.pow(2).subtract((ladoDesigual.pow(2)).divide(BigDecimal.valueOf(4)))).pow(1 / 2);
        return (ladoDesigual.multiply(altura)).divide(BigDecimal.valueOf(2));
    }

    /**
     * @return La cadena a imprimir en pantalla con los valores del triángulo isósceles
     * <p>
     * Método encargado de concatenar a la cadena de la clase FormasGeometricas los valores del triángulo generado
     */
    public String toString() {
        return super.toString().concat("---Triángulo Isósceles---\nLadosIguales: " + ladosIguales.setScale(Main.REDONDEO, RoundingMode.HALF_UP) +
                " cm\nLadoDesigual: " + ladoDesigual.setScale(Main.REDONDEO, RoundingMode.HALF_UP) +
                " cm\nÁrea: " + área().setScale(Main.REDONDEO, RoundingMode.HALF_UP) + " cm");
    }
}
