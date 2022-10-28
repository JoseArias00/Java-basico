package com.company.formas;

import java.math.BigDecimal;

/**
 * Esta clase engloba todas las formas geométricas existentes
 *
 * @author Jose Maria
 */
public abstract class FormasGeometricas {
    private int numLados;

    protected FormasGeometricas() {
    }

    protected FormasGeometricas(int numLados) {
        this.numLados = numLados;
    }

    public String toString() {
        return "Es un polígono con " + numLados + " lados.\n";
    }

    abstract public BigDecimal area();
}
