package com.company;

import java.util.*;

import static java.lang.Math.*;

public class Kaprekar {
    private static final int NUMKAPREKAR = 6174;

    /**
     * @return Si el número es de Kaprekar
     * <p>
     * Método encargado de devolver si el número pasado es de Kaprekar con un true:si o un false:no
     */
    public static boolean esKaprekar(int numero) {
        int cuadrado = (int) pow(numero, 2);
        String aux = String.valueOf(cuadrado);
        StringBuilder auxPrimeraMitad = new StringBuilder("");
        StringBuilder auxSegundaMitad = new StringBuilder("");
        for (int i = 0; i < (aux.length() / 2); i++) {
            auxPrimeraMitad.append(String.valueOf(aux.charAt(i)));
        }

        for (int i = (aux.length() / 2); i < aux.length(); i++) {
            auxSegundaMitad.append(String.valueOf(aux.charAt(i)));
        }

        int primeraMitad = Integer.valueOf(auxPrimeraMitad.toString());
        int segundaMitad = Integer.valueOf(auxSegundaMitad.toString());

        int sumaMitades = primeraMitad + segundaMitad;

        return sumaMitades == numero;
    }


    public static List<Boolean> sonKaprekar(int ... numeros) {
        List<Boolean> resultados = new ArrayList<>();
        for(int numero: numeros){
            int cuadrado = (int) pow(numero, 2);
            String aux = String.valueOf(cuadrado);
            StringBuilder auxPrimeraMitad = new StringBuilder("");
            StringBuilder auxSegundaMitad = new StringBuilder("");
            for (int i = 0; i < (aux.length() / 2); i++) {
                auxPrimeraMitad.append(aux.charAt(i));
            }

            for (int i = (aux.length() / 2); i < aux.length(); i++) {
                auxSegundaMitad.append(aux.charAt(i));
            }

            int primeraMitad = Integer.valueOf(auxPrimeraMitad.toString());
            int segundaMitad = Integer.valueOf(auxSegundaMitad.toString());

            int sumaMitades = primeraMitad + segundaMitad;

            resultados.add(sumaMitades == numero);
        }
        return resultados;
    }

    /**
     * @return verdadero o falso según si el número introducido es una constante de Kaprekar
     * <p>
     * Método encargado de devolver 'true:si' o 'false:no' por pantalla si el número es una constante de Kaprekar
     */
    public boolean esVálido(int numero) {
        //Primer paso: ordenamos los dígitos de mayor a menor y le restamos los dígitos ordenador de menor a mayor
        int contador = 0;
        int resta;
        int descendente = mayorAMenor(numero);
        int ascendente = menorAMayor(numero);

        do {
            resta = descendente - ascendente;
            descendente = mayorAMenor(resta);
            ascendente = menorAMayor(resta);
            contador++;
        } while (resta != NUMKAPREKAR && contador < 7);

        return resta == NUMKAPREKAR;
    }

    /**
     * @param numero Un número que queremos ordenar de mayor a menor
     * @return El número ordenado de mayor a menos
     * <p>
     * Método encargado de ordenar un número de mayor a menor y devolver ese número ya ordenado
     */
    public static int mayorAMenor(int numero) {
        String aux = String.valueOf(numero);
        List<Integer> digitos = Arrays.asList(Character.getNumericValue(aux.charAt(0)), Character.getNumericValue(aux.charAt(1)), Character.getNumericValue(aux.charAt(2)), Character.getNumericValue(aux.charAt(3)));
        digitos.sort((n1, n2) -> n2.compareTo(n1));
        String conversor = String.valueOf(digitos.get(0)) + String.valueOf(digitos.get(1)) + String.valueOf(digitos.get(2)) + String.valueOf(digitos.get(3));
        return Integer.valueOf(conversor);
    }

    /**
     * @param numero Un número que queremos ordenar de menor a mayor
     * @return El número ordenado de menor a mayor
     * <p>
     * Método encargado de ordenar un número de menor a mayor y devolver ese número ya ordenado
     */
    public static int menorAMayor(int numero) {
        String aux = String.valueOf(numero);
        List<Integer> digitos = Arrays.asList(Character.getNumericValue(aux.charAt(0)), Character.getNumericValue(aux.charAt(1)), Character.getNumericValue(aux.charAt(2)), Character.getNumericValue(aux.charAt(3)));
        digitos.sort((n1, n2) -> n1.compareTo(n2));
        String conversor = String.valueOf(digitos.get(0)) + String.valueOf(digitos.get(1)) + String.valueOf(digitos.get(2)) + String.valueOf(digitos.get(3));
        return Integer.valueOf(conversor);
    }

    /**
     * @return true si el número es una excepción
     * <p>
     * Método encargado de comprobar si el número pasado es una excepción y no será una constante de Kaprekar aún teniendo 4 cifras
     */
    public boolean esExcepción(int numero) {
        HashMap<Character, Integer> digito = new HashMap<>();
        String aux = String.valueOf(numero);

        //Excepciones: que haya 4 números repetidos
        for (int i = 0; i < aux.length(); i++) {
            if (!digito.containsKey(aux.charAt(i))) {
                digito.put(aux.charAt(i), 1);
            } else {
                digito.replace(aux.charAt(i), digito.get(aux.charAt(i)), (digito.get(aux.charAt(i)) + 1));
            }
        }

        for (Map.Entry entry : digito.entrySet()) {
            if ((Integer) entry.getValue() == 4) {
                return true;
            }
        }

        return false;
    }
}
