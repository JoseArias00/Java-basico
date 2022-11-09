package com.company.formas.triangulares;

import com.company.formas.FormasGeometricas;

import java.math.BigDecimal;

/**
 * Esta clase hereda de la clase FormasGeometricas y engloba todas las formas con 3 lados.
 *
 * @author Jose Maria
 */
public abstract class Triangular extends FormasGeometricas {
    private static final int NUMLADOS = 3;
    private int ladosIguales;

    public Triangular(){}

    public Triangular(int ladosIguales){
        super(NUMLADOS);
        this.ladosIguales = ladosIguales;
    }

    /**
     * @return La cadena a imprimir en pantalla con los valores devueltos de la cadena toString de la clase FormasGeómetricas
     * <p>
     * Método encargado de devolver la cadena de FormasGeometricas
     */
    public String toString(){
        return super.toString();
    }

    /**
     * @return El valor del área de la figura geométrica creada
     * <p>
     * Método abstracto el cuál ha de sobreescribirse en cada subclase, ya sea un TrianguloEquilatero, o un TrianguloEscaleno o un TrianguloIsosceles
     */
    @Override
    abstract public BigDecimal área();



}
