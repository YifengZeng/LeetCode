public boolean isValidBST(TreeNode root) {
    if (root == null) {
        return true;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    TreeNode prev = null;
    Boolean isFirst = true;

    while (!stack.isEmpty() || cur != null) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        if (isFirst) {
            prev = cur;
            isFirst = false;
        } else {
            if (cur.val <= prev.val) {
                return false;
            }
            prev = cur;
        }
        cur = cur.right;
    }

    return true;
}


class Pair {
    TreeNode node;
    boolean print;
    public Pair(TreeNode node, boolean print) {
        this.node = node;
        this.print = print;
    }
}

public boolean isValidBST(TreeNode root) {
    if (root == null) {
        return true;
    }

    Deque<Pair> stack = new ArrayDeque<>();
    stack.push(new Pair(root, false));
    boolean isFirst = true;
    TreeNode prev = null;

    while (!stack.isEmpty()) {
        Pair cur = stack.pop();
        if (cur.node == null) {
            continue;
        }

        if (cur.print) {
            if (isFirst) {
                isFirst = false;
            } else {
                if (cur.node.val <= prev.val) {
                    return false;
                }
            }
            prev = cur.node;
        } else {
            stack.push(new Pair(cur.node.right, false));
            stack.push(new Pair(cur.node, true));
            stack.push(new Pair(cur.node.left, false));
        }
    }

    return true;
}