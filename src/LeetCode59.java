class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int top = 0;
        int bot = n - 1;
        int left = 0;
        int right = n - 1;

        while (count <= n * n) {
            for (int i = left; i <= right && count <= n * n; i++) {
                res[top][i] = count++;
            }
            top++;
            for (int i = top; i <= bot && count <= n * n; i++) {
                res[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left && count <= n * n; i--) {
                res[bot][i] = count++;
            }
            bot--;

            for (int i = bot; i >= top && count <= n * n; i--) {
                res[i][left] = count++;
            }
            left++;
        }

        return res;
    }
}
