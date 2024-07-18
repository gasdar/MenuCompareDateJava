package java_util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtilDate {

    // 76. LA CLASE 'DATE' Y FORMATOS DE FECHAS

    public static void main(String[] args) {

        // Utilizamos 'Date' de java.util, que es el estándar para trabajar con
        // fechas en lenguaje Java, pero también tenemos la clase 'Date' de
        // java.sql para trabajar con los formatos de la base de datos MySQL.
        Date fecha = new Date();

        System.out.println("\n***********************************");
        System.out.println("FORMATO POR DEFECTO DE OBJETO DATE DE JAVA");
        System.out.println("fecha = " + fecha);

        // Para trabajar con tipos de formatos personalizados, entregando un
        // patrón de formato estándar de Java.
        /*
        dd = día del mes.
        MM = número mes.
        MMMM = nombre mes.
        yyyy = año.
        */
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
        String fechaStr = df.format(fecha);
        System.out.println("***********************************");
        System.out.println("ENTREGAR FORMATO PERSONALIZADO DE OBJETO DATE");
        System.out.println("fechaStr = " + fechaStr);

        df.applyPattern("dd-MM-yyyy");
        fechaStr = df.format(fecha);
        System.out.println("fechaStr = " + fechaStr);

        df.applyPattern("'date: 'yyyy.MM.dd G 'at' HH:mm:ss z");
        fechaStr = df.format(fecha);
        System.out.println("fechaStr = " + fechaStr);

        df.applyPattern("EEEE dd 'de' MMMM 'de' yyyy");
        fechaStr = df.format(fecha);
        System.out.println("fechaStr = " + fechaStr);

    }

}
