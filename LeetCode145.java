class Solution {

    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}



public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
        return res;
    }

    List<Integer> leftList = postorderTraversal(root.left);
    List<Integer> rightList = postorderTraversal(root.right);

    res.addAll(leftList);
    res.addAll(rightList);
    res.add(root.val);

    return res;
}



public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
        return res;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        res.add(cur.val);
        if (cur.left != null) {
            stack.push(cur.left);
        }
        if (cur.right != null) {
            stack.push(cur.right);
        }
    }

    Collections.reverse(res);
    return res;
}



class Pair {
    TreeNode node;
    boolean print;
    public Pair(TreeNode node, boolean print) {
        this.node = node;
        this.print = print;
    }
}

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
        return res;
    }

    Deque<Pair> stack = new ArrayDeque<>();
    stack.push(new Pair(root, false));

    while (!stack.isEmpty()) {
        Pair cur = stack.pop();
        if (cur.node == null) {
            continue;
        }
        if (cur.print) {
            res.add(cur.node.val);
        } else {
            stack.push(new Pair(cur.node, true));
            stack.push(new Pair(cur.node.right, false));
            stack.push(new Pair(cur.node.left, false));
        }
    }

    return res;
}