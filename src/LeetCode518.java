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
