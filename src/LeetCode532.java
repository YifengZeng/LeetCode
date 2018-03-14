class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int count = 0;
        for (int n : map.keySet()) {
            if (k == 0 && map.get(n) > 1) {
                count++;
            } else if (k != 0) {
                if (map.containsKey(n + k)) {
                    count++;
                }
                if (map.containsKey(n - k)) {
                    count++;
                }
            }
        }

        return k == 0 ? count : count / 2;
    }
}
