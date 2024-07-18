package helpers;

import java.util.Scanner;

public class TextHelper {

    public static boolean isProcessFinish() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Desea volver a intentarlo (s/n): ");
        return scan.next().equalsIgnoreCase("n");
    }

    public static boolean notContent(String s) {
        return s == null || s.trim().isEmpty() || s.isBlank();
    }

}
