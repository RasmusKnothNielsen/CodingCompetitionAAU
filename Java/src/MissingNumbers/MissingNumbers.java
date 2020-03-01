import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MissingNumbers {

    private static BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        PriorityQueue<Integer> firstNumbers = new PriorityQueue<>();
        PriorityQueue<Integer> secondNumbers = new PriorityQueue<>();

        String line = bi.readLine();
        line = bi.readLine();

        for (String numStr : line.split("\\s")) {
            firstNumbers.add(Integer.parseInt(numStr));
        }

        line = bi.readLine();
        line = bi.readLine();

        for (String numStr : line.split("\\s")) {
            secondNumbers.add(Integer.parseInt(numStr));
        }

        while (firstNumbers.size() > 0) {
            int first = firstNumbers.peek();
            int second = secondNumbers.peek();

            if (first > second) {
                System.out.print(second + " ");
                while (secondNumbers.peek() == second)
                    secondNumbers.poll();

            } else {
                firstNumbers.poll();
                secondNumbers.poll();
            }
        }
        while (secondNumbers.size() > 0) {
            int number=secondNumbers.poll();
            System.out.print(number+" ");
            while(secondNumbers.size()>0 && secondNumbers.peek()==number)
                secondNumbers.poll();
        }

    }

}