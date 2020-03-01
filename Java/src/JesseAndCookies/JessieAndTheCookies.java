import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class JessieAndTheCookies {
    private static BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {


        String line = bi.readLine();
        int minimumSweetness = Integer.parseInt(line.split("\\s")[1]);

        PriorityQueue<Integer> cookieList = new PriorityQueue<>();

        line = bi.readLine();

        for (String numStr : line.split("\\s")) {
            int cookie = Integer.parseInt(numStr);
            cookieList.add(cookie);
        }
        int operations = 0;
        if (cookieList.size() == 0) {
            System.out.println(0);
            System.exit(0);
        }


        while (cookieList.peek()<minimumSweetness) {
            if(cookieList.size()==1)
                break;

            int newCookie = cookieList.poll() + 2 * cookieList.poll();

            cookieList.add(newCookie);
            operations++;
        }

        if (cookieList.peek()>= minimumSweetness)
            System.out.println(operations);
        else
            System.out.println(-1);
    }

}