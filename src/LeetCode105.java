class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder,
                            int preIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = inStart;
        while (index <= inEnd) {
            if (inorder[index] == preorder[preIndex]) {
                break;
            }
            index++;
        }

        root.left = helper(preorder, inorder, preIndex + 1, inStart, index - 1);
        root.right = helper(preorder, inorder, preIndex
                            + (index - inStart) + 1, index + 1, inEnd);
        return root;
    }
}
