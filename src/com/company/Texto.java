package com.company;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Texto {
    private static final String TEXTO = "Proconsi es una empresa de Tecnologías de la Información y la Comunicación especializada en el " +
            "desarrollo e integración de soluciones informáticas para todo tipo de empresas. Más de tres décadas de experiencia " +
            "avalan a una compañía tan flexible como responsable. Cuenta con un equipo multidisciplinar de más de 120 " +
            "profesionales cualificados, expertos y comprometidos con un único objetivo: hallar la solución tecnológica exacta " +
            "para cada cliente. Proconsi es especialista en la creación y el desarrollo de software de gestión, consultoría " +
            "tecnológica, dirección y gestión de proyectos I+D+i basados en TIC, soporte técnico, aplicaciones móviles y fomento " +
            "de tendencias en nuevas tecnologías, como el cloud computing.";

    /**
     * Metodo principal que llama al resto de metodos
     */
    public static void main() {
        cuentaCaracteres();
        aMayus();
        aMinus();
        repeticiones();
        reemplazo();
        concatenar();

    }

    /**
     * Metodo encargado de contar el numero total de caracteres de la cadena
     */
    private static void cuentaCaracteres() {
        int caracteres;

        caracteres = TEXTO.replace(" ", "").length(); //Con esto omitimos que cuenta los espacios
        System.out.println("Numero de caracteres totales: " + caracteres);
    }

    /**
     * Metodo que escribe toda la cadena en mayusculas
     */
    private static void aMayus() {
        String mayusculas = TEXTO.toUpperCase(Locale.ROOT);
        System.out.println(mayusculas);
    }

    /**
     * Metodo que escribe toda la cadena en minusculas
     */
    private static void aMinus() {
        String minusculas = TEXTO.toLowerCase(Locale.ROOT);
        System.out.println(minusculas);
    }

    /**
     * Metodo que muestra las palabras que aparecen mas de una vez en la cadena
     */
    private static void repeticiones() {
        String[] palabras = TEXTO.split(" ");
        HashMap<String, Integer> mapaPalabras = new HashMap<>();

        for (int i = 0; i < palabras.length; i++) {
            if (!mapaPalabras.containsKey(palabras[i])) {
                mapaPalabras.put(palabras[i], 1);
            } else {
                mapaPalabras.put(palabras[i], mapaPalabras.get(palabras[i]) + 1);
            }
        }

        for (Map.Entry entry : mapaPalabras.entrySet()) {
            if ((Integer) entry.getValue() > 1) {
                System.out.print(entry.getKey() + "[" + entry.getValue() + "]");
            }
        }

        System.out.println();
    }

    /**
     * Metodo que reemplaza 'Proconsi' por 'Isnocorp'
     */
    private static void reemplazo() {
        String textoRemplazo = TEXTO.replace("Proconsi", "Isnocorp");
        System.out.println(textoRemplazo);
    }

    /**
     * Metodo que concatena el texto 1000 veces y calcula el tiempo que le ha llevado realizar dicho proceso
     */
    private static void concatenar() {
        String concatenacion = "";

        //Establecemos un momento de comienzo de operacion que luego restaremos al momento final despues de realizar la operacion para sacar el tiempo total del proceso
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 1500000; i++) {
            concatenacion.concat(TEXTO);
        }

        long fin = System.currentTimeMillis();

        long tiempoTotal = fin - inicio;

        System.out.println(tiempoTotal + "ms");
    }
}
