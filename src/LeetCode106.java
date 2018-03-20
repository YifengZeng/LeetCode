class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1,
                      0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder,
                            int postIndex, int inStart, int inEnd) {
        if (inStart > inEnd || postIndex < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = inStart;
        while (index <= inEnd) {
            if (inorder[index] == postorder[postIndex]) {
                break;
            }
            index++;
        }
        root.right = helper(inorder, postorder, postIndex - 1,
                            index + 1, inEnd);
        root.left = helper(inorder, postorder, postIndex - (inEnd - index) - 1,
                           inStart, index - 1);
        return root;
    }
}
