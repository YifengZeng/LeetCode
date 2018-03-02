public int countNodes(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int count = 0;
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        count++;
        if (cur.right != null) {
            stack.push(cur.right);
        }
        if (cur.left != null) {
            stack.push(cur.left);
        }
    }

    return count;
}




public int countNodes(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int left = findH(root.left);
    int right = findH(root.right);

    if (left == right) {
        return (1 << left) + countNodes(root.right);
    }

    return (1 << right) + countNodes(root.left);
}

private int findH(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int h = 1;
    while (root.left != null) {
        root = root.left;
        h++;
    }
    return h;
}