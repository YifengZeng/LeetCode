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
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode head = dummy;
        while (root != null) {
            while (root != null) {
                if (root.left != null) {
                    head.next = root.left;
                    head = head.next;
                }
                if (root.right != null) {
                    head.next = root.right;
                    head = head.next;
                }
                root = root.next;
            }
            root = dummy.next;
            dummy.next = null;
            head = dummy;
        }
    }
}
