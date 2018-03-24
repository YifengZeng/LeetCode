class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        TreeNode cur = root;
        cur.left = null;
        for (int i = 1; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}




class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);

        if (left == null) {
            return;
        }
        TreeNode node = left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = right;
        root.right = left;
        root.left = null;
    }
}




class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left == null) {
            return right == null ? root : right;
        }
        left.right = root.right;
        root.right = root.left;
        root.left = null;
        return right == null ? left : right;
    }
}




class Solution {

    TreeNode last = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        last = root;
        flatten(root.left);

        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode cur = last;
        flatten(right);
        cur.right = right;
    }
}
