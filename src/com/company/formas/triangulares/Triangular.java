package com.company.formas.triangulares;

import com.company.formas.FormasGeométricas;

import java.math.BigDecimal;

/**
 * Esta clase hereda de la clase FormasGeométricas y engloba todas las formas con 3 lados.
 *
 * @author Jose Maria
 */
public abstract class Triangular extends FormasGeométricas {
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
     * Método encargado de devolver la cadena de FormasGeométricas
     */
    public String toString(){
        return super.toString();
    }

    /**
     * @return El valor del área de la figura geométrica creada
     * <p>
     * Método abstracto el cuál ha de sobreescribirse en cada subclase, ya sea un TriánguloEquilátero, o un TriánguloEscaleno o un TriánguloIsósceles
     */
    @Override
    abstract public BigDecimal área();



}
