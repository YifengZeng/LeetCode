class Solution {
  // TLE
  public int coinChange(int[] coins, int amount) {
      Arrays.sort(coins);
      int[] min = new int[1];
      min[0] = Integer.MAX_VALUE;
      coinChange(coins, amount, 0, 0, min);
      return min[0] == Integer.MAX_VALUE ? -1 : min[0];
  }

  private void coinChange(int[] coins, int amount, int numCoins,
                          int index, int[] min) {
      if (amount == 0) {
          min[0] = Math.min(min[0], numCoins);
          return;
      }
      if (amount < 0 || index >= coins.length) {
          return;
      }

      // Choose current index
      coinChange(coins, amount - coins[index], numCoins + 1, index, min);
      // Not choose current index
      coinChange(coins, amount, numCoins, index + 1, min);
  }
}



public int coinChange(int[] coins, int amount) {
    if (amount <= 0) {
        return 0;
    }
    Arrays.sort(coins);
    int[] f = new int[amount + 1];
    Arrays.fill(f, Integer.MAX_VALUE);
    f[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i && f[i - coins[j]] != Integer.MAX_VALUE) {
                f[i] = Math.min(f[i], f[i - coins[j]] + 1);
            }
        }
    }
    return f[amount] > amount ? -1 : f[amount];
}



class Solution {
    // TLE
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        helper(coins, amount, 0, 0, min);
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }

    private void helper(int[] coins, int amount, int index,
                        int count, int[] min) {
        if (amount == 0) {
            min[0] = Math.min(min[0], count);
            return;
        }

        if (amount < 0 || index > coins.length) {
            return;
        }

        for (int i = index; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                break;
            }
            helper(coins, amount - coins[i], i, count + 1, min);
        }
    }
}



class Solution {
    // for loop dfs with memo AC
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        return helper(coins, amount, 0, memo);
    }

    private int helper(int[] coins, int amount, int index, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || index > coins.length) {
            return -1;
        }
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                break;
            }

            int temp = helper(coins, amount - coins[i], i, memo);
            if (temp != -1) {
                res = Math.min(res, temp + 1);
            }
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }
}
