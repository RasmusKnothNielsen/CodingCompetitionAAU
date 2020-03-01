import java.util.Scanner;

public class RegexSolutionSuperReducedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();
        while (line.matches(".*([a-z])\\1{1}.*")) {
            line=line.replaceAll("([a-z])\\1{1}","");
        }
        if (line.isEmpty()) {
            System.out.println("Empty String");
        } else {
            System.out.println(line);
        }
    }
}