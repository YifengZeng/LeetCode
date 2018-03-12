class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[amount + 1][coins.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(amount, coins, 0, memo);
    }

    private int helper(int amount, int[] coins, int index, int[][] memo) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index >= coins.length) {
            return 0;
        }
        if (memo[amount][index] != -1) {
            return memo[amount][index];
        }

        int number = 0;
        // if we choose index
        if (amount - coins[index] >= 0) {
            number += helper(amount - coins[index], coins, index, memo);
        }
        // if we not choose index
        number += helper(amount, coins, index + 1, memo);
        return memo[amount][index] = number;
    }
}



class Solution {
    // DP AC
    public int change(int amount, int[] coins) {
        int[][] f = new int[coins.length + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            f[i][0] = 1;
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                if (j - coin >= 0) {
                    f[i][j] += f[i][j - coin];
                }
            }
        }
        return f[coins.length][amount];
    }
}



class Solution {
    // DP space optimization AC
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - coin >= 0) {
                    f[j] += f[j - coin];
                }
            }
        }
        return f[amount];
    }
}
