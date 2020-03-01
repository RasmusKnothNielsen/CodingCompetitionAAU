import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConnectedCells {

    static int[][] matrix;
    static int[][] regionMatrix;
    static ArrayList<Integer> counters;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        matrix = new int[rows][cols];
        regionMatrix = new int[rows][cols];
        counters = new ArrayList<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        int regionNumber = 1;
        counters.add(0);
        counters.add(0);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 1 && regionMatrix[i][j] == 0) {
                    getRegion(i, j, regionNumber);
                    regionNumber++;
                    counters.add(0);
                }
            }
        }

        Collections.sort(counters);
        System.out.println(counters.get(counters.size()-1));

    }

    private static void getRegion(int row, int col, int regionNumber) {

        regionMatrix[row][col] = regionNumber;
        counters.set(regionNumber, counters.get(regionNumber)+1);

        //Check if neighbours are 1
        if (row < matrix.length-1) {

            if(matrix[row+1][col] == 1 && regionMatrix[row+1][col] == 0) {
                getRegion(row+1, col, regionNumber);
            }

            if (col < matrix[0].length-1) {
                if(matrix[row+1][col+1] == 1 && regionMatrix[row+1][col+1] == 0) {
                    getRegion(row+1, col+1, regionNumber);
                }
            }

            if(col > 0) {
                if(matrix[row+1][col-1] == 1 && regionMatrix[row+1][col-1] == 0) {
                    getRegion(row+1, col-1, regionNumber);
                }
            }

        }
        if (col < matrix[0].length-1) {
            if(matrix[row][col+1] == 1 && regionMatrix[row][col+1] == 0) {
                getRegion(row, col+1, regionNumber);
            }

            if(row > 0) {
                if(matrix[row-1][col+1] == 1 && regionMatrix[row-1][col+1] == 0) {
                    getRegion(row-1, col+1, regionNumber);
                }
            }
        }

        if (col > 0) {
            if(matrix[row][col-1] == 1 && regionMatrix[row][col-1] == 0) {
                getRegion(row, col-1, regionNumber);
            }

            if(row > 0) {
                if(matrix[row-1][col-1] == 1 && regionMatrix[row-1][col-1] == 0) {
                    getRegion(row-1, col-1, regionNumber);
                }
            }
        }

        if (row > 0) {
            if(matrix[row-1][col] == 1 && regionMatrix[row-1][col] == 0) {
                getRegion(row-1, col, regionNumber);
            }
        }

    }

}
