package FindDigits;

import java.util.Scanner;

public class FindDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {

            int test = scanner.nextInt();
            scanner.nextLine();

            int divisors = 0;
            int workTest = test;

            int[] tested = new int[10];

            while (workTest > 0) {

                int number = workTest % 10;
                workTest /= 10;
                if (number != 0) {
                    if (tested[number] == 1)
                        divisors++;
                    else if (tested[number] == 0) {
                        if (test % number == 0) {
                            divisors++;
                            tested[number] = 1;
                        } else
                            tested[number] = 2;
                    }
                }
            }
            System.out.println(divisors);
        }
    }
}