public class Solution {
    // DP AC
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[] s0 = new int[length + 1];
        int[] s1 = new int[length + 1];
        int[] s2 = new int[length + 1];
        s1[0] = -prices[0];
        for (int i = 1; i <= length; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i-1]);
            s2[i] = s1[i-1] + prices[i-1];
        }

        return Math.max(s0[length], Math.max(s1[length], s2[length]));
    }
}



class Solution {
  // DP AC
  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
        return 0;
    }
    int length = prices.length;
    int[] s0 = new int[2];
    int[] s1 = new int[2];
    int[] s2 = new int[2];
    s1[0] = -prices[0];
    for (int i = 1; i <= length; i++) {
        s0[i % 2] = Math.max(s0[(i - 1) % 2], s2[(i - 1) % 2]);
        s1[i % 2] = Math.max(s1[(i - 1) % 2], s0[(i - 1) % 2] - prices[i - 1]);
        s2[i % 2] = s1[(i - 1) % 2] + prices[i - 1];
    }

    return Math.max(s0[length % 2], Math.max(s1[length % 2], s2[length % 2]));
  }
}
