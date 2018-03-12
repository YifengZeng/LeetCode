class Solution {
    // Primitive DFS without memoization TLE
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            min = Math.min(min, numSquares(n - i * i) + 1);
            if (min == 1) {
                break;
            }
        }
        return min;
    }
}



class Solution {
    //DFS + memo + no much pruning TLE
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n <= 0) {
            return 0;
        }
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            min = Math.min(min, numSquares(n - i * i) + 1);
            if (min == 1) {
                break;
            }
        }
        return memo[n] = min;
    }
}



class Solution {
    // DP AC
    public int numSquares(int n) {
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) {
            f[i] = i; // at most number i of 1s
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j*j] + 1);
            }
        }
        return f[n];
    }
}
