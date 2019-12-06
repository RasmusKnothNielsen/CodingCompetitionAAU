package CommonLowestAncestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CommonLowestAncestor {

    private static BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(bi.readLine());
        BinTree tree = new BinTree(size);

        int tmp;
        String[] nums = bi.readLine().split("\\s");
        int i=0;

        for (String numStr: nums) {
            tree.addNode(Integer.parseInt(numStr));
        }

        String[] values = bi.readLine().split("\\s");
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[1]);

        //System.out.println(tree);

        int[] lineageA = tree.getLineage(a);
        int[] lineageB = tree.getLineage(b);


        //System.out.println(Arrays.toString(lineageA));
        //System.out.println(Arrays.toString(lineageB));


        for (int nodeA : lineageA) {
            for (int nodeB : lineageB) {
                if (nodeA == nodeB) {
                    System.out.println(nodeA);
                    return;
                }
            }
        }

    }

}
class BinTree {
    int[] nodes;

    BinTree(int size) {
        nodes = new int[5_000_000];
    }


    void addNode(int data) {

        int i = 0;
        while(true) {
            //System.out.println(this);
            //System.out.println(data);
            if(nodes[i] == 0) {
                nodes[i] = data;
                break;
            }

            else if (data < nodes[i]) {
                i = (i * 2) + 1;
            }

            else if (data > nodes[i]) {
                i = (i * 2) + 2;
            }
        }

    }

    int[] getLineage(int data) {
        int index = 0;
        for (int i = 0; i < nodes.length-1; i++) {
            if(nodes[i] == data) {
                index = i;
            }
        }

        int[] lineage = new int[25];
        Arrays.fill(lineage, nodes[0]);
        lineage[0] = nodes[index];

        int i = 1;
        while(index > 2) {
            if(index % 2 == 0) {
                index = index / 2 - 1;
                lineage[i] = nodes[index];
            } else {
                index /= 2;
                lineage[i] = nodes[index];
            }
            i++;
        }

        return lineage;
    }

    @Override
    public String toString() {
        return Arrays.toString(nodes);
    }
}


