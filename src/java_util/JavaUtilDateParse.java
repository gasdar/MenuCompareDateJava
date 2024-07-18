package java_util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class JavaUtilDateParse {

    // 79. CONVERTIR UNA FECHA STRING A OBJETO DEL TIPO DATE
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
        // base de datos.
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;

        // Este método nos pide por obligación manejar try & catch, ya que puede
        // ser que ingresemos una fecha incorrecta.
        System.out.println("\n******************************************");
        System.out.println("ENTREGANDO FORMATO CORRECTO");
        try {
            fecha = df.parse("2020-07-01");
            System.out.println("fecha = " + fecha);
            System.out.println("(df.format(fecha)) = " + (df.format(fecha)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("******************************************");
        System.out.println("ENTREGANDO FORMATO CON POSIBLE ERROR");
        try {
            // fecha = df.parse("2022/01/12"); // error
            // fecha = df.parse("12-01-2022"); // Aquí no existe error, pero el resultado es muy ambiguo, ya que, el día es superado por el máximo lo que entrega más años
            fecha = df.parse("2022-01-12");
            System.out.println("fecha = " + fecha);
            System.out.println("(df.format(fecha)) = " + (df.format(fecha)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("******************************************");
        System.out.println("ENTREGANDO CON FORMATO CAMBIADO POR USUARIO");
        df.applyPattern("dd-MM-yyyy");
        try {
            fecha = df.parse("01-09-2023");
            System.out.println("fecha = " + fecha);
            System.out.println("(df.format(fecha)) = " + (df.format(fecha)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("******************************************");
        System.out.println("ENTREGANDO CON FORMATO CAMBIADO POR USUARIO");
        Scanner scan = new Scanner(System.in);
        df.applyPattern("yyyy-MM-dd");
        try {
            System.out.print("Ingrese una fecha con el formato (YYYY-MM-DD): ");
            fecha = df.parse(scan.next());
            System.out.println("fecha = " + fecha);
            System.out.println("(df.format(fecha)) = " + (df.format(fecha)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
