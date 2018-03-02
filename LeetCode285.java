public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) {
        return root;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    TreeNode res = null;
    boolean found = false;

    while (!stack.isEmpty() || cur != null) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();

        if (found) {
            return cur;
        }
        if (cur == p) {
            found = true;
        }

        cur = cur.right;
    }

    return res;
}



public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) {
        return null;
    }

    if (root.val > p.val) {
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    } else if (root.val < p.val) {
        return inorderSuccessor(root.right, p);
    }
    if (root.right == null) {
        return null;
    }
    root = root.right;
    while (root.left != null) {
        root = root.left;
    }
    return root;
}