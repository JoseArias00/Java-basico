package com.company;

import java.util.Calendar;
import java.time.*;
import java.util.Scanner;

import static java.util.Calendar.*;

/**
 * @author Jose Maria
 * <p>
 * Utilería de métodos para el manejo de fechas
 */
public class UtileríaFechas {

    /**
     * @param fecha1 Fecha 1 introducida por el usuario con la que operar
     * @param fecha2 Fecha 2 introducida por el usuario con la que operar
     * @return El número de diferencia de dias entre las dos fechas pasadas por parámetros
     * @throws IllegalArgumentException Ocurre cuando una o ambas fechas son erróneas
     */
    public static int diferenciaDias(Calendar fecha1, Calendar fecha2) throws IllegalArgumentException {
        if (fecha1 == null || fecha1.get(MONTH) > 12 || fecha1.get(DAY_OF_MONTH) > 31) {
            throw new IllegalArgumentException("Parámetro 1 incorrecto");
        }

        if (fecha2 == null || fecha2.get(MONTH) > 12 || fecha2.get(DAY_OF_MONTH) > 31) {
            throw new IllegalArgumentException("Parámetro 2 incorrecto");
        }

        //Vamos a calcular la diferencia de tiempo entre ambas fechas en milisegundos que luego pasaremos a dias
        int milisecondsByDay = 86400000;
        int dias = (int) ((fecha1.getTime().getTime() - fecha2.getTime().getTime()) / milisecondsByDay);

        //Math.abs es utilizado para indicar la diferencia de dias como valor absoluto
        return Math.abs(dias);
    }

    /**
     * @param fecha Fecha introducida por el usuario con la que operar
     * @return El número de dias transcurridos en la fecha respecto al comienzo del año
     * @throws IllegalArgumentException Ocurre cuando la fecha pasada por parámetro es errónea
     */
    public static short numeroDiasTranscurridos(final Calendar fecha) throws IllegalArgumentException {
        if (fecha == null || fecha.get(MONTH) > 12 || fecha.get(DAY_OF_MONTH) > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }
        //Creamos dos fechas auxiliares en 1 de enero de los años de las fechas indicadas
        Calendar fechaAux = getInstance();

        fechaAux.set(fecha.get(YEAR), Calendar.JANUARY, 1);

        return (short) diferenciaDias(fechaAux, fecha);
    }

    /**
     * @param fecha Fecha introducida por el usuario con la que operar
     * @return El número de la semana del año al que corresponde esa fecha
     * @throws IllegalArgumentException Ocurre cuando la fecha pasada por parámetro es errónea
     */
    public static byte numeroSemana(final Calendar fecha) throws IllegalArgumentException {
        if (fecha == null || fecha.get(MONTH) > 12 || fecha.get(DAY_OF_MONTH) > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }

        return (byte) fecha.getWeekYear();
    }

    /**
     * @param fecha Fecha sobre la que operaremos para conocer su primer día del año
     * @return Fecha del primer día del año de la fecha pasada por parámetros
     * @throws IllegalArgumentException Ocurre cuando la fecha pasada por parámetro es errónea
     */
    public static LocalDate inicioAnio(final LocalDate fecha) throws IllegalArgumentException {
        if (fecha == null || fecha.getMonthValue() > 12 || fecha.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }

        return LocalDate.of(fecha.getYear(), Month.JANUARY, 1);
    }

    /**
     * @param fecha Fecha sobre la que operaremos para conocer su último día del año
     * @return Fecha del último día del año de la fecha pasada por parámetros
     * @throws IllegalArgumentException Ocurre cuando la fecha pasada por parámetro es errónea
     */
    public static LocalDate finAnio(final LocalDate fecha) throws IllegalArgumentException {
        if (fecha == null || fecha.getMonthValue() > 12 || fecha.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }

        return LocalDate.of(fecha.getYear(), Month.DECEMBER, 31);
    }

    /**
     * @param fecha1 Fecha 1 a comparar
     * @param fecha2 Fecha 2 a comparar
     * @return El periodo de diferencia entre ambas fechas
     * @throws IllegalArgumentException Ocurre cuando una o ambas fechas pasadas por parámetros es errónea
     */
    public static Period diferenciaDiasTime(final LocalDate fecha1, final LocalDate fecha2) throws IllegalArgumentException {
        if (fecha1 == null || fecha1.getMonthValue() > 12 || fecha1.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro 1 incorrecto");
        }
        if (fecha2 == null || fecha2.getMonthValue() > 12 || fecha2.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro 2 incorrecto");
        }

        Period diferencia = Period.between(fecha1, fecha2);

        return diferencia;
    }

    /**
     * @param fechaLocal Fecha sobre la que opera el método
     * @return Número de dias que tiene el año de la fecha pasada como parámetro
     * @throws IllegalArgumentException Ocurre cuando la fecha pasada por parámetro es errónea
     */
    public static int diasDelAnio(final LocalDate fechaLocal) throws IllegalArgumentException {
        if (fechaLocal == null || fechaLocal.getMonthValue() > 12 || fechaLocal.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }
        System.out.println("Este año tiene: " + fechaLocal.lengthOfYear() + " días.");
        return fechaLocal.lengthOfYear();
    }

