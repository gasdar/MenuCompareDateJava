package java_util;

import java.util.Date;

public class DateGetTime {

    // 77. TIEMPO EN MILISEGUNDOS CON MÉTODO 'GET_TIME()' (TIMESTAMP)
    /*
        En la clase Date también podemos utilizar el método getTime() que, nos
        devuelve una fecha en formato de milisegundos a partir de enero de 1970
        hasta la fecha actual, es un método soportado e incluido en SO Unix, pero
        con la diferencia que en Unix el valor es devuelto en segundos y en Java
        el valor es obtenido en milisegundos, este valor es también conocido
        como: timestamp.

    */

    public static void main(String[] args) {

        // El valor es obtenido de la instancia
        // Similar a 'System.currentTimeMillis()'
        Date fecha1 = new Date();
        long j=0;
        for(int i=0; i<100000000; i++){
            j += i;
        }
        Date fecha2 = new Date();
        long resultadoFinal = fecha2.getTime() - fecha1.getTime();
        System.out.println("\n****************************************");
        System.out.println("j = " + j);
        System.out.println("resultadoFinal = ms" + resultadoFinal);

    }

}
