package com.company;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author Jose Maria
 * <p>
 * Clase destinada al manejo de fechas
 */
public class Fechas {
    private static LocalDate time1;
    private static LocalDate time2;
    private static Calendar fecha1 = Calendar.getInstance();
    private static Calendar fecha2 = Calendar.getInstance();

    public static void main() {
        OperacionesFechas.creaFechas();

        operacionesCalendar();
        operacionesTime();

    }

    /**
     * Conjunto de operaciones sobre las fechas realizadas con la librería Calendar
     */
    private static void operacionesCalendar() {
        OperacionesFechas.diferenciaDias(fecha1, fecha2);
        OperacionesFechas.numeroDias(fecha1, fecha2);
        OperacionesFechas.numeroSemana(fecha1, fecha2);
    }

    /**
     * Conjunto de operaciones sobre las fechas realizadas con la librería Java.Time
     */
    private static void operacionesTime() {
        OperacionesFechas.inicioAnio(time1);
        OperacionesFechas.inicioAnio(time2);
        OperacionesFechas.finAnio(time1);
        OperacionesFechas.finAnio(time2);
        OperacionesFechas.diferenciaDiasTime(time1, time2);
        OperacionesFechas.diasDelAnio(time1);
        OperacionesFechas.diasDelAnio(time2);
        OperacionesFechas.numeroSemana(time1);
        OperacionesFechas.numeroSemana(time2);

    }

    public static LocalDate getTime1() {
        return time1;
    }

    public static void setTime1(LocalDate time1) {
        Fechas.time1 = time1;
    }

    public static LocalDate getTime2() {
        return time2;
    }

    public static void setTime2(LocalDate time2) {
        Fechas.time2 = time2;
    }
}
