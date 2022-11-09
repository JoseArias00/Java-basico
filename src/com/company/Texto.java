package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jose Maria
 * <p>
 * Objeto texto con sus respectivas operaciones
 */
public class Texto {

    /**
     * Texto de ejemplo
     */
    private final String TEXTEJEMPLO = "Proconsi es una empresa de Tecnologías de la Información y la Comunicación especializada en el " +
            "desarrollo e integración de soluciones informáticas para todo tipo de empresas. Más de tres décadas de experiencia " +
            "avalan a una compañía tan flexible como responsable. Cuenta con un equipo multidisciplinar de más de 120 " +
            "profesionales cualificados, expertos y comprometidos con un único objetivo: hallar la solución tecnológica exacta " +
            "para cada cliente. Proconsi es especialista en la creación y el desarrollo de software de gestión, consultoría " +
            "tecnológica, dirección y gestión de proyectos I+D+i basados en TIC, soporte técnico, aplicaciones móviles y fomento " +
            "de tendencias en nuevas tecnologías, como el cloud computing.";
    private String cadena = "";

    /**
     * Constructor por defecto de la clase.
     * En caso de que no se pase ninguna cadena por parámetro se usará un texto de ejemplo
     */
    public Texto() {
        cadena = TEXTEJEMPLO;
    }

    /**
     * @param cadena La cadena que usaremos como texto con el que trabajar
     *               <p>
     *               Constructor para una cadena pasada por parámetro
     */
    public Texto(String cadena) {
        this.cadena = cadena;
    }

    /**
     * @return El número de caracteres que tiene la cadena
     */
    public BigInteger cuentaCaracteres() {
        BigInteger caracteres = new BigInteger("0");

        caracteres.add(BigInteger.valueOf(cadena.replace(" ", "").length())); //Con esto omitimos que cuenta los espacios

        return caracteres;
    }

    /**
     * @return La cadena con todos los caracteres en mayúsculas
     */
    public String aMayus() {
        return cadena.toUpperCase(Locale.ROOT);
    }

    /**
     * @return La cadena con todos los caracteres en minúsculas
     */
    public String aMinus() {
        return cadena.toLowerCase();
    }

    /**
     * @return El número de palabras repetidas con el número de repeteciones en el texto
     */
    public String repeticiones() {
        String[] palabras = cadena.split(" ");
        StringBuilder formato = new StringBuilder();
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
                formato.append(entry.getKey() + "[" + entry.getValue() + "]");
            }
        }

        return formato.toString();
    }

    /**
     * @return La cadena con la palabra 'Proconsi' sustituida por su inverso
     */
    public String reemplazo() {
        return cadena.replace("Proconsi", "Isnocorp");
    }

    /**
     * @return El tiempo en milisegundos que se tardó en concatener el texto 1000 veces
     */
    public BigDecimal concatenar() {
        StringBuilder concatenacion = new StringBuilder();

        //Establecemos un momento de comienzo de operación que luego restaremos al momento final después de realizar la operación para sacar el tiempo total del proceso
        BigDecimal inicio = new BigDecimal(System.currentTimeMillis());

        for (int i = 0; i < 1000; i++) {
            concatenacion.append(cadena);
        }

        BigDecimal fin = new BigDecimal(System.currentTimeMillis());

        return fin.subtract(inicio);

    }
}
