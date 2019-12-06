package MarsExploration;

import java.io.*;

public class MarsExploration {

    public static void main(String[] args) throws Exception {

        int count = 0;
        InputStreamReader isr = new InputStreamReader(System.in, "UTF8");
        BufferedReader in = new BufferedReader(isr);
        byte[] a = in.readLine().getBytes();

        for (int i = 0; i < a.length; i += 3) {
            if (a[i] != 83){
                count++;
            }
            if (a[i+1] != 79) {
                count++;
            }
            if (a[i+2] != 83) {
                count++;
            }
        }
        System.out.println(count);
    }
}