    /**
     * @param fecha La fecha de la que queremos calcular el número de la semana del año en la que está
     * @return El número de la semana del año para la fecha pasada como parámetro
     * @throws IllegalArgumentException Ocurre cuando se introduce un parámetro erróneo.
     *                                  <p>
     *                                  Método realizado comenzando a contar las semanas por el primer lunes del año
     */
    public static int numeroSemanaEspana(final LocalDate fecha) throws IllegalArgumentException {
        if (fecha == null || fecha.getMonthValue() > 12 || fecha.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }

        int numeroSemanas;
        int diferenciaDiasInicioAnioAhora;
        LocalDate inicioAnio = LocalDate.of(fecha.getYear(), Month.JANUARY, 1);
        Period dia = Period.ofDays(1);

        while ((inicioAnio.getDayOfWeek().getValue() + 1) != MONDAY) {
            inicioAnio = inicioAnio.plus(dia);
        }

        diferenciaDiasInicioAnioAhora = fecha.getDayOfYear() - inicioAnio.getDayOfYear();

        numeroSemanas = (diferenciaDiasInicioAnioAhora < 0) ? 0 : (diferenciaDiasInicioAnioAhora / 7 + 1);

        System.out.println("Es la semana número: " + numeroSemanas);
        return numeroSemanas;
    }

    /**
     * @param fecha La fecha de la que queremos calcular el número de la semana del año en la que está
     * @return El número de la semana del año para la fecha pasada como parámetro
     * @throws IllegalArgumentException Ocurre cuando se introduce un parámetro erróneo.
     *                                  <p>
     *                                  Método realizado comenzando a contar las semanas por el día 1 de enero (independientemente del dia de la semana que sea)
     */
    public static int numeroSemanaEuropa(final LocalDate fecha) throws IllegalArgumentException {
        if (fecha == null || fecha.getMonthValue() > 12 || fecha.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }

        LocalDate inicioAnio = LocalDate.of(fecha.getYear(), Month.JANUARY, 1);
        Period semana = Period.ofWeeks(1);

        int numeroSemanas = 0;

        while (inicioAnio.getDayOfYear() <= fecha.getDayOfYear()) {
            inicioAnio = inicioAnio.plus(semana);
            numeroSemanas++;
        }

        if (inicioAnio.getDayOfWeek().getValue() > fecha.getDayOfWeek().getValue()) {
            numeroSemanas++;
        }

        System.out.println("Es la semana número: " + numeroSemanas);
        return numeroSemanas;
    }

    /**
     * @throws ArrayIndexOutOfBoundsException Ocurre cuando no se introduce la fecha con todos los datos necesarios
     * @throws DateTimeException              Ocurre cuando en la fecha introducida no existe en el calendario gregoriano
     *                                        <p>
     *                                        Método encargado de instanciar las variables globales de la clase Fechas.java pidiendo los datos por pantalla
     */
    public static void creaFechas() throws ArrayIndexOutOfBoundsException, DateTimeException {
        Scanner sc = new Scanner(System.in);
        String[] fechas;
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = Calendar.getInstance();

        System.out.println("Introduzca las 2 fechas con las que trabajaremos(yyyy/MM/dd): ");
        //Creamos la primera fecha
        System.out.print("Primera fecha");
        fechas = sc.nextLine().split("/");
        if (fechas.length != 3) {
            throw new ArrayIndexOutOfBoundsException("La fecha no tiene todos los datos solicitados");
        }
        if (Integer.parseInt(fechas[2]) > 31 || Integer.parseInt(fechas[2]) < 1) {
            throw new DateTimeException("La fecha no existe en el calendario gregoriano");
        }
        fecha1.set(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]) - 1, Integer.parseInt(fechas[2]));
        Fechas.setFecha1(fecha1);
        Fechas.setTime1(LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2])));

        //Creamos la segunda fecha
        System.out.print("Segunda fecha");
        fechas = sc.nextLine().split("/");
        if (fechas.length != 3) {
            throw new ArrayIndexOutOfBoundsException("La fecha no tiene todos los datos solicitados");
        }
        if (Integer.parseInt(fechas[2]) > 31 || Integer.parseInt(fechas[2]) < 1) {
            throw new DateTimeException("La fecha no existe en el calendario gregoriano");
        }
        fecha2.set(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]) - 1, Integer.parseInt(fechas[2]));
        Fechas.setFecha2(fecha2);
        Fechas.setTime2(LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2])));
    }

    /**
     * @param fecha La fecha a la que daremos formato yyyy/MM/dd
     * @return La fecha con el formato dado
     * @throws IllegalArgumentException Ocurre cuando se pasa con una fecha por parámetro errónea
     */
    public static String FormatoFecha(final Calendar fecha) throws IllegalArgumentException {
        if (fecha == null || fecha.get(MONTH) > 12 || fecha.get(DAY_OF_MONTH) > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }

        return fecha.get(YEAR) + "/" + (fecha.get(MONTH) + 1) + "/" + fecha.get(DAY_OF_MONTH);
    }

    /**
     * @param periodo Un periodo de tiempo entre dos fechas
     * @return El periodo con el formato dado
     * @throws IllegalArgumentException Ocurre cuando se pasa un periodo por parámetro erróneo
     */
    public static String FormatoPeriodo(final Period periodo) throws IllegalArgumentException {
        if (periodo == null || periodo.getMonths() > 12 || periodo.getYears() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }

        return Math.abs(periodo.getYears()) + " años, " + Math.abs(periodo.getMonths()) + " meses, " + Math.abs(periodo.getDays()) + " día(s).";
    }
}
