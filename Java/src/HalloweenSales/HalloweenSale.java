import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HalloweenSale {

    public static void main(String[] args) throws Exception {

        InputStreamReader isr = new InputStreamReader(System.in, "UTF8");
        BufferedReader in = new BufferedReader(isr);
        String[] arr = in.readLine().split(" ");
        int[] arrInt = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        int price = arrInt[0];
        int deduction = arrInt[1];
        int minimum = arrInt[2];
        int startAmount = arrInt[3];
        int gamesBought = 0;

        while (price <= startAmount) {
            gamesBought++;
            startAmount -= price;

            price-=deduction;
            if(price<minimum) price=minimum;
        }
        System.out.println(gamesBought);
    }
}
