package helpers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberHelper {

    public static int getOptionByUser(String menu, int lowerLimit, int upperLimit) {
        Scanner scan = new Scanner(System.in);
        int option;
        try {
            do {
                System.out.println("******************************************");
                System.out.println(menu);
                System.out.print("Ingrese una opción entre ("+lowerLimit+" - "+upperLimit+ "): ");
                option = scan.nextInt();
                if(option < lowerLimit || option > upperLimit) {
                    System.out.println("Debe ingresar una opción entre ("+lowerLimit+" - "+upperLimit+")");
                }
            } while(option < lowerLimit || option > upperLimit);
            return option;
        } catch(InputMismatchException e) {
            System.out.println("Debe ingresar un número de opción.");
            return getOptionByUser(menu, lowerLimit, upperLimit);
        }
    }

}
