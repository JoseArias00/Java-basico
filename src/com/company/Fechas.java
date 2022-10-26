package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Fechas {
    //Establecemos el formato de fecha a usar
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

    /**
     *
     * @throws ParseException Por culpa de usar el cambio de formato
     */
    public static void main() throws ParseException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca las 2 fechas con las que trabajaremos(yyyy/MM/dd: ");
        System.out.print("Primera fecha");
        Date fecha1 = formato.parse(sc.nextLine());
        System.out.print("Segunda fecha");
        Date fecha2 = formato.parse(sc.nextLine());

        diferenciaDias(fecha1,fecha2);
    }

    /**
     *
     * @param fecha1 Primera fecha introducida por el usuario
     * @param fecha2 Segunda fecha introducida por el usuario
     */
    public static void diferenciaDias(Date fecha1, Date fecha2){
        //Vamos a calcular la diferencia de tiempo entre ambas fechas en milisegundos que luego pasaremos a dias

        int milisecondsByDay = 86400000;
        int dias = (int) ((fecha1.getTime()-fecha2.getTime())/milisecondsByDay);

        //Math.abs es utilizado para indicar la diferencia de dias como valor absoluto
        System.out.println("Hay una diferencia de: " + Math.abs(dias));
    }

}
