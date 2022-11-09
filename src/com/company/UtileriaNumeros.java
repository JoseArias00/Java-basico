package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class UtileriaNumeros {
    private static final byte REDONDEO = 3;
    private static List<BigDecimal> listaNumeros;

    public static BigDecimal sumar(List<BigDecimal> listaNumeros) {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        BigDecimal resultado = new BigDecimal(0);

        for (BigDecimal numero : listaNumeros) {
            resultado = resultado.add(numero);
        }

        return resultado.setScale(REDONDEO, RoundingMode.HALF_UP);
    }

    public static BigDecimal restar(List<BigDecimal> listaNumeros) {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        BigDecimal resultado = new BigDecimal(String.valueOf(listaNumeros.get(0)));

        //El primer valor quedará en positivo al realizar la resta
        for(int i = 1; i < listaNumeros.size(); i++ ){
            resultado = resultado.subtract(listaNumeros.get(i));
        }

        return resultado.setScale(REDONDEO, RoundingMode.HALF_UP);
    }

    public static BigDecimal dividir(List<BigDecimal> listaNumeros) {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        BigDecimal resultado = new BigDecimal(String.valueOf(listaNumeros.get(0)));

        //El primer valor quedará en positivo al realizar la resta
        for(int i = 1; i < listaNumeros.size(); i++ ){
            resultado = resultado.divide(listaNumeros.get(i));
        }

        return resultado.setScale(REDONDEO, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiplicar(List<BigDecimal> listaNumeros) {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        BigDecimal resultado = new BigDecimal(String.valueOf(listaNumeros.get(0)));

        //El primer valor quedará en positivo al realizar la resta
        for(int i = 1; i < listaNumeros.size(); i++ ){
            resultado = resultado.multiply(listaNumeros.get(i));
        }

        return resultado.setScale(REDONDEO, RoundingMode.HALF_UP);
    }

    public static BigDecimal modulo(BigDecimal numero1, BigDecimal numero2) {
        return numero1.remainder(numero2);
    }

    public static List<BigDecimal> ordenacion(List<BigDecimal> listaNumeros) throws IllegalArgumentException {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        listaNumeros.sort((n1, n2) -> n2.compareTo(n1));

        return listaNumeros;
    }

    /**
     *
     * @param cadena Cadena pasada para comprobar si es BigDecimal en valor numérico
     * @return verdadero si la cadena es un BigDecimal en valor numérico y falso en el resto de los casos
     */
    public static boolean isBigDecimal(String cadena) {
        try {
            BigDecimal.valueOf(Double.parseDouble(cadena));
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

}
