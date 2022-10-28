package com.company.formas.rectangulares;

import com.company.formas.FormasGeometricas;

import java.math.BigDecimal;

/**
 * Esta clase hereda de la clase FormasGeometricas y engloba todas las formas con 4 lados.
 *
 * @author Jose Maria
 */
public abstract class Rectangular extends FormasGeometricas {
    private static final int NUMLADOS = 4;
    private int ladosIguales;

    public Rectangular() {
    }

    public Rectangular(int ladosIguales) {
        super(NUMLADOS);
        this.ladosIguales = ladosIguales;
    }

    public String toString() {
        return super.toString();
    }

    abstract public BigDecimal area();
}
