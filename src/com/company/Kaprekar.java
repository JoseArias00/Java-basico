package com.company;

import java.util.*;

public class Kaprekar {
    private static final int NUMKAPREKAR = 6174;
    private String número;

    public Kaprekar() {

    }

    public Kaprekar(String número) {
        this.número = número;
    }

    public void esVálido() {
        //Primer paso: ordenamos los dígitos de mayor a menor y le restamos los dígitos ordenador de menor a mayor
        int descendente = mayorAMenor(número);
        int ascendente = menorAMayor(número);
        int resta = descendente - ascendente;
    }

    public static int mayorAMenor(String número) {
        List<Integer> dígitos = Arrays.asList(Character.getNumericValue(número.charAt(0)), Character.getNumericValue(número.charAt(1)), Character.getNumericValue(número.charAt(2)), Character.getNumericValue(número.charAt(3)));
        dígitos.sort((n1, n2) -> n2.compareTo(n1));
        String conversor = String.valueOf(dígitos.get(0)) + String.valueOf(dígitos.get(1)) + String.valueOf(dígitos.get(2)) + String.valueOf(dígitos.get(3));
        return Integer.valueOf(conversor);
    }

    public static int menorAMayor(String número) {
        List<Integer> dígitos = Arrays.asList(Character.getNumericValue(número.charAt(0)), Character.getNumericValue(número.charAt(1)), Character.getNumericValue(número.charAt(2)), Character.getNumericValue(número.charAt(3)));
        dígitos.sort((n1, n2) -> n1.compareTo(n2));
        String conversor = String.valueOf(dígitos.get(0)) + String.valueOf(dígitos.get(1)) + String.valueOf(dígitos.get(2)) + String.valueOf(dígitos.get(3));
        return Integer.valueOf(conversor);
    }

    /**
     * @return true si el número es una excepción y no es un número
     */
    public boolean esExcepción() {
        HashMap<Character, Integer> dígitos = new HashMap<>();

        //Excepciones: que haya 4 números repetidos
        for (int i = 0; i < número.length(); i++) {
            if (!dígitos.containsKey(número.charAt(i))) {
                dígitos.put(número.charAt(i), 1);
            } else {
                dígitos.replace(número.charAt(i), dígitos.get(número.charAt(i)), (dígitos.get(número.charAt(i)) + 1));
            }
        }

        for (Map.Entry entry : dígitos.entrySet()) {
            if ((Integer) entry.getValue() == 4) {
                return true;
            }
        }

        return false;
    }
}
