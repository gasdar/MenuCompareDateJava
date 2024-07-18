 package java_util;

import helpers.DateHelper;
import helpers.NumberHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CompareDate {

    // 80. COMPARAR FECHAS
    /*
    NOTAS:
    1. ¿Para qué nos sirve realizar la conversión de un String a una fecha Date?
    Es muy util, debido a que, podemos obtener objetos de un campo de fecha
    mediante un formulario y manipularlo para guardarlo en un base de datos. O
    luego de convertirlo a una fecha utilizar el campo para realizar algún
    cálculo en nuestra aplicación.
    2. Muchos cálculos se realizan utilizando los datos del año, mes y día de
    una fecha particular.
    */

    public static void main(String[] args) {

        // 1. PATRÓN QUE SE ENTREGA A SIMPLE_DATE_FORMAT, se debe respetar en el
        // método que realizará la conversión: obj.parse(fechaFormato).
        // 2. El patrón que ingresamos se debe de respetar mediante los datos que
        // son ingresados por el usuario. Como ejemplo proveemos un formato de
        // base de datos (YYYY-MM-DD).
        /*
        REALIZAR EJERCICIO DONDE SE CREA UN MENÚ DE OPCIONES:

        1. Comparar Fecha
        2. Salir

        1. =>
            1. Fecha Ingresada vs Actual
            2. Atrás
        2. =>
            Finalizar programa
        */

        String menu;
        int opcion;
        System.out.println("\n******************************************");
        System.out.println("BIENVENIDO AL MÉNU DE OPCIONES");
        menu = "MENÚ PRINCIPAL\n\n(1) Comparar Fecha\n(2) Salir";
        do {
            System.out.println("******************************************");
            System.out.println(menu);
            opcion = NumberHelper.getOptionByUser(1, 2);
            switch (opcion) {
                case 1 -> compareDate();
                default -> {
                    System.out.println("Muchas gracias por utilizar el programa!!");
                }
            }
        } while(opcion != 2);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;
        String fechaUsuario;
        Scanner scan = new Scanner(System.in);


        try {
            do {
                fechaUsuario = DateHelper.getDateByUser("Ingrese una fecha con el formato (YYYY-MM-DD): ");
                if(fechaUsuario == null) {

                }
            } while(fechaUsuario == null);
            fecha = df.parse();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }



}
