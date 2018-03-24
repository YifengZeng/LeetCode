class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }

        if (root.val <= V) {
            TreeNode[] temp = splitBST(root.right, V);
            root.right = temp[0];
            res[0] = root;
            res[1] = temp[1];
        } else {
            TreeNode[] temp = splitBST(root.left, V);
            root.left = temp[1];
            res[0] = temp[0];
            res[1] = root;
        }

        return res;
    }
}
