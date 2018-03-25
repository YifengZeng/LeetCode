public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = q.poll();
                if (i < size - 1) {
                    cur.next = q.peek();
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}




public class Solution {

    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode left = root.left;
            while (root != null && root.left != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                root = root.next;
            }
            root = left;
        }
    }
}
