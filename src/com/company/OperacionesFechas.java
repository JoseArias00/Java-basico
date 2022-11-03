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
public class OperacionesFechas {

    /**
     * @param fecha1 Fecha 1 introducida por el usuario
     * @param fecha2 Fecha 2 introducida por el usuario
     *               <p>
     *               Método que calcula la diferencia de dias entre dos fechas
     */
    public static int diferenciaDias(Calendar fecha1, Calendar fecha2) {
        //Vamos a calcular la diferencia de tiempo entre ambas fechas en milisegundos que luego pasaremos a dias

        int milisecondsByDay = 86400000;
        int dias = (int) ((fecha1.getTime().getTime() - fecha2.getTime().getTime()) / milisecondsByDay);

        //Math.abs es utilizado para indicar la diferencia de dias como valor absoluto
        System.out.println("Hay una diferencia de: " + Math.abs(dias));

        return Math.abs(dias);
    }

    /**
     * @param fecha1 Fecha 1 introducida por el usuario
     * @param fecha2 Fecha 2 introducida por el usuario
     *               <p>
     *               Método con el que calcularemos el total de dias transcurridos desde el principio de año
     */
    public static void numeroDias(Calendar fecha1, Calendar fecha2) {
        //Creamos dos fechas auxiliares en 1 de enero de los años de las fechas indicadas
        Calendar fecha1aux = getInstance();
        Calendar fecha2aux = getInstance();


        fecha1aux.set(fecha1.get(YEAR), Calendar.JANUARY, 1);
        fecha2aux.set(fecha2.get(YEAR), Calendar.JANUARY, 1);

        diferenciaDias(fecha1aux, fecha1);
        diferenciaDias(fecha2aux, fecha2);
    }

    /**
     * @param fecha1 Fecha 1 introducida por el usuario
     * @param fecha2 Fecha 2 introducida por el usuario
     *               Método encargado de mostrar por pantalla el número de la semana de la semana indicada
     */
    public static void numeroSemana(Calendar fecha1, Calendar fecha2) {
        //Comprobamos que esa semana no comience en el año pasado para evitar que nos indique la última semana del año pasado
        if (fecha1.get(MONTH) == 0 && fecha1.get((WEEK_OF_YEAR)) > 50) {
            System.out.println("Es la semana: 1");
        } else {
            System.out.println("Es la semana: " + fecha1.get(WEEK_OF_YEAR) + 1);
        }

        if (fecha2.get(MONTH) == 0 && fecha2.get((WEEK_OF_YEAR)) > 50) {
            System.out.println("Es la semana: 1");
        } else {
            System.out.println("Es la semana: " + (fecha2.get(WEEK_OF_YEAR) + 1));
        }
    }

    /**
     * @param fecha Fecha sobre la que operaremos para conocer su primer día del año
     * @return Fecha del primer día del año de la fecha pasada por parámetros
     */
    public static LocalDate inicioAnio(LocalDate fecha) {
        if (fecha == null || fecha.getMonthValue() > 12 || fecha.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }
        System.out.println("Fecha de inicio de año: " + LocalDate.of(fecha.getYear(), Month.JANUARY, 1));
        return LocalDate.of(fecha.getYear(), Month.JANUARY, 1);
    }

    /**
     * @param fecha Fecha sobre la que operaremos para conocer su último día del año
     * @return Fecha del último día del año de la fecha pasada por parámetros
     */
    public static LocalDate finAnio(LocalDate fecha) {
        if (fecha == null || fecha.getMonthValue() > 12 || fecha.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }
        System.out.println("Fecha de fin de año: " + LocalDate.of(fecha.getYear(), Month.JANUARY, 31));
        return LocalDate.of(fecha.getYear(), Month.DECEMBER, 31);
    }

    /**
     * @param fecha1 Fecha 1 a comparar
     * @param fecha2 Fecha 2 a comparar
     * @return El periodo de diferencia entre ambas fechas
     */
    public static Period diferenciaDiasTime(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha1.getMonthValue() > 12 || fecha1.getDayOfMonth() > 31 || fecha2 == null || fecha2.getMonthValue() > 12 || fecha2.getDayOfMonth() > 31) {
            throw new IllegalArgumentException("Parámetro incorrecto");
        }
        Period diferencia = Period.between(fecha1, fecha2);

        String formatoDate = Math.abs(diferencia.getYears()) + " años, " + Math.abs(diferencia.getMonths()) + " meses, " + Math.abs(diferencia.getDays()) + " día(s).";
        System.out.println("Han pasado: " + formatoDate + " días.");

        return diferencia;
    }

    /**
     * @param fechaLocal Fecha sobre la que opera el método
     * @return Número de dias que tiene el año de la fecha pasada como parámetro
     */
    public static int diasDelAnio(LocalDate fechaLocal) {
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
    public static int numeroSemana(LocalDate fecha) throws IllegalArgumentException {
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

        if (diferenciaDiasInicioAnioAhora < 0) {
            numeroSemanas = 0;
        } else {
            numeroSemanas = diferenciaDiasInicioAnioAhora / 7 + 1;
        }

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
    public static int numeroSemana2(LocalDate fecha) throws IllegalArgumentException {
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
        if (Integer.parseInt(fechas[2]) > 31) {
            throw new DateTimeException("La fecha existe en el calendario gregoriano");
        }
        fecha1.set(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]) - 1, Integer.parseInt(fechas[2]));
        Fechas.setTime1(LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2])));

        //Creamos la segunda fecha
        System.out.print("Segunda fecha");
        fechas = sc.nextLine().split("/");
        if (fechas.length != 3) {
            throw new ArrayIndexOutOfBoundsException("La fecha no tiene todos los datos solicitados");
        }
        if (Integer.parseInt(fechas[2]) > 31) {
            throw new DateTimeException("La fecha existe en el calendario gregoriano");
        }
        fecha2.set(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]) - 1, Integer.parseInt(fechas[2]));
        Fechas.setTime2(LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2])));


    }
}
