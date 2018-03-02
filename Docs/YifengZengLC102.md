#**LeetCode102**
---
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Yifeng Zeng

#题目描述
---
Binary Tree Level Order Traversal

#思路报告
---

We want to traverse the tree level by level. When traverse the first level, we want to store the next level. What type of data structure can achive that the first next-level-child stored first and come out first. That is a queue. So when we traverse the nodes in this level, we want to put the left/right child of current node into queue so that we can traverse later. The solution would be using a bfs of the root.

代码如下：
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
        return res;
    }

    Deque<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode cur = q.poll();
            level.add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        res.add(level);
    }

    return res;
}
```


#套路总结
---
- Looking for the order of the nodes that has been traversed, from left to right, and in next level we want to traverse left child to right child, so we want to use FIFO data structure queue to save the next level nodes that needs to be traversed.
