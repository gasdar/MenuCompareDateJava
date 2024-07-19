package helpers;

import java.util.Scanner;

public class DateHelper {

    public static String getDateByUser(String m) {
        Scanner scan = new Scanner(System.in);
        String dateFormat;
        boolean tryAgain;
        do {
            tryAgain = false;
            System.out.println("******************************************");
            System.out.print(m);
            dateFormat = scan.next();
            if(TextHelper.notContent(dateFormat)) {
                System.out.println("Debe ingresar un valor para el formato de fecha");
                tryAgain = true;
            } else if(!containDateFormat(dateFormat)) {
                System.out.println("Debe ingresar el formato de fecha (YYYY-MM-DD)");
                tryAgain = true;
            } else if(notDateRange(dateFormat.split("-")[0], 1900, 2100)) {
                System.out.println("Debe ingresar un año entre 1900 - 2100");
                tryAgain = true;
            } else if(notDateRange(dateFormat.split("-")[1], 1, 12)) {
                System.out.println("Debe ingresar un mes entre 01 - 12");
                tryAgain = true;
            } else if(notDateRange(dateFormat.split("-")[2], 1, daysByMonthAndYear(Integer.parseInt(dateFormat.split("-")[1]), Integer.parseInt(dateFormat.split("-")[0])))) {
                System.out.println("Debe ingresar un día entre 01 - " + daysByMonthAndYear(Integer.parseInt(dateFormat.split("-")[1]), Integer.parseInt(dateFormat.split("-")[0])));
                tryAgain = true;
            }
            if(tryAgain) {
                if(TextHelper.isProcessFinish()) {
                    return null;
                }
            }
        } while(tryAgain);
        return dateFormat;
    }

    private static boolean containDateFormat(String dateFormat) {
        String[] dateParts = dateFormat.split("-");
        if(dateParts.length != 3) {
            return false;
        }
        return isCheckedDatePart(dateParts[0].trim(), 4) && isCheckedDatePart(dateParts[1].trim(), 2) && isCheckedDatePart(dateParts[2].trim(), 2);
    }

    private static boolean isCheckedDatePart(String datePart, int length) {
        return datePart.length() == length;
    }

    private static boolean notDateRange(String datePart, int lowerLimit, int upperLimit) {
        try {
            int number = Integer.parseInt(datePart);
            return number < lowerLimit || number > upperLimit;
        } catch(NumberFormatException e) {
            return true;
        }
    }

    private static int daysByMonthAndYear(int month, int year) {
        int days;
        switch(month) {
            case 1,3,5,7,8,10,12 -> days=31;
            case 4,6,9,11 -> days=30;
            default -> {
                if( (year%4==0 && year%100!=0) || (year%400==0) ) {
                    days=29;
                } else {
                    days=28;
                }
            }
        }
        return days;
    }

}
