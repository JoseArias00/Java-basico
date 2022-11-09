package com.company;

/**
 * @author Jose Maria
 * <p>
 * Clase para realización de operaciones con textos
 */
public class OperacionTexto {

    public static void main() {
        operaciones();
    }

    /**
     * Método donde se indicará las operaciones a realizar con el texto
     */
    private static void operaciones() {
        Texto texto = new Texto();
        System.out.println("El número total de caracteres de la cadena es: " + texto.cuentaCaracteres());
        System.out.println("La cadena en mayúsculas queda de la forma: " + texto.aMayus());
        System.out.println("La cadena en minúsculas queda de la forma: " + texto.aMinus());
        System.out.println("Palabras repetidas y su número de repeticiones: " + texto.repeticiones());
        System.out.println("Reemplazamos la palabra 'Proconsi' por 'Isnocorp': " + texto.reemplazo());
        System.out.println("Tiempo que se tardó en concatenar el texto 1000 veces: " + texto.concatenar() + " ms");
    }


}
