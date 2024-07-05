import java.util.*;
public class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int m = image.length;
        int n = image[0].length;
        int origColor = image[sr][sc];

        if (newColor == origColor)
        {
            return image;
        }

        dfs(image, sr, sc, origColor, newColor, m, n);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int origColor, int newColor, int m, int n) {


        image[row][col] = newColor;

        if (row > 0 && image[row - 1][col] == origColor)
        {
            dfs(image, row - 1, col, origColor, newColor, m, n);
        }
        if (row < m - 1 && image[row + 1][col] == origColor)
        {
            dfs(image, row + 1, col, origColor, newColor, m, n);
        }
        if (col > 0 && image[row][col - 1] == origColor) {
            dfs(image, row, col - 1, origColor, newColor, m, n);
        }
        if (col < n - 1 && image[row][col + 1] == origColor) {
            dfs(image, row, col + 1, origColor, newColor, m, n);
        }
    }

    public static void main(String[] args) {
        Flood_Fill solution = new Flood_Fill();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
