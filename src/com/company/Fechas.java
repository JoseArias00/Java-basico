package com.company;

import java.time.LocalDate;
import java.util.Calendar;

import static com.company.UtileríaFechas.*;

/**
 * @author Jose Maria
 * <p>
 * Clase destinada al manejo de fechas
 */
public class Fechas {
    //Hay dos tipos de variables debido a que trabajaremos con dos librerías
    private static LocalDate time1;
    private static LocalDate time2;
    private static Calendar fecha1 = Calendar.getInstance();
    private static Calendar fecha2 = Calendar.getInstance();

    public static void main() {
        creaFechas();

        operacionesCalendar();
        operacionesTime();

    }

    /**
     * Conjunto de operaciones sobre las fechas, realizadas con la librería Calendar
     */
    private static void operacionesCalendar() {
        System.out.println("---------------Operaciones realizadas con Calendar---------------");

        //Imprimo la diferencia de días entre dos fechas
        System.out.println("La diferencia de días entre la fecha " + FormatoFecha(fecha1) + " y la fecha " + FormatoFecha(fecha2) + " es de " + diferenciaDias(fecha1,fecha2) + " día(s)");

        //Imprimo los días transcurridos de ambas fechas en sus años
        System.out.println("El número de dias transcurridos entre el comienzo del año y la fecha " + FormatoFecha(fecha1) + " es: " + numeroDiasTranscurridos(fecha1));
        System.out.println("El número de dias transcurridos entre el comienzo del año y la fecha " + FormatoFecha(fecha2) + " es: " + numeroDiasTranscurridos(fecha2));

        //Imprimo el número de la semana en la que está cada fecha
        System.out.println((numeroSemana(fecha1) >= 52 && fecha1.get(Calendar.MONTH) == 0 ) ? "En la fecha " + FormatoFecha(fecha1) + " estamos en la semana número " + numeroSemana(fecha1) + " del año pasado." : "En la fecha " + FormatoFecha(fecha1) + " estamos en la semana número " + numeroSemana(fecha1)) ;
        System.out.println((numeroSemana(fecha2) >= 52 && fecha2.get(Calendar.MONTH) == 0 ) ? "En la fecha " + FormatoFecha(fecha2) + " estamos en la semana número " + numeroSemana(fecha2) + " del año pasado." : "En la fecha " + FormatoFecha(fecha2) + " estamos en la semana número " + numeroSemana(fecha2)) ;

    }

    /**
     * Conjunto de operaciones sobre las fechas, realizadas con la librería Java.Time
     */
    private static void operacionesTime() {
        System.out.println("-----------------Operaciones realizadas con Time-----------------");

        //Imprimo el comienzo y final de cada fecha introducida
        System.out.println("El inicio del año de la fecha " + time1 + " es: " + inicioAnio(time1) + "(" + inicioAnio(time1).getDayOfWeek() + ")");
        System.out.println("El fin del año de la fecha " + time1 + " es: " + finAnio(time1) + "(" + finAnio(time1).getDayOfWeek() + ")");

        System.out.println("El inicio del año de la fecha " + time2 + " es: " + inicioAnio(time2) + "(" + inicioAnio(time2).getDayOfWeek() + ")");
        System.out.println("El fin del año de la fecha " + time2 + " es: " + finAnio(time2) + "(" + finAnio(time2).getDayOfWeek() + ")");

        //Imprimo la diferencia de días entre las dos fechas introducidas
        System.out.println("La diferencia de días entre la fecha " + time1 + " y la fecha " + time2 + " es de: " + FormatoPeriodo(diferenciaDiasTime(time1,time2)) + " día(s)");

        //Imprimo los dias transcurridos desde el comienzo del año para ambas fechas
        System.out.println("Han pasado " + diasDelAnio(time1) + " desde el comienzo del año en la fecha " + time1);
        System.out.println("Han pasado " + diasDelAnio(time2) + " desde el comienzo del año en la fecha " + time2);

        //Imprimo la semana del año en la que está cada fecha
        System.out.println("Han pasado " + numeroSemanaEspana(time1) + " semanas desde el comienzo del año en la fecha " + time1);
        System.out.println("Han pasado " + numeroSemanaEspana(time2) + " semanas desde el comienzo del año en la fecha " + time2);

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

    public static Calendar getFecha1() {
        return fecha1;
    }

    public static void setFecha1(Calendar fecha1) {
        Fechas.fecha1 = fecha1;
    }

    public static Calendar getFecha2() {
        return fecha2;
    }

    public static void setFecha2(Calendar fecha2) {
        Fechas.fecha2 = fecha2;
    }
}
