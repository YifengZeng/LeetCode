class Solution {
    // AC
    public int countCornerRectangles(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid[0].length - 1; i++) {
            for (int j = i + 1; j < grid[0].length; j++) {
                int onePairs = getPairs(grid, i, j);
                sum += combination(onePairs);
            }
        }

        return sum;
    }

    private int getPairs(int[][] grid, int i, int j) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            if (grid[r][i] == 1 && grid[r][j] == 1) {
                count++;
            }
        }
        return count;
    }

    private int combination(int n) {
        if (n < 2) {
            return 0;
        }
        return n * (n - 1) / 2;
    }
}
