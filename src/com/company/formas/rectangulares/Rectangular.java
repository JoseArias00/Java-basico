package com.company.formas.rectangulares;

import com.company.formas.FormasGeométricas;

import java.math.BigDecimal;

/**
 * Esta clase hereda de la clase FormasGeométricas y engloba todas las formas con 4 lados.
 *
 * @author Jose Maria
 */
public abstract class Rectangular extends FormasGeométricas {
    private static final int NUMLADOS = 4;
    private int ladosIguales;

    public Rectangular() {
    }

    public Rectangular(int ladosIguales) {
        super(NUMLADOS);
        this.ladosIguales = ladosIguales;
    }

    /**
     * @return La cadena a imprimir en pantalla con los valores devueltos de la cadena toString de la clase FormasGeóemtricas
     * <p>
     * Método encargado de devolver la cadena de FormasGeométricas
     */
    public String toString() {
        return super.toString();
    }

    /**
     * @return El valor del área de la figura geométrica creada
     * <p>
     * Método abstracto el cuál ha de sobreescribirse en cada subclase, ya sea un cuadrado o un rectángulo
     */
    abstract public BigDecimal área();
}
