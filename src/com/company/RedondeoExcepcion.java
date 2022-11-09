package com.company;

/**
 * @author Jose Maria
 * <p>
 * Excepción destinada a cuando se introduzca un valor negativo para realizar los redondeos
 */
public class RedondeoExcepcion extends Exception {

    public RedondeoExcepcion(String mensaje) {
        super(mensaje);
    }
}
