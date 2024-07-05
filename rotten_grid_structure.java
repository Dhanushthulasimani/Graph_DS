import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class rotten_grid_structure {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOrange = 0;
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    ArrayList<Integer> rottenOrange = new ArrayList<>();
                    rottenOrange.add(i);
                    rottenOrange.add(j);
                    q.add(rottenOrange);
                } else if (grid[i][j] == 1) {
                }
            }
        }

        int toRotTime = -1;

        while (!q.isEmpty()) {
            toRotTime++;

            int size = q.size();

            for (int x = 0; x < size; x++) {
                ArrayList<Integer> toRot = q.poll();
                int i = toRot.get(0);
                int j = toRot.get(1);


                if (i < m - 1 && grid[i + 1][j] == 1)
                {
                    grid[i + 1][j] = 2;
                    ArrayList<Integer> newRottenOrange = new ArrayList<>();
                    newRottenOrange.add(i + 1);
                    newRottenOrange.add(j);
                    q.add(newRottenOrange);
                }
                if (i > 0 && grid[i - 1][j] == 1)
                {
                    grid[i - 1][j] = 2;
                    ArrayList<Integer> newRottenOrange = new ArrayList<>();
                    newRottenOrange.add(i - 1);
                    newRottenOrange.add(j);
                    q.add(newRottenOrange);

                }
                if (j < n - 1 && grid[i][j + 1] == 1)
                {
                    grid[i][j + 1] = 2;
                    ArrayList<Integer> newRottenOrange = new ArrayList<>();
                    newRottenOrange.add(i);
                    newRottenOrange.add(j + 1);
                    q.add(newRottenOrange);
                }
                if (j > 0 && grid[i][j - 1] == 1)
                {
                    grid[i][j - 1] = 2;
                    ArrayList<Integer> newRottenOrange = new ArrayList<>();
                    newRottenOrange.add(i);
                    newRottenOrange.add(j - 1);
                    q.add(newRottenOrange);
                }
            }
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }

        return toRotTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int result = orangesRotting(grid);

        System.out.println("time taken to rotten:" +result);
        System.out.println("Grid after rotting");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

