package java_util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtilCalendar {

    // 78. LA CLASE CALENDAR

    // NOTAS
    /*
    1. ¿Por qué utilizar una clase 'Calendar'? Para asignar una fecha
    particular en una instancia de la clase 'Date' de java.util.
    2. La clase Calendar es abstracta, quiere decir que podemos hacer
    mención a la clase, pero al instanciar o declarar un objeto tendrá que
    ser mediante una clase hija o mediante un proceso interno para obtener
    una instancia de esta. En este caso, mediante getInstance() una clase
    static de Calendar, esto es por el diseño, ya que, las clases
    abstractas no pueden utilizar el operador 'new'.
    3. El método getInstance() de Calendar, por debajo crea la instancia
    dependiendo de la zona horaria y la localización, puede ser muy
    probable que devuelva una instancia del calendario gregoriano, una
    clase hija.
    */

    public static void main(String[] args) {

        Calendar calendario = Calendar.getInstance();
        Date fecha = calendario.getTime();
        System.out.println("\n************************************");
        System.out.println("SE UTILIZAN DISTINTAS FECHAS MEDIANTE INSTANCIA CALENDAR");
        System.out.println("fecha = " + fecha);

        calendario.set(2024, Calendar.JANUARY, 30);
        fecha = calendario.getTime();
        System.out.println("fecha = " + fecha);

        calendario.set(2024, Calendar.JANUARY, 20, 8, 30, 15);
        fecha = calendario.getTime();
        System.out.println("fecha = " + fecha);

        calendario.set(1999, Calendar.AUGUST, 20, 0, 70, 59);
        fecha = calendario.getTime();
        System.out.println("fecha = " + fecha);

        System.out.println("************************************");
        System.out.println("OBTENER FECHA ENTREGANDO CAMPOS 1 POR 1");
        calendario.set(Calendar.YEAR, 2020);
        calendario.set(Calendar.MONTH, Calendar.AUGUST);
        calendario.set(Calendar.DAY_OF_MONTH, 25);
        calendario.set(Calendar.HOUR_OF_DAY, 21);
        calendario.set(Calendar.MINUTE, 20);
        calendario.set(Calendar.SECOND, 58);
        calendario.set(Calendar.MILLISECOND, 1500);

        fecha = calendario.getTime();
        System.out.println("fecha = " + fecha);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
        String fechaFormato = df.format(fecha);
        System.out.println("fechaFormato = " + fechaFormato);

        df.applyPattern("yyyy-MM-dd HH:mm:ss:SSS a");
        fechaFormato = df.format(fecha);
        System.out.println("fechaFormato = " + fechaFormato);

        calendario.set(Calendar.HOUR, 5);
        calendario.set(Calendar.AM_PM, Calendar.PM);
        fecha = calendario.getTime();
        df.applyPattern("yyyy-MM-dd HH:mm:ss:SSS a");
        fechaFormato = df.format(fecha);
        System.out.println("fechaFormato = " + fechaFormato);

        calendario.set(Calendar.HOUR, 12);
        fecha = calendario.getTime();
        df.applyPattern("yyyy-MM-dd hh:mm:ss:SSS a");
        fechaFormato = df.format(fecha);
        System.out.println("fechaFormato = " + fechaFormato);

    }

}
