package SuperReducedString;

import java.util.Scanner;

public class ReducedSuperString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < line.length() - 1; i++) {
                if (line.charAt(i) == line.charAt(i + 1)) {
                    changed = true;
                    if (i + 2 < line.length())
                        line = line.substring(0, i) + line.substring(i + 2);
                    else
                        line = line.substring(0, i);
                    break;
                }
            }
        }
        if (line.isEmpty())
            System.out.println("Empty String");
        else
            System.out.println(line);

    }
}