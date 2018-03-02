public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfsHelper(res, new ArrayList<>(), nums, visited);
        return res;
    }

    private void dfsHelper(List<List<Integer>> res,
                          List<Integer> permutation,
                          int[] nums,
                          int[] visited) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                permutation.add(nums[i]);
                visited[i] = 1;
                dfsHelper(res, permutation, nums, visited);
                permutation.remove(permutation.size() - 1);
                visited[i] = 0;
            }
        }
    }
}