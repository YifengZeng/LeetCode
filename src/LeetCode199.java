public class Solution {
    // DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsHelper(res, root, 0);
        return res;
    }

    private void dfsHelper(List<Integer> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.val);
        }

        dfsHelper(res, root.right, level + 1);
        dfsHelper(res, root.left, level + 1);
    }
}



public class Solution {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (res.size() == level) {
                    res.add(cur.val);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
            level++;
        }

        return res;
    }
}