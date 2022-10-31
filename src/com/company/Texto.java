package com.company;

import java.util.HashMap;
import java.util.Map;

public class Texto {
    private final String TEXTEJEMPLO = "Proconsi es una empresa de Tecnologías de la Información y la Comunicación especializada en el " +
            "desarrollo e integración de soluciones informáticas para todo tipo de empresas. Más de tres décadas de experiencia " +
            "avalan a una compañía tan flexible como responsable. Cuenta con un equipo multidisciplinar de más de 120 " +
            "profesionales cualificados, expertos y comprometidos con un único objetivo: hallar la solución tecnológica exacta " +
            "para cada cliente. Proconsi es especialista en la creación y el desarrollo de software de gestión, consultoría " +
            "tecnológica, dirección y gestión de proyectos I+D+i basados en TIC, soporte técnico, aplicaciones móviles y fomento " +
            "de tendencias en nuevas tecnologías, como el cloud computing.";
    private String cadena = "";

    public Texto() {
        cadena = TEXTEJEMPLO;
    }

    public Texto(String cadena) {
        this.cadena = cadena;
    }

    /**
     * Método encargado de contar el número total de caracteres de la cadena
     */
    public void cuentaCaracteres() {
        int caracteres;

        caracteres = cadena.replace(" ", "").length(); //Con esto omitimos que cuenta los espacios
        System.out.println("Número de caracteres totales: " + caracteres);
    }

    /**
     * Método que escribe toda la cadena en mayúsculas
     */
    public void aMayus() {
        String mayúsculas = cadena.toUpperCase();
        System.out.println("Texto en mayúsculas: " + mayúsculas);
    }

    /**
     * Método que escribe toda la cadena en minúsculas
     */
    public void aMinus() {
        String minúsculas = cadena.toLowerCase();
        System.out.println("Texto en minúsculas: " + minúsculas);
    }

    /**
     * Método que muestra las palabras que aparecen más de una vez en la cadena
     */
    public void repeticiones() {
        String[] palabras = cadena.split(" ");
        HashMap<String, Integer> mapaPalabras = new HashMap<>();

        //Primero almacenamos todas las palabras de la cadena en un mapa, donde si se encuentra una palabra por primera vez se añade y si no al valor con el que se relaciona se le sumará 1
        for (int i = 0; i < palabras.length; i++) {
            if (!mapaPalabras.containsKey(palabras[i])) {
                mapaPalabras.put(palabras[i], 1);
            } else {
                mapaPalabras.put(palabras[i], mapaPalabras.get(palabras[i]) + 1);
            }
        }

        //Imprimimos por pantalla todas las palabras con valor > 1
        for (Map.Entry entry : mapaPalabras.entrySet()) {
            if ((Integer) entry.getValue() > 1) {
                System.out.print(entry.getKey() + "[" + entry.getValue() + "]");
            }
        }

        System.out.println();
    }

    /**
     * Método que reemplaza 'Proconsi' por 'Isnocorp'
     */
    public void reemplazo() {
        String textoRemplazo = cadena.replace("Proconsi", "Isnocorp");
        System.out.println("Sustituimos 'Proconsi' por 'Isnocorp': " + textoRemplazo);
    }

    /**
     * Método que concatena el texto 1000 veces y calcula el tiempo que le ha llevado realizar dicho proceso
     */
    public void concatenar() {
        String concatenacion = "";

        //Establecemos un momento de comienzo de operación que luego restaremos al momento final después de realizar la operación para sacar el tiempo total del proceso
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            concatenacion.concat(cadena);
        }

        long fin = System.currentTimeMillis();

        long tiempoTotal = fin - inicio;

        System.out.println("Tiempo total en concatener 1000 el texto: " + tiempoTotal + " ms");
    }
}
