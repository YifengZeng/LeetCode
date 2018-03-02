public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
        return root;
    }
    // if (root.left == null && root.right == null && root.val == key) {
    //     return null;
    // }
    TreeNode node = root;
    if (node.val < key) {
        // deleteNode(node.right, key); // 坑
        node.right = deleteNode(node.right, key);
    } else if (node.val > key) {
        // deleteNode(node.left, key); // 坑
        node.left = deleteNode(node.left, key);
    } else if (node.val == key) {
        if (node.left == null) {
            node = node.right;
        } else {
            TreeNode remove = node.left;
            while (remove.right != null) {
                remove = remove.right;
            }
            node.val = remove.val;
            // deleteNode(node.left, remove.val); // 坑
            node.left = deleteNode(node.left, remove.val);
        }
    }
    // return root;
    return node;
}