 package exercise;

import helpers.DateHelper;
import helpers.NumberHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 public class DateMenu {

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
        2. Calcular Edad
        3. Salir

        1.
            1. Fecha Ingresada vs Actual
            2. Atrás
        2.
            Para esta tarea se pide ingresar una fecha de nacimiento en formato
            string, convertirla a una fecha del tipo java.util.Date y calcular
            la edad de la persona de acuerdo a la fecha actual.
            Intentar usar solo lo visto hasta el momento, no el api de java 8
            que lo veremos más adelante, también se pueden apoyar de google que
            hay varios ejemplos.
        3.
            Salir
        */

        String menu;
        int opcion;
        System.out.println("\n******************************************");
        System.out.println("BIENVENIDO AL MÉNU DE OPCIONES");
        menu = "MENÚ PRINCIPAL\n(1) Comparar Fecha\n(2) Calcular Edad\n(3) Salir";
        do {
            opcion = NumberHelper.getOptionByUser(menu,1, 3);
            switch (opcion) {
                case 1 -> menuCompareDate();
                case 2 -> calculateAge();
                default -> {
                    System.out.println("******************************************");
                    System.out.println("Muchas gracias por utilizar el programa!!");
                }
            }
        } while(opcion != 3);

    }

    private static void menuCompareDate() {
        String menu;
        int option;
        menu = "(1) Fecha Ingresada VS Fecha Actual\n(2) Atrás";

        do {
            option = NumberHelper.getOptionByUser(menu, 1, 2);
            switch (option) {
                case 1 -> compareDateByUser();
            }
        } while(option != 2);

    }

    private static void compareDateByUser() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1;
        String fechaUsuario;

        // VERIFICAMOS FORMATO
        fechaUsuario = DateHelper.getDateByUser("Ingrese una fecha con el formato (YYYY-MM-DD): ");
        if(fechaUsuario == null) {
            return;
        }
        try {
            fecha1 = df.parse(fechaUsuario);
            Date fecha2 = new Date();
            System.out.println("******************************************");
            System.out.println("COMPARACIÓN DE FECHAS CON AFTER Y BEFORE");
            if(fecha1.after(fecha2)) {
                System.out.println("fecha1 (del usuario) es después/mayor que fecha2 (actual)");
            } else if(fecha1.before(fecha2)) {
                System.out.println("fecha1 (del usuario) es antes/menor que fecha2 (actual)");
            } else if(fecha1.equals(fecha2)) {
                System.out.println("fecha1 es igual a fecha2");
            }
            System.out.println("fecha1 = " + fecha1);
            System.out.println("fecha2 = " + fecha2);
            System.out.println("(df.format(fecha1)) = " + (df.format(fecha1)));
            System.out.println("(df.format(fecha2)) = " + (df.format(fecha2)));

            System.out.println("******************************************");
            System.out.println("COMPARACIÓN DE FECHAS CON COMPARE_TO");
            // Retorna un int, si el valor es mayor a 0 es porque es fecha1 es
            // mayor que fecha2.
            if(fecha1.compareTo(fecha2) > 0) {
                System.out.println("fecha1 (del usuario) es después/mayor que fecha2 (actual)");
            } else if(fecha1.compareTo(fecha2) < 0) {
                System.out.println("fecha1 (del usuario) es antes/menor que fecha2 (actual)");
            } else if(fecha1.compareTo(fecha2) == 0) {
                System.out.println("fecha1 es igual a fecha2");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculateAge() {
        String fechaFormato;
        int edad, anioActual, mesActual, diaActual, anioUsuario, mesUsuario, diaUsuario;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar fechaNacimiento = Calendar.getInstance(), fechaActual;

        try {
            do {
                fechaFormato = DateHelper.getDateByUser("Ingrese su fecha de nacimiento con el formato (YYYY-MM-DD): ");
                if(fechaFormato == null) {
                    return;
                }
                fechaNacimiento.setTime(df.parse(fechaFormato));
                fechaActual = Calendar.getInstance();
                if(fechaNacimiento.after(fechaActual)) {
                    System.out.println("Debe ingresar una fecha inferior a la actual");
                }
            } while(fechaNacimiento.after(fechaActual));
            anioActual = fechaActual.get(Calendar.YEAR);
            mesActual = fechaActual.get(Calendar.MONTH);
            diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
            anioUsuario = fechaNacimiento.get(Calendar.YEAR);
            mesUsuario = fechaNacimiento.get(Calendar.MONTH);
            diaUsuario = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
            edad = anioActual - anioUsuario; // 2024-04-28 vs 2020-04-29
            if(mesUsuario>mesActual || (mesUsuario==mesActual && diaUsuario>diaActual)) {
                edad -= 1;
            }
            System.out.println("Su edad es de: " + edad + " años");
        } catch(ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
