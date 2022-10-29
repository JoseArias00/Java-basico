package com.company.formas;

import java.math.BigDecimal;

/**
 * Esta clase engloba todas las formas geométricas existentes
 *
 * @author Jose Maria
 */
public abstract class FormasGeométricas {
    private int numLados;

    protected FormasGeométricas() {
    }

    protected FormasGeométricas(int numLados) {
        this.numLados = numLados;
    }

    /**
     * @return El comienzo de la cadena para imprimir los datos de cada figura
     * <p>
     * Método encargado de indicar el número de lados de cada figura geométrica
     */
    public String toString() {
        return "Es un polígono con " + numLados + " lados.\n";
    }

    /**
     * @return El valor del área de la figura geométrica creada
     * <p>
     * Método abstracto el cuál ha de sobreescribirse en cada subclase
     */
    abstract public BigDecimal área();
}
