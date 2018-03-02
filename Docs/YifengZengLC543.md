#**LeetCode 543**
---
https://leetcode.com/problems/diameter-of-binary-tree/description/

Yifeng Zeng

#题目描述
---
[543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/description/)


#思路报告
---

(This is similar with LC124)

This is a leaf-to-parent-to-leaf path length. So we can split this path into two parts. A leftleaf-to-parent and rightleaf-to-parent length. For any parent node, we compare the global maximum to left+right. And we choose a longer length between left and right plus 1 (current parent length) to return so that the upper layer of recursion can get the longest path.

代码如下：
```java
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
```

#套路总结
---
- If we need information from left/right child and do not need pass any parent information down to children, we can just use bottom up method.
- Use int[] max = new int[1]; instead of a global variable.
