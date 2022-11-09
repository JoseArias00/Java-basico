package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author Jose Maria
 * <p>
 * Utilería con métodos para operaciones numéricas
 */
public class UtileriaNumeros {

    /**
     * Número usado para indicar la precisión con la que trabajaremos
     */
    private static byte PRECISION;

    /**
     * @param listaNumeros Lista con todos los números con los que vamos a operar
     * @return El resultado de sumar todos los números de la lista pasada por parámetro
     * @throws NumberFormatException Ocurre cuando en la lista existen elementos que no son BigDecimal
     */
    public static BigDecimal sumar(List<BigDecimal> listaNumeros) throws NumberFormatException {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        BigDecimal resultado = new BigDecimal(0);

        for (BigDecimal numero : listaNumeros) {
            resultado = resultado.add(numero);
        }

        return resultado.setScale(PRECISION, RoundingMode.HALF_UP);
    }

    /**
     * @param listaNumeros Lista con todos los números con los que vamos a operar
     * @return El resultado de restar todos los números de la lista pasada por parámetro
     * @throws NumberFormatException Ocurre cuando en la lista existen elementos que no son BigDecimal
     */
    public static BigDecimal restar(List<BigDecimal> listaNumeros) throws NumberFormatException {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        BigDecimal resultado = new BigDecimal(String.valueOf(listaNumeros.get(0)));

        //El primer valor quedará en positivo al realizar la resta
        for (int i = 1; i < listaNumeros.size(); i++) {
            resultado = resultado.subtract(listaNumeros.get(i));
        }

        return resultado.setScale(PRECISION, RoundingMode.HALF_UP);
    }

    /**
     * @param listaNumeros Lista con todos los números con los que vamos a operar
     * @return El resultado de dividir todos los números de la lista pasada por parámetro, usando el primero como dividendo y el resto como divisores
     * @throws NumberFormatException Ocurre cuando en la lista existen elementos que no son BigDecimal
     * @throws ArithmeticException   Ocurre cuando se pasa un 0 en la lista de números y este sería el divisor en una división
     */
    public static BigDecimal dividir(List<BigDecimal> listaNumeros) throws NumberFormatException, ArithmeticException {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        for (int i = 1; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i).compareTo(BigDecimal.valueOf(Double.parseDouble("0.0"))) == 0) {
                throw new ArithmeticException("No se puede dividir entre 0 porque daría un valor infinito");
            }
        }

        BigDecimal resultado = new BigDecimal(String.valueOf(listaNumeros.get(0)));

        //El primer valor quedará en positivo al realizar la resta
        for (int i = 1; i < listaNumeros.size(); i++) {
            resultado = resultado.divide(listaNumeros.get(i), PRECISION, RoundingMode.HALF_UP);
        }

        return resultado;
    }

    /**
     * @param listaNumeros Lista con todos los números con los que vamos a operar
     * @return El resultado de multiplicar todos los números de la lista pasada por parámetro
     * @throws NumberFormatException Ocurre cuando en la lista existen elementos que no son BigDecimal
     */
    public static BigDecimal multiplicar(List<BigDecimal> listaNumeros) throws NumberFormatException {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        BigDecimal resultado = new BigDecimal(String.valueOf(listaNumeros.get(0)));

        //El primer valor quedará en positivo al realizar la resta
        for (int i = 1; i < listaNumeros.size(); i++) {
            resultado = resultado.multiply(listaNumeros.get(i));
        }

        return resultado.setScale(PRECISION, RoundingMode.HALF_UP);
    }

    /**
     * @param numero1 Número que usaremos como dividendo
     * @param numero2 Número que usaremos como divisor
     * @return El módulo de dividir el primer número entre el segundo
     * @throws NumberFormatException Ocurre cuando en la lista existen elementos que no son BigDecimal
     */
    public static BigDecimal modulo(BigDecimal numero1, BigDecimal numero2) throws NumberFormatException {
        if (!isBigDecimal(numero1.toString())) {
            throw new NumberFormatException("El primer valor pasado por parámetro es erróneo");
        }

        if (!isBigDecimal(numero2.toString())) {
            throw new NumberFormatException("El segundo valor pasado por parámetro es erróneo");
        }

        return numero1.remainder(numero2).setScale(PRECISION, RoundingMode.HALF_UP);
    }

    /**
     * @param listaNumeros Lista con todos los números con los que vamos a operar
     * @return La lista pasada por parámetro con todos sus números ordenados de mayor a menor
     * @throws NumberFormatException Ocurre cuando en la lista existen elementos que no son BigDecimal
     */
    public static List<BigDecimal> ordenacion(List<BigDecimal> listaNumeros) throws NumberFormatException {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        listaNumeros.sort((n1, n2) -> n2.compareTo(n1));

        for (BigDecimal numeros : listaNumeros) {
            numeros.setScale(PRECISION, RoundingMode.HALF_UP);
        }

        return listaNumeros;
    }

    /**
     * @param listaNumeros Lista con todos los números con los que vamos a operar
     * @return La lista con los números mostrandolos indicando si son mayor o igual que su consecutivo en la lista
     * @throws NumberFormatException Ocurre cuando en la lista existen elementos que no son BigDecimal
     */
    public static String formatoOrdenacion(List<BigDecimal> listaNumeros) throws NumberFormatException {
        for (BigDecimal numeroLista : listaNumeros) {
            if (!isBigDecimal(numeroLista.toString())) {
                throw new NumberFormatException("Uno de los valores de la lista no es un BigDecimal");
            }
        }

        StringBuilder cadena = new StringBuilder();

        //Se resta uno para no sobrepasar el tamaño de la lista al comparar siempre con el número siguiente de la lista
        for (int contador = 0; contador < listaNumeros.size() - 1; contador++) {
            String comparacion = (listaNumeros.get(contador).compareTo(listaNumeros.get(contador + 1)) == 0) ? listaNumeros.get(contador).setScale(PRECISION, RoundingMode.HALF_UP) + "=" : listaNumeros.get(contador).setScale(PRECISION, RoundingMode.HALF_UP) + ">";
            cadena.append(comparacion);
        }

        //Se resta uno para no sobrepasar el tamaño de la lista
        cadena.append(listaNumeros.get(listaNumeros.size() - 1).setScale(PRECISION, RoundingMode.HALF_UP));

        return cadena.toString();
    }

    /**
     * @param cadena Cadena pasada para comprobar si es BigDecimal en valor numérico
     * @return verdadero si la cadena es un BigDecimal en valor numérico y falso en el resto de los casos
     * <p>
     * Método que comprueba que el valor pasado como String es un BigDecimal en valor numérico
     */
    public static boolean isBigDecimal(String cadena) {
        try {
            BigDecimal.valueOf(Double.parseDouble(cadena));
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    /**
     * @param listaNumeros Lista con todos los números con los que vamos a operar
     * @return verdadero si en la lista se divide entre 0 y falso si no
     */
    public static boolean divideEntreCero(List<BigDecimal> listaNumeros) {
        for (int i = 1; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i).compareTo(BigDecimal.valueOf(Double.parseDouble("0.0"))) == 0) {
                return true;
            }
        }
        return false;

    }

    public static byte getPRECISION() {
        return PRECISION;
    }

    public static void setPRECISION(byte PRECISION) {
        UtileriaNumeros.PRECISION = PRECISION;
    }
}
