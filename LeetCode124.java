public int maxPathSum(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int[] max = new int[1];
    max[0] = root.val;
    maxPathSum(root, max);
    return max[0];
}

private int maxPathSum(TreeNode root, int[] max) {
    if (root == null) {
        return 0;
    }

    int left = maxPathSum(root.left, max);
    int right = maxPathSum(root.right, max);

    int ret = Math.max(root.val, Math.max(left + root.val, right + root.val));
    max[0] = Math.max(max[0], Math.max(ret, left + root.val + right));
    return ret;
}