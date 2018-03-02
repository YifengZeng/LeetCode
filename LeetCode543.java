public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int[] max = new int[1];
    diameterOfBinaryTree(root, max);
    return max[0];
}

private int diameterOfBinaryTree(TreeNode root, int[] max) {
    if (root == null) {
        return 0;
    }

    int left = diameterOfBinaryTree(root.left, max);
    int right = diameterOfBinaryTree(root.right, max);
    max[0] = Math.max(max[0], left + right);
    return Math.max(left, right) + 1;
}