import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sherlock {

    private static BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int cases = Integer.parseInt(bi.readLine());
        for (int i = 0; i < cases; i++) {
            sherlock();
        }

    }

    private static void sherlock() throws Exception{

        int len = Integer.parseInt(bi.readLine());

        int[] intArray = new int[len];

        int rightSum = 0;

        int tmp;

        String line = bi.readLine();

        int i=0;
        for (String numStr: line.split("\\s")) {
            tmp = Integer.parseInt(numStr);
            intArray[i++]=tmp;
            rightSum+=tmp;
        }


        int tempSum = intArray[0];
        rightSum -= tempSum;
        int leftSum = 0;
        for (int j = 0; j < len; j++) {
            if (leftSum >= rightSum)
                break;
            leftSum += tempSum;
            if (j + 1 < len)
                tempSum = intArray[j + 1];
            else
                tempSum = 0;
            rightSum -= tempSum;
        }

        if (leftSum == rightSum)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}