package com.company;

import java.text.ParseException;
import java.util.Scanner;

public class Main<opcion> {
    public static final int REDONDEO = 4;


    /**
     *
     * @param args
     * @throws ParseException Por culpa del ejercicio de fechas al usar el formato de fechas
     */
    public static void main(String[] args) throws ParseException,RedondeoExcepcion {
        //Primero indicaremos el ejercicio a ejecutar usando scanner
        System.out.println("Indica el ejercicio a realizar: " +
                "\n1. Operaciones con números" +
                "\n2. Operaciones con texto" +
                "\n3. Operaciones con fechas" +
                "\n4. Operaciones con clases" +
                "\n5. Generación aleatorio" +
                "\n6. Curiosidad matemática" +
                "\n7. CRUD");
        Scanner sc = new Scanner(System.in);
        int opcion;
        opcion = sc.nextInt();

        seleccion(opcion);

    }

    /**
     *  @param opcion El ejercicio seleccionado que le pasamos al switch
     *  @throws ParseException Por culpa del caso 3 al usar el formato de fechas
     */
    private static void seleccion(int opcion) throws ParseException,RedondeoExcepcion {
        switch (opcion){
            case 1: Números numeros = new Números();
                numeros.main();
                break;
            case 2: OperacionTexto texto = new OperacionTexto();
                texto.main();
                break;
            case 3: Fechas fechas = new Fechas();
                fechas.main();
                break;
            case 4: ItemsSeparator itemsSeparator = new ItemsSeparator();
                itemsSeparator.main();
                break;
            case 5: Aleatorios aleatorios = new Aleatorios();
                aleatorios.main();
                break;
            case 6: Matematica matematica = new Matematica();
                matematica.main();
                break;
            case 7: CRUD crud = new CRUD();
                crud.main();
                break;
            default: System.out.println("La opción introducida no es válida introduzca una opcion valida");
        }
    }


}
