import java.util.Scanner;

public class Kangaroo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loc_1 = scanner.nextInt();
        int vel_1 = scanner.nextInt();

        int loc_2 = scanner.nextInt();
        int vel_2 = scanner.nextInt();

        if((loc_1 <= loc_2) && (vel_1 <= vel_2)) {
            System.out.println("NO");
            return;
        }
        if((loc_1 >= loc_2) && (vel_1 >= vel_2)) {
            System.out.println("NO");
            return;
        }

        if(loc_1 < loc_2) {
            while (loc_1 <= loc_2) {

                if (loc_1 == loc_2) {
                    System.out.println("YES");
                    return;
                }

                loc_1 += vel_1;
                loc_2 += vel_2;

            }
            System.out.println("NO");
            return;
        }
        if(loc_1 > loc_2) {
            while (loc_1 >= loc_2) {

                if (loc_1 == loc_2) {
                    System.out.println("YES");
                    return;
                }

                loc_1 += vel_1;
                loc_2 += vel_2;

            }
            System.out.println("NO");
            return;
        }
        if(loc_1 == loc_2) {
            System.out.println("YES");
            return;
        }

    }

}
