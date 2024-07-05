import java.util.*;

public class Matrix_01 {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> q= new LinkedList<>();
        int[][] dis= new int[m][n];

        boolean[][] vis= new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty())
        {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int k = 0; k < 4; k++)
            {
                int newRow = currRow + dx[k];
                int newCol = currCol + dy[k];

                if (newRow >= 0 && newRow < m && newCol >= 0 &&
                        newCol < n && !vis[newRow][newCol])
                {
                    dis[newRow][newCol] = dis[currRow][currCol] + 1;
                    vis[newRow][newCol] = true;
                    q.offer(new int[] {newRow, newCol});
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        Matrix_01 solution = new Matrix_01();

        int[][] matrix1 = {
                {1, 1, 0},
                {2, 1, 0},
                {0, 3, 0}
        };

        int[][] result1 = solution.updateMatrix(matrix1);
        printMatrix(result1);


    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
