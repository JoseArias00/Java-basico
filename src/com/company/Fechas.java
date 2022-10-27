package com.company;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class Fechas {

    /**
     * @throws ParseException Por usar el cambio de formato
     */
    public static void main() throws ParseException {
        Scanner sc = new Scanner(System.in);
        String[] fechas;
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = Calendar.getInstance();

        System.out.println("Introduzca las 2 fechas con las que trabajaremos(yyyy/MM/dd: ");
        System.out.print("Primera fecha");
        fechas = sc.nextLine().split("/");
        fecha1.set(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]) - 1, Integer.parseInt(fechas[2]));

        System.out.print("Segunda fecha");
        fechas = sc.nextLine().split("/");
        fecha2.set(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]) - 1, Integer.parseInt(fechas[2]));


        diferenciaDias(fecha1, fecha2);
        numeroDias(fecha1, fecha2);
        numeroSemana(fecha1, fecha2);
    }

    /**
     * @param fecha1 Fecha 1 introducida por el usuario
     * @param fecha2 Fecha 2 introducida por el usuario
     *               <p>
     *               Metodo que calcula la diferencia de dias entre dos fechas
     */
    public static int diferenciaDias(Calendar fecha1, Calendar fecha2) {
        //Vamos a calcular la diferencia de tiempo entre ambas fechas en milisegundos que luego pasaremos a dias

        int milisecondsByDay = 86400000;
        int dias = (int) ((fecha1.getTime().getTime() - fecha2.getTime().getTime()) / milisecondsByDay);

        //Math.abs es utilizado para indicar la diferencia de dias como valor absoluto
        System.out.println("Hay una diferencia de: " + Math.abs(dias));

        return Math.abs(dias);
    }

    public static void inicioFinAnio() {

    }

    /**
     * @param fecha1 Fecha 1 introducida por el usuario
     * @param fecha2 Fecha 2 introducida por el usuario
     *               <p>
     *               Metodo con el que calcularemos el total de dias transcurridos desde el principio de año
     */
    public static void numeroDias(Calendar fecha1, Calendar fecha2) {
        //Creamos dos fechas auxiliares en 1 de enero de los anios de las fechas indicadas
        Calendar fecha1aux = Calendar.getInstance();
        Calendar fecha2aux = Calendar.getInstance();


        fecha1aux.set(fecha1.get(Calendar.YEAR), Calendar.JANUARY, 1);
        fecha2aux.set(fecha2.get(Calendar.YEAR), Calendar.JANUARY, 1);

        diferenciaDias(fecha1aux, fecha1);
        diferenciaDias(fecha2aux, fecha2);
    }

    /**
     * @param fecha1 Fecha 1 introducida por el usuario
     * @param fecha2 Fecha 2 introducida por el usuario
     *               Metodo encargado de mostrar por pantalla el numero de la semana de la semana indicada
     */
    public static void numeroSemana(Calendar fecha1, Calendar fecha2) {
        //Comprobamos que esa semana no comience en el anio pasado para evitar que nos indique la ultima semana del anio pasado
        if (fecha1.get(Calendar.MONTH) == 0 && fecha1.get((Calendar.WEEK_OF_YEAR)) > 50) {
            System.out.println("Es la semana: 1");
        } else {
            System.out.println("Es la semana: " + fecha1.get(Calendar.WEEK_OF_YEAR) + 1);
        }

        if (fecha2.get(Calendar.MONTH) == 0 && fecha2.get((Calendar.WEEK_OF_YEAR)) > 50) {
            System.out.println("Es la semana: 1");
        } else {
            System.out.println("Es la semana: " + (fecha2.get(Calendar.WEEK_OF_YEAR) + 1));
        }
    }


}
